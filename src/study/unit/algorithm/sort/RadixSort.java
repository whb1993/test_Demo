package study.unit.algorithm.sort;

/**
 * Created by Administrator on 2017/8/14.
 */
public class RadixSort {
    public static int[] radixSort(int[] target, int r, int d, int n){
        if (target != null && target.length != 1 ) {

            int[][] bucket = new int[r][n];  // 一共有基数r个桶，每个桶最多放n个元素
            int digit;  // 获取元素对应位上的数字，即装入那个桶
            int divisor = 1;   // 定义每一轮的除数，1, 10, 100, ...
            int[] count = new int[r];   // 统计每个桶中实际存放元素的个数

            for (int i = 0; i < d; i++) {  // d 位的元素，需要经过分配、收集d次即可完成排序

                // 分配
                for (int ele : target) {
                    digit = (ele/divisor) % 10;  // 获取元素对应位上的数字(巧妙！！！)
                    bucket[digit][count[digit]++] = ele; // 将元素放入对应桶，桶中元素数目加1
                }

                // 收集
                int index = 0;  // 目标数组的下标
                for (int j = 0; j < r; j++) {
                    int k = 0;    // 用于按照先进先出顺序获取桶中元素
                    while(k < count[j]){
                        target[index++] = bucket[j][k++];  // 按照先进先出依次取出桶中的元素
                    }
                    count[j] = 0;  // 计数器归零
                }
                divisor *= 10;  //用于获取元素对应位数字
            }
        }
        return target;
    }
}
