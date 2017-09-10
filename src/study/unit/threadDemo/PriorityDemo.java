package study.unit.threadDemo;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by wanghongbin on 2017/9/10 10:16.
 */
public class PriorityDemo extends Thread {
    @Override
    public void run() {
        super.run();
        //System.out.println("Name"+Thread.currentThread().getName()+"Run"+Thread.currentThread().getPriority());
        //new demo().start();
        long time = System.currentTimeMillis();
        int max = 0;
        for (int i = 0; i < 5000000; i++) {
            max = i;
            max--;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(Thread.currentThread().getName()+time);
    }

    public static void main(String[] args) {
        PriorityDemo demo = new PriorityDemo();
        //demo.setPriority(1);
        Thread thread1 = new Thread(demo);
        //demo.start();
        //thread1.start();
        //thread1.setPriority(1);
       // System.out.println("main"+Thread.currentThread().getPriority());
        Thread thread2 = new Thread(demo);
        thread1.setName("X1");
        thread2.setName("X2");
        thread1.start();
        thread1.setPriority(10);
        thread2.start();
        thread2.setPriority(1);

    }
}
class demo extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Name"+Thread.currentThread().getName()+"Run"+Thread.currentThread().getPriority());
    }
}