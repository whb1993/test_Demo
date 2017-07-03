package com.demo.day09;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.nmap4j.Nmap4j;
import org.nmap4j.core.nmap.ExecutionResults;
import org.nmap4j.data.NMapRun;
import org.nmap4j.data.host.Address;
import org.nmap4j.data.host.ports.Port;
import org.nmap4j.data.nmaprun.Host;

    /**
     * Thread class which can monitor and log reachability of N ports on M servers.
     * Once initial state is recorded and logged, subsequent scans only log state changes.
     * Each thread can monitor N ports on M servers with a single scan sweep, and you
     * can run multiple threads for different combinations of ports, servers, and protocols.
     * The underlying scanning tool is NMAP, and NMAP4J is used to wrap those calls
     * for configuration and output/error parsing convenience.
     * @author justin.cranford
     */
    public class ServerReachabilityMonitor extends Thread {
        private static final Logger LOGGER = Logger.getLogger("");

        private final static boolean DUMP_NMAP4J_OUTPUT = true;
        private final static boolean DUMP_NMAP4J_DEBUG  = false;
        private final static boolean WORKAROUND_NMAPRUN_XML_PARSE_CONCURRENCY_BUG = true;   // workaround suspected Nmap4j concurrency issue with parsing NmapRun XML results

        public static final String JVM_PROP_OSNAME = System.getProperty("os.name");
        public static final boolean JVM_PROP_ISWIN = JVM_PROP_OSNAME.toLowerCase().startsWith("win");

        private ArrayList<String>  addresses; // each element is an address, FQDN, or hostname
        private ArrayList<Integer> ports;     // each element is integer 1-65535, or a range of integers
        private String             protocol;    // TCP_SYN, TCP_CONNECT, or UDP (Example: TCP_SYN works for 443 on Xsuite, but not 443 on PA Windows, so you might have to use TCP_CONNECT)

        public ServerReachabilityMonitor(final ArrayList<String> addresses, final ArrayList<Integer> ports, final String protocol) {
            this.addresses = new ArrayList<>(addresses);
            this.ports     = new ArrayList<>(ports);
            this.protocol  = protocol;
            this.setPriority(Thread.MIN_PRIORITY);  // avoid hogging CPU if normal priority threads
            this.setDaemon(true);                   // stop when JVM stops
            this.setContextClassLoader(null);       // release Tomcat 6+ WebAppClassLoader reference to avoid blocking war unloading during reload or stop
            this.setName("ServerReachabilityMonitor");
        }

        public ServerReachabilityMonitor(final String address, final ArrayList<Integer> ports, final String protocol) {
            this.addresses = new ArrayList<>(1);
            this.addresses.add(address);
            this.ports     = new ArrayList<>(ports);
            this.protocol  = protocol;
            this.setPriority(Thread.MIN_PRIORITY);  // avoid hogging CPU if normal priority threads
            this.setDaemon(true);                   // stop when JVM stops
            this.setContextClassLoader(null);       // release Tomcat 6+ WebAppClassLoader reference to avoid blocking war unloading during reload or stop
            this.setName("ServerReachabilityMonitor");
        }

        public void run() {
            final String addressesStr = CollectionToString(this.addresses, ",");
            final String portsStr     = CollectionToString(this.ports, ",");

            HashMap<String,TreeMap<Integer,String>> previousAddressToPortAndState = null, currentAddressToPortAndState = null;
            int  scanAttempts  = 0;
            long scanTotalTime = 0L, scanCurrentStartTime = 0L, scanCurrentElapsedTime = 0L;
//        while (true) {
            try {
                LOGGER.log(Level.WARNING, "ServerReachabilityMonitor.run Scanning addresses '" + addressesStr + "', ports '" + portsStr + "', protocol '" + this.protocol + "'.");
                try {
                    scanCurrentStartTime = System.nanoTime();
                    currentAddressToPortAndState  = performNmapScan(this.addresses, this.ports, this.protocol);
                } catch(Exception e) {
                    LOGGER.log(Level.INFO, "ServerReachabilityMonitor.run Server '" + addressesStr + "' scan failed.", e);
                } finally {
                    scanCurrentElapsedTime = System.nanoTime() - scanCurrentStartTime;  // nanoseconds to execute check, so we can log fraction of milliseconds in LAN
                    if (scanCurrentElapsedTime < 0L) {
                        scanCurrentElapsedTime = 0L;    // watch out for negatives
                    }
                    scanTotalTime += scanCurrentElapsedTime;
                    scanAttempts++;
                    LOGGER.log(Level.WARNING, "ServerReachabilityMonitor.run Scanned addresses '" + addressesStr + "', ports '" + portsStr + "', protocol '" + this.protocol + "' in time="+(scanCurrentElapsedTime/1000000F)+"ms [Total="+(scanTotalTime/1000000F)+"ms, Count="+scanAttempts+", Average="+((float) scanTotalTime / (float) scanAttempts / 1000000F)+"ms].");
                }
                if (null == currentAddressToPortAndState) { // log port-level state differences between current scan and previous scan
                    LOGGER.log(Level.WARNING, "ServerReachabilityMonitor.run No results.");
                } else {
                    LOGGER.log(Level.WARNING, "ServerReachabilityMonitor.run Checking results.");
                    for (String currentAddress : this.addresses) {
                        TreeMap<Integer,String> differentPortAndState = new TreeMap<>();

                        // retrieve previous state, or use empty map for previous state
                        TreeMap<Integer,String> previousPortAndState;
                        if (null == previousAddressToPortAndState) {
                            previousPortAndState = new TreeMap<>();
                        } else {
                            previousPortAndState = previousAddressToPortAndState.get(currentAddress);
                            if (null == previousPortAndState) {
                                previousPortAndState = new TreeMap<>();
                            }
                        }

                        // compare current state to previous state
                        TreeMap<Integer,String> currentPortAndState = currentAddressToPortAndState.get(currentAddress);
                        int numPortStateChanges = 0;
                        for (Integer port : this.ports) {
                            final String previousState = previousPortAndState.get(port);
                            final String currentState  = (null == currentPortAndState ? null : currentPortAndState.get(port));
                            if (null == currentState) {
                                if (null == previousState) {
                                    differentPortAndState.put(port, port.toString()+"=<no data>");                                // STILL NO DATA
                                } else {
                                    differentPortAndState.put(port, port.toString()+"=<removed> ("+previousState+")");            // DISAPPEARED
                                    numPortStateChanges++;
                                }
                            } else {
                                if (null == previousState) {
                                    differentPortAndState.put(port, port.toString()+"="+currentState+" <new>");                   // FIRST DATA
                                    numPortStateChanges++;
                                } else if (! currentState.equals(previousState)) {
                                    differentPortAndState.put(port, port.toString()+"="+currentState+" ("+previousState+")");   // CHANGED
                                    numPortStateChanges++;
                                }
                            }
                        }

                        // log if one or more port-level states changed (or log level >= FINE)
                        if (numPortStateChanges > 0) {
                            LOGGER.log(Level.WARNING, "ServerReachabilityMonitor.run Server '" + currentAddress + "' reachability changed: " + CollectionToString(differentPortAndState.values(), ", "));
                        } else {
                            LOGGER.log(Level.WARNING, "ServerReachabilityMonitor.run Server '" + currentAddress + "' reachability did not change");
                        }

                        // if no current scan result, copy previous scan to current results so we can carry it forward to next comparison
                        if (null == currentPortAndState) {
                            if (null != previousAddressToPortAndState) {
                                currentAddressToPortAndState.put(currentAddress, previousPortAndState);
                            }
                        }
                    }

                    // copy current scan results to previous for next scan comparison
                    previousAddressToPortAndState = currentAddressToPortAndState;
                    currentAddressToPortAndState = null;
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "ServerReachabilityMonitor.run Unexpected Exception.", e);
            }
//        }
        }

        private static final String NMAP_PROTOCOL_TCP_SYN     = "TCP_SYN";
        private static final String NMAP_PROTOCOL_TCP_CONNECT = "TCP_CONNECT";
        private static final String NMAP_PROTOCOL_TCP_UDP     = "UDP";
        private static final String NMAP_PATH_WINDOWS         = "F:/VMP/nmap";
        private static final String NMAP_PATH_UNIX            = "/usr/bin/nmap";
        private static final String NMAP_OPTIONS_TCP_SYN      = "-n -T4 -sS -PN --disable-arp-ping --max-scan-delay 0ms --min-rate 1000000 --max-retries 0 -p ";    // TCP SYN scan
        private static final String NMAP_OPTIONS_TCP_CONNECT  = "-n -T4 -sT -PN --disable-arp-ping --max-scan-delay 0ms --min-rate 1000000 --max-retries 0 -p ";    // TCP connect scan
        private static final String NMAP_OPTIONS_UDP          = "-n -T4 -sU -PN --disable-arp-ping --max-scan-delay 0ms --min-rate 1000000 --max-retries 0 -p ";    // UDP scan
        private static HashMap<String, TreeMap<Integer, String>> performNmapScan(ArrayList<String> addresses, ArrayList<Integer> ports, String protocol) throws Exception {
            final HashMap<String, TreeMap<Integer, String>> addressToPortAndState = new HashMap<>();
            final String nmapAddresses = CollectionToString(addresses," ");
            final String nmapOptions;
            if (protocol.equals(NMAP_PROTOCOL_TCP_SYN)) {
                nmapOptions = NMAP_OPTIONS_TCP_SYN     + CollectionToString(ports,",");
            } else if (protocol.equals(NMAP_PROTOCOL_TCP_CONNECT)) {
                nmapOptions = NMAP_OPTIONS_TCP_CONNECT + CollectionToString(ports,",");
            } else if (protocol.equals(NMAP_PROTOCOL_TCP_UDP)) {
                nmapOptions = NMAP_OPTIONS_UDP         + CollectionToString(ports,",");
            } else {
                throw new Exception("ServerReachabilityMonitor.run Unsupported protocol '" + protocol + "'.");
            }
            Nmap4j nmap4j = new Nmap4j(JVM_PROP_ISWIN ? NMAP_PATH_WINDOWS : NMAP_PATH_UNIX);
            nmap4j.includeHosts(nmapAddresses);
            nmap4j.addFlags(nmapOptions);
            nmap4j.execute();
            if (!nmap4j.hasError()) {
                String addressStr;
                Integer portNum;
                String stateStr;
                TreeMap<Integer,String> portStatesForAddress;
                NMapRun nmapRun;
                // workaround suspected Nmap4j concurrency issue with parsing NmapRun XML results?
                if (ServerReachabilityMonitor.WORKAROUND_NMAPRUN_XML_PARSE_CONCURRENCY_BUG) {
                    synchronized (ServerReachabilityMonitor.class) {
                        nmapRun = nmap4j.getResult();
                    }
                } else {
                    nmapRun = nmap4j.getResult();
                }
                if (DUMP_NMAP4J_OUTPUT) {
                    // Dump Nmap4j output, and indicate if Nmap4j.getResult() returned good NmapRun)
                    LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK: "+(null!=nmapRun)+"): " + nmap4j.getOutput());
                }
                if (null == nmapRun) {
                    ExecutionResults executionResults = nmap4j.getExecutionResults();
                    if (null == executionResults) {
                        LOGGER.log(Level.SEVERE, "NULL NmapRun, NULL ExecutionResults");
                    } else {
                        LOGGER.log(Level.SEVERE, "NULL NmapRun, ExecutionResults.getOutput: " + executionResults.getOutput());
                        LOGGER.log(Level.SEVERE, "NULL NmapRun, ExecutionResults.getErrors: " + executionResults.getErrors());
                    }
                } else {
                    if (DUMP_NMAP4J_DEBUG) {
                        LOGGER.log(Level.WARNING, "ARGS:  " + nmapRun.getArgs());
                        LOGGER.log(Level.WARNING, "DEBUG: " + nmapRun.getDebugging());
                    }
                    for (Host host : nmapRun.getHosts()) {
                        for (Address address : host.getAddresses()) {
                            addressStr = address.getAddr();
                            for (Port port : host.getPorts().getPorts()) {
                                portStatesForAddress = addressToPortAndState.get(addressStr);
                                if (null == portStatesForAddress) {
                                    portStatesForAddress = new TreeMap<>();
                                    addressToPortAndState.put(addressStr, portStatesForAddress);
                                }
                                portNum  = new Integer((int)port.getPortId());
                                stateStr = port.getState().getState();
                                portStatesForAddress.put(portNum, stateStr);
                            }
                        }
                    }
                }
            } else {
                throw new Exception("ServerReachabilityMonitor.run Scan failed: " + nmap4j.getExecutionResults().getErrors());
            }
            return addressToPortAndState;
        }

        public static String CollectionToString(Collection<? extends Object> inputCollection, String delimiter) {
            StringBuilder result = new StringBuilder();
            if (inputCollection != null) {
                for (Object object : inputCollection) {
                    result.append(object).append(delimiter);
                }
            }
            return(0 == result.length() ? "" : result.substring(0, result.length()-delimiter.length()));
        }
        public static void main(String[] args) throws Exception {
            final boolean isNmapConcurrent = false;     // true (single nmap thread scanning multiple addresses), false (multiple nmap threads scanning single addresses)
            final String protocol = NMAP_PROTOCOL_TCP_CONNECT;
            final ArrayList<Integer> ports = new ArrayList<>();
            {
                ports.add(new Integer(21));    // HTTPS
                ports.add(new Integer(3389));   // MySQL
                ports.add(new Integer(45962));   // Hazelcast
                ports.add(new Integer(7900));   // JGroups
                ports.add(new Integer(7901));   // JGroups
            }
            final ArrayList<String> addresses = new ArrayList<>();
            {
//            addresses.add("10.1.10.23");    // remote DNS server (unknown)
//            addresses.add("10.1.10.164");   // remote Debian 5 x32 test build (VMware ESX VM)
//            addresses.add("10.1.200.181");  // remote Debian 5 x32 test build (VMware ESX VM)
//            addresses.add("10.20.0.144");   // localhost Windows 7 Pro x64 (VMware Workstation VM)
                addresses.add("192.168.28.241");   // LAN Windows Server 2003 R2 x32 DNS server (VMware ESX VM)
            }

            if (isNmapConcurrent) {
                new ServerReachabilityMonitor(addresses, ports, protocol).run();    // single nmap call in main() thread (never returns)
            } else {
                for (String address : addresses) {
                    new ServerReachabilityMonitor(address, ports, protocol).start();    // separate nmap calls to scan addresses separately
                }
                Thread.sleep(Long.MAX_VALUE);   // do not allow "main" thread to return and join, otherwise JVM will stop because ServerReachabilityMonitor threads have daemon=true
            }
        }
    }
