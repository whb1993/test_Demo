package com.demo.day10;
/**
 * Created by whb on 2017/6/19.
 * 处理有序二维数组
 */
public class TenClass {
    public static void main(String[] args) {
        TenClass tenClass = new TenClass();
        System.out.println(tenClass.i[1]);
        double d1 =0.111d;
        long l1 = 112L;
        System.out.println(d1+""+l1);
    }
   // public int i1 = 1;
    TenClass (){

    }
        int i [] = new int[12];
        int i1 [] = {1,2};
        int i2 [];

    int TenClass (){
        return 1;
    }
    public boolean Find(int target, int[][] array) {
        for (int x = 0; x < array.length; x++) {  //定位行
            for (int y = 0; y < array[x].length; y++) {  //定位每行的元素个数
                if (target == array[x][y]) {
                    return true;
                }
            }
        }
        return true;
    }
}


interface TestInterface{
    abstract void test1();
}