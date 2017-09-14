package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/9/9 11:36.
 */
public class DemoTest extends Thread {
    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        InterruptDemo demo = new InterruptDemo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();

    }
}
