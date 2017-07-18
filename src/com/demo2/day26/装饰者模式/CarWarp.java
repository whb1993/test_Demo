package com.demo2.day26.装饰者模式;

/**
 * Created by whb on 2017/7/18.
 */
public class CarWarp implements Car {
    private Car car;
    public CarWarp(QQ car) {
        this.car = car;
    }

    @Override
    public void run() {
        System.out.println("加强版QQ");
    }

    @Override
    public void stop() {

        car.stop();
    }
}
