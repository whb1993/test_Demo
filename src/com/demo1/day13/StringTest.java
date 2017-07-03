package com.demo1.day13;



/**
 * Created by whb on 2017/6/22.
 * 测试String
 */
public class StringTest {
    public static void main(String[] args) {
        String string1 = "babc";
        String string2 = "bcd";
        String st = new String(string1);
        StringBuffer sf = new StringBuffer("stringbuffer1");
        StringBuilder sd = new StringBuilder("1234567890");

        StringBuilder stringBuilder = new StringBuilder();

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(string1 == st);
        System.out.println(string1.equals(st));
        System.out.println(string1.compareTo(string2));
        System.out.println("*************");
        System.out.println(sd.capacity() + "****" +stringBuilder.capacity());
        stringBuilder.append("123456789012345678901234567890123456");
        sd.append("12345678912345678900");
        System.out.println(sd.capacity() + "****" +stringBuilder.capacity());
    }
}
