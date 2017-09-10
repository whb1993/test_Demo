package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/8/31 14:07.
 * 线程初识
 * 继承Thread类创建线程
 */
public class Thread01 extends Thread{
    private int i = 5;

    public Thread01() {
        System.out.println("this-isAlive="+this.isAlive());

        System.out.println("current-isAlive="+Thread.currentThread().isAlive());
        System.out.println("this--current-getName="+this.currentThread().getName());
        System.out.println("Thread--current-getName="+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        // for ( ; i < 100 ; i++) {
        //     System.out.println(getName() + " "+ i);
        // }
        // System.out.println("i="+(i--)+"thread-Name="+Thread.currentThread().getName());
        // System.out.println(this.getName());
        System.out.println("this--current-getName="+this.currentThread().getName());
        System.out.println("Thread--current-getName="+Thread.currentThread().getName());
        System.out.println("thread-Name="+Thread.currentThread().getName()+Thread.currentThread().isAlive());
        System.out.println("thread-Name="+Thread.currentThread().getName()+this.isAlive());
        System.out.println("i="+(i--));
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // for (int i = 0; i < 100; i++) {
        //     System.out.println(Thread.currentThread().getName()+i);
        //     if(i == 20){
        //         new Thread01().start();
        //         new Thread01().start();
        //         new Thread01().start();
        //     }
        // }
        Thread01 thread = new Thread01();

        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        thread.start();
        thread1.start();
        thread2.start();
        // new Thread(thread01).start();
        // new Thread(thread01).start();
    }
}
