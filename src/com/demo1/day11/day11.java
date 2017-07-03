package com.demo1.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by whb on 2017/6/20.
 */
public class day11 {
    public static void main(String[] args) throws IOException{
        Process p = Runtime.getRuntime().exec("javac");

        try
                (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));)
        {
            String buff = null;
            while ((buff = bufferedReader.readLine())!= null){
                System.out.println(buff);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
