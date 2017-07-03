package com.demo.day08;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/15.
 */
public class FileTest {
    public static void main(String[] args) throws IOException{
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        File tmpFile =File.createTempFile("aaa",".txt",file);
       // tmpFile.deleteOnExit();
        File newFile =new File(System.currentTimeMillis() +".txt");
        newFile.createNewFile();

    }
}
