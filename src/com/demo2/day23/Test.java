package com.demo2.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whb on 2017/7/11.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(1);
        List list = li;
        System.out.println(list);
        List<Integer> ls =list;
        System.out.println(ls.get(0));

    }
}
