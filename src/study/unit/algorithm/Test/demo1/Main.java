package study.unit.algorithm.Test.demo1;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        int start = -1;
        int num = 0;
        int[] a = new int[1];
        int[] b = new int[1];
        while (true) {
            String line = sc.nextLine();
            try {
                if (start == -1) {
                    start = Integer.parseInt(line);
                    a = new int[start];
                    b = new int[start];
                } else {
                    a[num] = Integer.parseInt(line.split(" ")[0]);
                    b[num] = Integer.parseInt(line.split(" ")[1]);
                    if (++num == start) break;
                }
            } catch (Exception e) {
                System.out.println("输入格式有误");
            }
        }
        bubbleSort(a,b);
        int[] n = new int[start];
        int m = 0;
        for (int i = 0; i < start; i++) {
            boolean flag = true;
            for (int j = 0; j < start; j++) {
                if(a[i]<a[j]&&b[i]<b[j]){
                    flag = false;
                }
            }
            if(flag){
                n[m++]=i;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(a[n[i]] +" " +b[n[i]]);
        }

    }

    public static void bubbleSort(int a[],int b[]) {

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1; j++) {

                if (a[j] > a[j + 1]) {

                    int temp = a[j];

                    a[j] = a[j + 1];

                    a[j + 1] = temp;

                    temp = b[j];

                    b[j] = b[j + 1];

                    b[j + 1] = temp;

                }

            }

        }

    }
}
