package study.unit.algorithm.Test.demo1;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/22.
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = -1;
        Integer [] arr;
        String[] a ;
        while (true) {
            String line = sc.nextLine();
            try {
                if (start == -1) {
                    start = Integer.parseInt(line);
                } else {
                    a = line.split(" ");
                    arr = new Integer[start];
                    for (int i = 0; i < start; i++) {
                        arr[i] = Integer.parseInt(a[i]);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("输入格式有误");
            }
        }
        int max= 0;
        for (int i = 0; i < start; i++) {
            if(max<(arr[i]*arr[i])){
                max = arr[i]*arr[i];
            }
        }

        System.out.println(max);
    }

}
