package study.unit.thread_demo;

/**
 * Created by Administrator on 2017/9/6.
 * 继承Thread添加线程
 */
public class MyThread extends Thread{
    private int i =9;
//    @Override
//    public void run() {
//        super.run();
//        System.out.println("MyThread");
//    }
//    @Override
//    public void run() {
//        super.run();
//        try {
//            for (int i = 0; i < 10; i++) {
//                int time = (int)(Math.random()*1000);
//                Thread.sleep(time);
//                System.out.println("***"+Thread.currentThread().getName());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public void run() {
        super.run();
        System.out.println(i--);
    }


}
