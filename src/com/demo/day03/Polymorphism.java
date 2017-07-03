package com.demo.day03;

/**
 * Created by Administrator on 2017/6/8.
 */
public class Polymorphism {
    public static void main(String[] args){
//        Person p =new Xiaoming();
//        p.eat();
//        System.out.println(p.face);
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];
        SayImp say=new SayImp();
        say.sayhi();
        Person p =new Xiaoming();
//        Xiaoming pp =(Xiaoming) new Person();
//        System.out.println(pp.face);
    }
}

class Person{
    static int face =1;
    void eat(){
        System.out.println("父类方法");
    }
    void sleep(){
        System.out.println("睡觉喽");
    }
}
class Xiaoming extends Person{
    int eye = 2 ;
    static int face = 0;
    void eat(){
        System.out.println("爱吃鱼");
    }
    void say(){
        System.out.println("我是小明");
    }
}
 class SayImp implements InterfaceSay
{
    @Override
    public void say()
    {
        // TODO Auto-generated method stub
        System.out.println("世界你好 ！！");
    }
}