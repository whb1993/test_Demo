package com.demo1.day15;



/**
 * Created by whb on 2017/6/26.
 */
public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("a s d");

        String s = str.toString();

        System.out.println(s.replaceAll("\\s","%20"));

    }
}
