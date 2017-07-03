package com.demo1.day13;

import java.math.BigDecimal;

/**
 * Created by whb on 2017/6/22.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 = new BigDecimal("0.05");
        System.out.println(f1.add(f2));
    }
}
