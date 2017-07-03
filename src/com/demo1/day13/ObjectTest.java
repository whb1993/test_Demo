package com.demo1.day13;

import java.util.Objects;

/**
 * Created by whb on 2017/6/22.
 * Object工具类
 */
public class ObjectTest {
    static ObjectTest t;
    public static void main(String[] args) {
        try {
            System.out.println(Objects.requireNonNull(t));
        } catch (NullPointerException e) {
            System.out.println(e);
            //e.printStackTrace();
        } finally {
            System.out.println("123");
        }
        System.out.println(Objects.hashCode(t));
    }

}
