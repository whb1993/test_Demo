package study.unit.thread_demo;

/**
 * Created by 王红彬 on 2017/9/7.
 */
public class MyThread02 implements Runnable{
    private int num = 7;
    @Override
    public void run() {
        System.out.println(num--);
    }
}
