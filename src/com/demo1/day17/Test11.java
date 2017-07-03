package com.demo1.day17;

/**
 * Created by whb on 2017/6/30.
 */
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee1 extends Person {
    String empID = "0000";
    public Employee1(String id) {
        super("a");
        empID = id;
    }
}
public class Test11 {
    public static void main(String args[]) {
        Employee1 e = new Employee1("123");
        System.out.println(e.empID);
    }
}
