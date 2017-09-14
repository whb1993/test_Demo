package study.unit.threadDemo;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by wanghongbin on 2017/9/11 10:12.
 */
public class YieldDemo extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().yield();
        }
    }

    public static void main(String[] args) {
        YieldDemo demo = new YieldDemo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        Thread thread3 = new Thread(demo);
        thread1.setPriority(1);
        thread2.setPriority(5);
        thread3.setPriority(10);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}