package com.demo.day09;

import java.io.*;

/**
 * Created by whb on 2017/6/16.
 */
public class Dom4jReadXml {
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("xmltest.xml");
                FileOutputStream file1 = new FileOutputStream("xmltest1.xml");
                PrintStream ps = new PrintStream(file1))
        {
            ps.println("ceshi");
            ps.println(new Dom4jReadXml());

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {

        }
    }
}
