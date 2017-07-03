package com.demo1.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whb on 2017/7/3.
 */
public class Day18 {
    public static void main(String[] args) {
        List books =new ArrayList<>();
        books.add("aa");
        books.add(new String("aa"));
        System.out.println(books.indexOf("a1a"));
    }

}
