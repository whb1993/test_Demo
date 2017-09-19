package study.unit.algorithm.校招笔试题汇总.搜狐;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/17 19:27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrNum = new int[n];
        long out = 0;
        for (int i = 0; i < n; i++) {
            arrNum[i] = scanner.nextInt();
            out += arrNum[i];
        }

        for (int i = 0; i < n / 2; i++) {
            if (arrNum[i] != arrNum[n - 1 - i]) {
                    out+=arrNum[n - 1 - i];

                    out+=arrNum[i];
            }
        }

        System.out.println(out);
    }
}
