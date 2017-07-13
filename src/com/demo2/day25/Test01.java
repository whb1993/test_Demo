package com.demo2.day25;

/**
 * Created by whb on 2017/7/13.
 */
public class Test01 {
    public static void main(String[] args) {
        firstMethod();
    }
    public static void firstMethod(){
        secondMethod();
    }
    public static void secondMethod(){

        try {
            thirdMethod();
        } catch (SlefException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static void thirdMethod(){
        System.out.println("1");
        throw new SlefException("haha");

    }
}
class SlefException extends RuntimeException{
     SlefException(String message) {
        super(message);
    }

    SlefException(){}

}