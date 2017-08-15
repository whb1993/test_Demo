package com.algorithm.sort;

import org.junit.Test;

/**
 * Created by Administrator on 2017/8/14.
 * 交换排序
 */
public class SwapSort {
    @Test
    public void test(){
        int A[] = { 5, 2, 9, 4, 7, 6, 1, 3, 8 }; // 从小到大快速排序
        int n = A.length;
        QuickSort(A, 0, n - 1);
        System.out.println("快速排序结果：");
        for (int i = 0; i <A.length ; i++) {
            System.out.print(A[i]);
        }
    }


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
     * 快速排序
     * 最差时间复杂度 ---- 每次选取的基准都是最大（或最小）的元素，导致每次只划分出了一个分区，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
     * 最优时间复杂度 ---- 每次选取的基准都是中位数，这样每次都均匀的划分出两个分区，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
     * 平均时间复杂度 ---- O(nlogn)
     * 所需辅助空间 ------ 主要是递归造成的栈空间的使用(用来保存left和right等局部变量)，取决于递归树的深度，一般为O(logn)，最差为O(n)
     * 稳定性 ---------- 不稳定

     */
    void QuickSort(int A[], int left, int right) {
        if (left >= right)
            return;
        int pivot_index = Partition(A, left, right); // 基准的索引
        QuickSort(A, left, pivot_index - 1);
        QuickSort(A, pivot_index + 1, right);
    }

    int Partition(int A[], int left, int right){  // 划分函数
        int pivot = A[right];               // 这里每次都选择最后一个元素作为基准
        int tail = left - 1;                // tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i < right; i++) {  // 遍历基准以外的其他元素
            if (A[i] <= pivot) {              // 把小于等于基准的元素放到前一个子数组末尾
                Swap(A, ++tail, i);
                for (int m = 0; m <A.length ; m++) {
                    System.out.print(A[m]);
                }
                System.out.println("");
            }
        }
        Swap(A, tail + 1, right);
        for (int m = 0; m <A.length ; m++) {
            System.out.print(A[m]);
        }
        System.out.println("-----------");
        // 最后把基准放到前一个子数组的后边，剩下的子数组既是大于基准的子数组
        // 该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
        return tail + 1;                    // 返回基准的索引
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
