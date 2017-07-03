package com.demo.day07;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/6/14.
 */
public class ReferenceTest {
    public static void main(String[] args) {
//        String str = new String("强引用");
        ReferenceTest str = new ReferenceTest();
        String str1 = new String("强引用");
        WeakReference wr = new WeakReference(str);
        SoftReference sr = new SoftReference(str1);
        str =null;
        System.out.println(wr.get());
        System.out.println(sr.get());
//        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
        System.out.println(sr.get());
    }
    public void finalize(){
        System.out.println("gc");
    }
}
