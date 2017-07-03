package com.demo.day08;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/15.
 */
public class FileReadTest {
    public static void main(String[] args) throws IOException{

//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        File tmpFile =File.createTempFile("aaa",".txt",file);
        // tmpFile.deleteOnExit();
        FileInputStream file1 = new FileInputStream("./src/com/demo/day08/FileReadTest.java");
        byte[] buffer =new byte[1024];
        int hasRead =0;
        while((hasRead = file1.read(buffer)) > 0){
            System.out.print(new String(buffer , 0 ,hasRead));
        }
        file1.close();
    }
}
