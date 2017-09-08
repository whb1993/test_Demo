package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/8/31 14:27.
 * 创建线程第二种方式
 * 通过实现接口
 */
public class Thread02 implements Runnable{
    private int i;

    @Override
    public void run() {
        for ( ; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName() + " "+ i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            if(i == 20){
                Thread02 st = new Thread02();
                new Thread(st , "线程1").start();
                new Thread(st , "线程2").start();
            }
        }
    }
}
