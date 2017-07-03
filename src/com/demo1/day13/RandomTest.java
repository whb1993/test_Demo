package com.demo1.day13;

import java.util.Random;

/**
 * Created by whb on 2017/6/22.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(50);
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        Random random1 = new Random(50);
        System.out.println(random1.nextInt());
        System.out.println(random1.nextInt());
    }
}
