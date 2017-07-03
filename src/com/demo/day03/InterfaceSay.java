package com.demo.day03;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface InterfaceSay
{
    public void say();
    default public void sayhi()
    {
        System.out.println("hello world");
    }

}
