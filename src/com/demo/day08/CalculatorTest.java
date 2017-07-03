package com.demo.day08;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/6/15.
 */
public class CalculatorTest {
    private static Calculator calculator=new Calculator();
    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(timeout=1000)
    public void add() throws Exception {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void substract() throws Exception {
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8,calculator.getResult());
    }

    @Ignore("Multiply() Not yet implemented")
    @Test
    public void multiply() throws Exception {
    }

    @Test(expected =ArithmeticException.class)
    public void divide() throws Exception {
        calculator.add(8);
        calculator.divide(0);
        assertEquals(4,calculator.getResult());
    }

}