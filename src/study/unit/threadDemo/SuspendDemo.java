package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/9/9 19:18.
 */
public class SuspendDemo extends Thread {
    synchronized void printString(){
        System.out.println("begin");
        Thread.currentThread().suspend();
        System.out.println("end");
    }
    private int i = 0;

    public int getI() {
        System.out.println(i);
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run");
        // this.printString();
        System.out.println(System.currentTimeMillis());
        while (i<100000){
            // try {
            //     sleep(11);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            //Thread.yield();
           // System.out.println(i);
            i++;
        }
        System.out.println(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SuspendDemo interruptDemo = new SuspendDemo();
        Thread thread1 = new Thread(interruptDemo);
        Thread thread2 = new Thread(interruptDemo);
        thread1.start();
        //thread2.start();
        try {
            sleep(1000);
            // thread1.suspend();
            System.out.println("end");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}