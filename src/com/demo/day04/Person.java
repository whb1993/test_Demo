package com.demo.day04;

import com.demo.day05.OutPut;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/9.
 */
public class Person implements Serializable {
    int age = 1;
    protected int age1 = 1;
    public static void main (String[] args){
        //People people = new People();
        //System.out.println(people.a);
        Out out = new Out();
        out.ceshi();
        Object obj = out;
        //System.out.println(new People().a);

    }
}
class People{

   static {
       System.out.println(1);
   }
    {
        System.out.println(2);
        a =2;
    }

    int a = 1;


    People(){
        System.out.println(3);
        a=3;
    }
}

class Xiaoming extends Person{
    Xiaoming(){
        System.out.println(age);
    }
}

 interface Output1{
     int a = 1;
    void ceshi();

 }
class Out implements OutPut{

    @Override
    public void ceshi() {
        this.pt();
        OutPut.sp();
        System.out.println(year);


    }
}

