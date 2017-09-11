package study.unit.thread_demo;

import org.junit.Test;

/**
 * Created by 王红彬 on 2017/9/6.
 * 多线程
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        Thread b =new Thread(myThread,"1");
        Thread c =new Thread(myThread,"2");
        b.start();
        c.start();
        myThread.start();
        myThread2.start();
        myThread.setName("myThread");

    }

    @Test
    public void test(){
        Runnable myThread = new MyThread02();
        Runnable myThread1 = new MyThread02();
        Runnable myThread2 = new MyThread02();
        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread.start();
        thread1.start();
        thread2.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(123);
    }
}
