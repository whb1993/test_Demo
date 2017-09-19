package study.unit.algorithm.校招笔试题汇总.美团;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/14 21:07.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int  n = scanner.nextInt();
        String d = scanner.nextLine();
        char [] arr =d.toCharArray();
        char falg = '1';
        int num = 0;
        for (int i =  d.length()-1; i >= 0; i--) {
            if( arr[i]!= falg){
                num++;
                falg=arr[i];
            }
        }
        if(num%2==0){
            System.out.println("Alice");
        }else {
            System.out.println("Bob");
        }


    }
}
