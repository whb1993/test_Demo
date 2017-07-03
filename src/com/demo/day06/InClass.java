package com.demo.day06;

/**
 * Created by Administrator on 2017/6/13.
 *
 */
public class InClass {

    private void useInterface(NameInterface p){
        p.speak();
    }

    public InClass() {
        super();
    }

    public static void main(String[] args) {

        int age = 1;

        InClass inClass = new InClass();
        inClass.useInterface(()-> System.out.println("aa"));
        NameInterface n = ()-> {
            System.out.println(age);
            System.out.println("a");
        };
        n.speak();

    }
}

interface NameInterface{
    void speak();
//    void speak2();
}