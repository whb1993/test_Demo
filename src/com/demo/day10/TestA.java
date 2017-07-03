package com.demo.day10;

/**
 * Created by whb on 2017/6/19.
 */
public class TestA {

        public static TestA t1 = new TestA();
        {
            System.out.println("blockA");
        }
        static
        {
            System.out.println("blockB");
        }
        public static void main(String[] args)
        {
            TestA t2 = new TestA();
        }

}
