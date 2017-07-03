package com.demo1.day14;

import java.time.Clock;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by whb on 2017/6/23.
 * 测试时间类
 */
public class Calendartest {
    public static void main(String[] args) {
        Calendar c =Calendar.getInstance();
        c.set(Calendar.MONTH,8);
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.getTime());

        Date d = new Date();
        System.out.println(d);

        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        Month m = Month.JANUARY;
        System.out.println(m);
    }
}
