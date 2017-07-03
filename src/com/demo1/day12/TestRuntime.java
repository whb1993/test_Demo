package com.demo1.day12;

import java.io.IOException;

/**
 * Created by whb on 2017/6/21.
 */
public class TestRuntime {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

//        System.out.println(rt.availableProcessors()+"***"+rt.freeMemory()+"***"+rt.totalMemory()+"***"+rt.maxMemory());
        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
