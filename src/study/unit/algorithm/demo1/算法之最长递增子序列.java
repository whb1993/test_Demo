package study.unit.algorithm.demo1;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/8/22 16:51.
 */
public class 算法之最长递增子序列 {
    public static void main(String[] args) {

        //输入的数组
        int nums [] = {1,9,2,10,11,3,4,5};
        int length = nums.length;
        //记录每个位置最长递增子序列的长度
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;//从1开始
            for (int j = 0; j < i; j++) {
                //如果是i位置大于j位置，并且j位置的最长递增子序列的长度+1长于目前i位置的最长递增子序列的长度，则更新i位置的最长递增子序列
                if (nums[j] <= nums[i] && result[j] == result[i]) {
                    result[i] = result[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i : result)
            max = i > max ? i : max;
        System.out.println(max);
    }
}
