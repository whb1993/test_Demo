package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/8/31 14:07.
 * 线程初识
 * 继承Thread类创建线程
 */
public class Thread01 extends Thread{
    private int i;

    @Override
    public void run() {
        for ( ; i < 100 ; i++) {
            System.out.println(getName() + " "+ i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            if(i == 20){
                new Thread01().start();
                new Thread01().start();
            }
        }
    }
}
