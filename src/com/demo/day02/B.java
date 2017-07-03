package com.demo.day02;

/**
 * Created by Administrator on 2017/6/7.
 */

public class B
{
    B (){
        System.out.println("构造函数");
    }

    int[][][][] a = new int[1][2][5][];

    {
        System.out.println("构造块");
    }
    public static B t1 = new B();
    public static B t2 = new B();

    static{
        System.out.println("静态块");
    }
void B (){
    System.out.println("success");
}

    public static void main(String[] args)
    {
        B t = new B();
        t.B();
    }
}