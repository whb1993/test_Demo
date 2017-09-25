package study.unit.algorithm.校招笔试题汇总.滴滴;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/23 19:07.
 * 输入岛屿位置  输出岛屿个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] islands = new int[m][n];
        int[][] arrNum = new int[k][2];
        int  a;
        int  b;
        int outNum = 0;
        String out ="";
        for (int i = 0; i < k; i++) {
            outNum++;
            a = arrNum[i][0] = scanner.nextInt();
            b = arrNum[i][1] = scanner.nextInt();
            islands[a][b]=1;
            if((a-1>0) && islands[a-1][b]==1){outNum--;}
            if((b-1>0) &&islands[a][b-1]==1){outNum--;}
            if((a<m-1) && islands[a+1][b]==1){outNum--;}
            if((b<n-1) && islands[a][b+1]==1){outNum--;}
            out=out+outNum+" ";
        }
        out = out.substring(0,out.length() - 1);
        System.out.println(out);
    }
}
