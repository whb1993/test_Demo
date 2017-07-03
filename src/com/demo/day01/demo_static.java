package com.demo.day01;

/**
 * Created by Administrator on 2017/6/6.
 */
public class demo_static {
    static int value = 33;

    public static void main(String[] args) throws Exception{
        new demo_static().printValue();
    }

    private void printValue(){
        int value = 3;
        System.out.println(this.value);
    }
}
