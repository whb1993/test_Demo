package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/9/10 10:39.
 * 守护线程
 */
public class DaemonDemo extends Thread {
    int i = 0;

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i++);
        }

    }

    public static void main(String[] args) {
        DaemonDemo demo = new DaemonDemo();
        Thread thread1 = new Thread(demo);
        thread1.setDaemon(true);
        thread1.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}