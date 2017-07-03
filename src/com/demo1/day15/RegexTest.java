package com.demo1.day15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by whb on 2017/6/26.
 * 正则
 */
public class RegexTest {
    public static void main(String[] args) {
        String h1 = "hello world!";
        System.out.println(h1.replaceFirst("\\w","*"));
        Pattern compile = Pattern.compile("a*b");
        Matcher a = compile.matcher("ab");
        System.out.println(a.matches());
        System.out.println(Pattern.matches("(13)\\d{2}","13123"));
    }
}
