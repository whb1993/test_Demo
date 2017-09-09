package study.unit.algorithm.demo2;

import org.junit.Test;

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
    @Test
    public void test(){
        int n =2;
        String name ="abcdeabcde";
        int length = name.length();
        int num = length-n;
        int 总数=length;
        for (int i = 1; i <num ; i++) {
            总数=总数*(length-i);
        }
        for (int i = 0; i <num-1 ; i++) {
            总数=总数/(num-i);
        }
        System.out.println(总数);
    }





}
