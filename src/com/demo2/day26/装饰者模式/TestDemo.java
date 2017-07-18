package com.demo2.day26.装饰者模式;

/**
 * Created by whb on 2017/7/18.
 */
public class TestDemo {
    public static void main(String[] args) {
        QQ qq = new QQ();
        CarWarp carWarp = new CarWarp(qq);
        carWarp.run();
        carWarp.stop();
    }
}
