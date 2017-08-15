package com.algorithm.sort;

import org.junit.Test;

/**
 * Created by Administrator on 2017/8/14.
 * 插入排序
 */
public class InsertionSort {

    @Test
    public void testDemo(){
        int A[] = { 14,5, 2,16, 13,17,12,9, 4,15,18, 11,7, 6, 1, 3, 8 ,10}; // 从小到大快速排序
        int n = A.length;
        ShellSort(A, n );
        System.out.println("快速排序结果：");
        for (int i = 0; i <A.length ; i++) {
            System.out.print(A[i]);
        }
    }
    /**
     * 直接插入排序
     // 最差时间复杂度 ----.O(n^2) -- 降序排列
     // 最优时间复杂度 ---- O(n)   -- 升序排列
     // 平均时间复杂度 ---- O(n^2)
     // 所需辅助空间 ------ O(1)
     // 稳定性 ------------ 稳定
     */
    void insertionSort(int A[], int n){
        for (int i = 1; i < n; i++){         // 类似抓扑克牌排序
            int get = A[i];                 // 右手抓到一张扑克牌
            int j = i - 1;                  // 拿在左手上的牌总是排序好的
            while (j >= 0 && A[j] > get){    // 将抓到的牌与手牌从右向左进行比较
                A[j + 1] = A[j];            // 如果该手牌比抓到的牌大，就将其右移
                j--;
            }
            A[j + 1] = get; // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
        }
    }


    /**
     * 二分插入排序
     // 最差时间复杂度 ---- O(n^2)
     // 最优时间复杂度 ---- O(nlogn)
     // 平均时间复杂度 ---- O(n^2)
     // 所需辅助空间 ------ O(1)
     // 稳定性 ------------ 稳定
     */
    void InsertionSortDichotomy(int A[], int n){
        for (int i = 1; i < n; i++) {
            int get = A[i];                    // 右手抓到一张扑克牌
            int left = 0;                      // 拿在左手上的牌总是排序好的，所以可以用二分法
            int right = i - 1;                 // 手牌左右边界进行初始化
            while (left <= right){             // 采用二分法定位新牌的位置
                int mid = (left + right) / 2;
                if (A[mid] > get)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i - 1; j >= left; j--){    // 将欲插入新牌位置右边的牌整体向右移动一个单位
                A[j + 1] = A[j];
            }
            A[left] = get;                    // 将抓到的牌插入手牌
        }
    }


    /**
     * 希尔排序
     // 最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
     // 最优时间复杂度 ---- O(n)
     // 平均时间复杂度 ---- 根据步长序列的不同而不同。
     // 所需辅助空间 ------ O(1)
     // 稳定性 ------------ 不稳定
     */
    void ShellSort(int A[], int n) {
        int h = 0;
        while (h <= n){                         // 生成初始增量
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {

                int j = i - h;
                int get = A[i];
                while (j >= 0 && A[j] > get) {
                    A[j + h] = A[j];
                    j = j - h;
                    for (int m = 0; m <A.length ; m++) {
                        System.out.print(A[m]);
                    }
                    System.out.println("");
                }
                A[j + h] = get;
                for (int m = 0; m <A.length ; m++) {
                    System.out.print(A[m]);
                }
                System.out.println("******");
            }
            h = (h - 1) / 3;                    // 递减增量

        }
    }

}
