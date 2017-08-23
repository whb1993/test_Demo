package com.demo2.day26;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/21.
 */
public class demo {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {
        int max = 0 ;
int length = peaches.length;
        for (int i = 0; i < length; i++) {
            int p = peaches[i];
            int num=0;
            for (int m = i; i < length; i++) {
                if(p<peaches[m]){
                    p = peaches[m];
                    num++;
                }
            }
            if(max<num){
                max= num;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}