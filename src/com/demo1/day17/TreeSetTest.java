package com.demo1.day17;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by whb on 2017/6/28.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Collection a = new TreeSet();
        a.add(new Test1());
        a.add(new Test1());
        System.out.println(a);
    }

}
class Test1 implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
enum Season{
    H,K,O
}
