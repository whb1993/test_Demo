package com.demo.day07;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/6/14.
 */
public class Log4jTest {
    static {
//读取配置
        String currentDir = System.getProperty("user.dir");
        PropertyConfigurator.configure(currentDir + "/config/log4j.properties");
//如果是xml配置
//DOMConfigurator.configure(currentDir+"/conf/log4j.xml");
//此外还可以调用configureAndWatch监听配置的变动并重新加载。
    }
    private static final Logger LOGGER = Logger.getLogger("");

    public static void main(String[] args) {
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.INFO, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.INFO, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.INFO, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.INFO, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.INFO, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.ALL, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.WARNING, "OUTPUT (NmapRun OK)");
        LOGGER.log(Level.INFO, "OUTPUT (NmapRun OK)");


    }
}
