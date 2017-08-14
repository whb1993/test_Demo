package com.algorithm.sort;

/**
 * Created by Administrator on 2017/8/14.
 * 交换排序
 */
public class SwapSort {
// 分类 -------------- 内部比较排序
// 数据结构 ---------- 数组
// 最差时间复杂度 ---- O(n^2)
// 最优时间复杂度 ---- O(n) 需要一个旗标来表示有无需要交换的可能
// 平均时间复杂度 ---- O(n^2)
// 所需辅助空间 ------ O(1)
// 稳定性 ------------ 稳定
    /**
     * 冒泡排序
     */
    public void bubbleSort(int A[], int n){
        for (int j = 0; j < n - 1; j++){         // 每次最大元素就像气泡一样"浮"到数组的最后
            boolean flag = true;                 //设置旗标检测是否有交换
            for (int i = 0; i < n - 1 - j; i++){ // 依次比较相邻的两个元素,使较大的那个向后移
                if (A[i] > A[i + 1]){            // 如果条件改成A[i] >= A[i + 1],则变为不稳定的排序算法
                    Swap(A,i,i + 1);
                    flag = false;
                }
            }
            if(flag){break;}
        }
    }

    /**
     * 鸡尾酒排序（定向冒泡排序）
     * 此算法与冒泡排序的不同处在于
     * 从低到高然后从高到低，
     * 而冒泡排序则仅从低到高去比较序列里的每个元素。他可以得到比冒泡排序稍微好一点的效能
     */
    void CocktailSort(int A[], int n)
    {
        int left = 0;                            // 初始化边界
        int right = n - 1;
        while (left < right)
        {
            for (int i = left; i < right; i++)   // 前半轮,将最大元素放到后面
            {
                if (A[i] > A[i + 1])
                {
                    Swap(A, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--)   // 后半轮,将最小元素放到前面
            {
                if (A[i - 1] > A[i])
                {
                    Swap(A, i - 1, i);
                }
            }
            left++;
        }
    }


    /**
     * 交换方法
     */
    private void Swap(int A[], int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
