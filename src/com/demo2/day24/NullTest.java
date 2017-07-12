package com.demo2.day24;

/**
 * Created by whb on 2017/7/12.
 */
public class NullTest {
    public static void main(String[] args) {
        String a = null;

        try {
            //System.out.println(a.toString());
            throw new Exception();
        } catch (NullPointerException e) {
            e.getMessage();
            System.out.println("空指针");
            // e.printStackTrace();
        }catch (Exception e) {
            e.getMessage();
            System.out.println("throw");
            // e.printStackTrace();
        }
        System.out.println("继续");
        throw new RuntimeException("111");
    }
}
