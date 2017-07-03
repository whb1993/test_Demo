package com.demo.day02;

/**
 * Created by Administrator on 2017/6/7.
 */
class Value3 {
    static int c = 0;
    Value3() {
        c = 15;
    }
    Value3(int i) {
        c = i;
    }
    static void inc() {
        c++;
    }
}
public class Count {
    public static void prt(String s) {
        System.out.println(s);
    }
    Value3 v = new Value3(10);
    static Value3 v1, v2;
    static {//此即为static块
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v1 = new Value3(27);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v2 = new Value3(15);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
    }
    public static void main(String[] args) {
        Count ct = new Count();
        prt("ct.c=" + ct.v.c);

        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);

        v1.inc();

        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);

        prt("ct.c=" + ct.v.c);

    }

}