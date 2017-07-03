package com.demo1.day16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by whb on 2017/6/27.
 */
public class day16 {
    public static void main(String[] args) {

        DateTimeFormatter[] d1 = {DateTimeFormatter.ISO_LOCAL_DATE};
        LocalDateTime n = LocalDateTime.now();
        for (int i =0;i<d1.length ;i++){
            System.out.println(n.format(d1[i]));
            System.out.println(d1[i].format(n));
        }
    }
}
