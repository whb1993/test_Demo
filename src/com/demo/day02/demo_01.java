package com.demo.day02;

/**
 * Created by Administrator on 2017/6/7.
 */
public class demo_01 {
    public static void prt(String s) {

        System.out.println(s);

    }



    public static void main(String[] args) {

        Value v1, v2;

        v1 = new Value();

        v2 = new Value();

        Value02 v3 =new Value02();

        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);

        v1.inc();

        prt(" v1.c=" + v1.c + "  v2.c=" + v2.c);

        prt(" v1.c=" + v1.c + "  v3.c=" + v3.c);

        prt(" v1.a=" + v1.a + "  v3.a=" + v3.a);

    }
}

class Value {

    static int c = 0;
    int a =99;


    static void inc() {

        c++;

    }

}

class Value02 extends  Value{
    static  int d = 12;
    int a =8;
}