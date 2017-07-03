package com.demo1.day17;

import java.util.stream.IntStream;

/**
 * Created by whb on 2017/6/28.
 */
public class StreamTest {
    public static void main(String[] args) {
        IntStream is =  IntStream.builder().add(1).add(2).build();
       // System.out.println(is.max().getAsInt());
       // System.out.println(is.sum());
        IntStream isnew =is.map(e->e*2);
        isnew.forEach(System.out::println);

    }
}
