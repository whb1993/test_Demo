package com.demo.day09;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by whb on 2017/6/16.
 */
public class TestFinal {
    static String a[]={"123","abc",null};

    public static void main (String args[]) {
        int i1;
        System.out.println(Math.floor(-8.5)+"");
        for (int i = 0; i < 4; i++) {
            try {
                int x = Integer.parseInt(a[i]);
                System.out.print(  "Result: " + x + " ");
            }

            catch (NumberFormatException e){
                System.out.print("error ：abc"+" ");
            }
            catch(Exception e) {
                System.out.print("error null：" + " ");
            }
            finally{
                System.out.print ("In "+ i +"th loop\n" + " ");
            }
        }
    }
}
class Test extends TestFinal{
//    void test(){}
}
