package com.demo1.day12;


/**
 * Created by whb on 2017/6/21.
 */
public class TestHashCode {
    public static void main(String[] args) {
        String h1 = new String("hellow");
        String h2 = new String("hellow");
        String h3 = "hellow";
        String h4 = "hellow";
        System.out.println(h1.hashCode()+"*****"+h2.hashCode());
        System.out.println(System.identityHashCode(h1)+"*****"+System.identityHashCode(h2));
        System.out.println(System.identityHashCode(h4)+"*****"+System.identityHashCode(h3));
        TestHashCodenum testHashCodenum = new TestHashCodenum();
        System.out.println(testHashCodenum.hashCode()+"***"+System.identityHashCode(testHashCodenum));
    }
}
class TestHashCodenum{

}
