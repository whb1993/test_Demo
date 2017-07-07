package com.demo1.day20;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by whb on 2017/7/5.
 */
public class Day20 {
    public static void main(String[] args) {
        Map a = new HashMap();
        a.put("a",11);
        a.put("ab",11);
        a.put("ac",11);
        Map<Object, Object> aa = new Hashtable<>();
//        aa.put(null,null);
        a.put(null,null);

        System.out.println(a.remove(new String("aaa")));
        System.out.println(a);


    }
}
