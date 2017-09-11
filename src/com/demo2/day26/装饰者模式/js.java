package com.demo2.day26.装饰者模式;

/**
 * Created by Administrator on 2017/8/31.
 */
public class js
{
    public static void main(String[] args) {
int [] a =new int[8];
int 对比 =a[0];
int max =1;
        for (int i = 0; i < a.length; i++) {
            if(对比!=a[i]){
                对比=a[i];
                max++;
            }
        }
    }
}
