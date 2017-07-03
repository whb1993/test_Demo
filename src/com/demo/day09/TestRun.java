package com.demo.day09;

/**
 * Created by whb on 2017/6/16.
 */
public class TestRun  {
    public static void main(String argv[])throws InterruptedException{
        Thread t=new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("2");
            }
        });

        System.out.print("1");
        t.start();

        t.join();
    }
}
