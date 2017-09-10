package study.unit.threadDemo;

/**
 * Created by wanghongbin on 2017/9/9 18:24.
 */
public class StopThread extends Thread{
    int i = 0;
    @Override
    public void run() {
        super.run();
        while (true){
            // try {
                System.out.println(i++);

                this.stop();
                //Thread.currentThread().sleep(1000);
            // }catch (ThreadDeath e) {
            //     System.out.println("stop");
            //     e.printStackTrace();
            // }
        }

    }

    public static void main(String[] args) {
        test t = new test();
        Mythread thread = new Mythread(t);

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
        System.out.println(t.getName()+t.getAge());
        System.out.println("end");
    }
}

class test{
    private String name = "a";
    private String age = "1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    synchronized public void printString(String name,String age){
    this.name = name;
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.age=age;
    }
}
    class Mythread extends Thread{
        private test test;
        public Mythread(test test){
            super();
            this.test = test;
        }
        public void run(){
            System.out.println("run");
            test.printString("b","2");
        }
    }
