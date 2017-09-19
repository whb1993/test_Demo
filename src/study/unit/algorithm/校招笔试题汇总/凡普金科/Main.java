package study.unit.algorithm.校招笔试题汇总.凡普金科;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/10 14:47.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long  num = (long)scanner.nextLong();
        Long temp = (long)0;
        Long out = num+1;

        while(true){
            char [] charArr =out.toString().toCharArray();
            temp = out;
            for (int i = 0; i < charArr.length; i++) {
                temp = temp - (long)charArr[i]+48;
            }
            if(temp>=num){
                break;
            }
            out++;
        }
        System.out.println(out);
    }
    @Test
    public void demo(){
        Scanner scanner = new Scanner(System.in);
        int [] num = new  int[3];
        num[0] = scanner.nextInt();
        num[1] = scanner.nextInt();
        num[2] = scanner.nextInt();
        int max = num[0]*num[1]*num[2];
        int temp;
        temp = num[0]+num[1]+num[2];
        max = max>temp?max:temp;

        temp = (num[0]+num[1])*num[2];
        max = max>temp?max:temp;
        temp = num[0]*(num[1]+num[2]);
        max = max>temp?max:temp;
        temp = num[0]*num[1]+num[2];
        max = max>temp?max:temp;
        temp = num[0]+num[1]*num[2];
        max = max>temp?max:temp;
        System.out.println(max);
    }
}
