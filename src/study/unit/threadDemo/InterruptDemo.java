package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/9/9 11:34.
 * 停止线程
 */
public class InterruptDemo extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("begin");
            for (int i = 0; i < 700000; i++) {
                System.out.println(Thread.currentThread().getName()+"i="+i);
                // if(this.interrupted()){
                //     System.out.println("停止了");
                //     throw new InterruptedException();
                // }
            }
            Thread.sleep(100000);
            System.out.println("This end");


            System.out.println("其他语句");
        } catch (InterruptedException e) {
            System.out.println("状态"+this.interrupted());
            System.out.println("进入catch");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InterruptDemo interruptDemo = new InterruptDemo();
        Thread thread1 = new Thread(interruptDemo);
        Thread thread2 = new Thread(interruptDemo);
        // try {
            thread1.start();
            // thread2.start();
            // thread1.sleep(1000);
            // thread1.interrupt();
            // sleep(1200);
            thread1.interrupt();
            // sleep(2000);
            // thread2.interrupt();
            System.out.println("main还有没？？？");
            // System.out.println("是否停止"+Thread.currentThread().isInterrupted());
            //
            // System.out.println("是否停止"+Thread.currentThread().isInterrupted());
            // System.out.println("是否停止"+Thread.currentThread().isInterrupted());
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        System.out.println("end");
    }
}
