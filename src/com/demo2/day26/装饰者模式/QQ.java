package com.demo2.day26.装饰者模式;

/**
 * Created by whb on 2017/7/18.
 */
public class QQ implements Car {
    @Override
    public void run() {
        System.out.println("qq run");
    }

    @Override
    public void stop() {
        System.out.println("qq ting");
    }
}
