package com.demo1.day16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by whb on 2017/6/27.
 */
public class LambdaTest {
    public static void main(String[] args) {
        Collection a = new ArrayList();
        a.add("asd");
        a.add("asd1");
        a.add("aaa");
        a.add("aaab");
        //a.forEach(h -> System.out.println(h));
        Iterator it = a.iterator();

        while (it.hasNext()) {
            String b = (String) it.next();
            System.out.println(b);
            if (b.equals("aaab")) {
                //a.remove(b);
                it.remove();
            }
        }
        System.out.println(a);
    }
}
