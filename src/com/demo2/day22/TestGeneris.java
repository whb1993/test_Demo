package com.demo2.day22;

import java.util.ArrayList;

/**
 * Created by whb on 2017/7/10.
 */
public class TestGeneris {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        Apple<String> h = new Apple<>("hello");
        System.out.println(h.getInfo());
        Apple<Integer> i = new Apple<>(1);
        System.out.println(i.getInfo()+1);
        Number [] na ;
    }
}
class Apple<T>
{
    static void test(){

    }
    private T info;

    public Apple(T info){
        this.info = info ;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
}
