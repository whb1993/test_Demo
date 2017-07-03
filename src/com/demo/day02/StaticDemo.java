package com.demo.day02;

/**
 * Created by Administrator on 2017/6/7.
 */
public class StaticDemo {
    {
        System.out.println("****普通代码块");
    }
    static {
        System.out.println("****静态代码块");
    }
    StaticDemo (){
        System.out.println("****构造函数");
    }
    public static void main(String args[]){
//        StaticTest staticTest = new StaticTest();
//        StaticTest StaticTest1 = new StaticTest();
        StaticTest staticTest1 = new StaticTest1();
        StaticDemo staticDemo = new StaticDemo();
    }
}

class StaticTest{
    {
        System.out.println("普通代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    StaticTest (){
        System.out.println("构造函数");
    }
    {
        System.out.println("普通代码块2");
    }
}

class StaticTest1 extends StaticTest{
    static {
        System.out.println("--静态代码块");
    }
    StaticTest1 (){
        System.out.println("--构造函数");
    }
    {
        System.out.println("--普通代码块");
    }
}