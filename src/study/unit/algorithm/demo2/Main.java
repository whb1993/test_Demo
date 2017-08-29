package study.unit.algorithm.demo2;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/8/26 19:43.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] num = new  int[scanner.nextInt()];
        int [] out = new  int[num.length];
        for (int i = 0; i < num.length; i++) {
            num[i]=scanner.nextInt();
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if(num[j]>num[i]){
                    out[i]++;
                }

            }
        }
        String output="";
        for (int i = 0; i < out.length-1; i++) {
            output=output+out[i]+" ";
        }
            System.out.print(output+out[out.length-1]);

    }





}
