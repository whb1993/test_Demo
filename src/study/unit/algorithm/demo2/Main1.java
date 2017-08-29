package study.unit.algorithm.demo2;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/8/26 19:43.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] num = new  int[9];

        for (int i = 0; i < 9; i++) {
            num[i]=scanner.nextInt();
        }
        int count=0;
        int n0=num[0];
        int n1=num[1];
        while (true){
            n0-=num[2];
            n1-=num[3];
            if(n0<0||n1<0){
                break;
            }
            count++;
        }
        System.out.println(count);
        int maxMoney = 0;
        for (int i = 0; i <count ; i++) {
            int money=0;
            money = num[6]*i;
            money+=(num[0]-num[2]*i)/num[4]*num[7];
            money+=(num[1]-num[3]*i)/num[5]*num[8];
            maxMoney=maxMoney>money?maxMoney:money;
        }
        System.out.println(maxMoney);
    }





}
