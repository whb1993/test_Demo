package com.demo.day05;

/**
 * Created by Administrator on 2017/6/12.
 */
public interface OutPut {
    int year =2017;
    void ceshi();
    default void pt(){
        System.out.println("Hello World");
    }

    static void sp(){
        System.out.println("asd");
    }

}
