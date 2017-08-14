package com.algorithm.sort;

/**
 * Created by Administrator on 2017/8/14.
 * 选择排序
 */
public class SelectSort {
    // 分类 -------------- 内部比较排序
    // 数据结构 ---------- 数组
    // 最差时间复杂度 ---- O(n^2)
    // 最优时间复杂度 ---- O(n^2)
    // 平均时间复杂度 ---- O(n^2)
    // 所需辅助空间 ------ O(1)
    // 稳定性 ------------ 不稳定
    void SelectionSort(int A[], int n) {
        for (int i = 0; i < n - 1; i++){         // i为已排序序列的末尾
            int min = i;
            for (int j = i + 1; j < n; j++){     // 未排序序列
                if (A[j] < A[min]){              // 找出未排序序列中的最小值
                    min = j;                     // 没有直接交换是因为交换代价比较大需要三行
                }
            }
            if (min != i) {
                Swap(A, min, i);    // 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
            }
        }
    }


    private void Swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
