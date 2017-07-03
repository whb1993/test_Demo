package com.demo1.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by whb on 2017/6/21.
 */
public class TestBase {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("xmltest.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        scanner.useDelimiter("\n");
        while (scanner.hasNextLine()){
//            System.out.println("输入内容："+scanner.next());
            System.out.println(scanner.nextLine());
        }
        System.out.println("****");
    }
}
