package com.demo.day02;

/**
 * Created by Administrator on 2017/6/7.
 */
public class TestVar {
    public  static void main(String[] args){
        Persion p =new Persion('a');
        System.out.println(p.name);
        System.out.println(Persion.eyes);
        Persion.eyes=2;
        Persion p1 = new Persion("c");
        System.out.println(Persion.eyes);

    }
}
class Persion{
    public static int eyes = 1;
    public String name;
     Persion(char a){
         eyes =1;
         change(1);
    }
    Persion(String b){
        eyes =1;
        change(1);
    }
    private void change(int eye){
         eyes = eye;
    }
}
