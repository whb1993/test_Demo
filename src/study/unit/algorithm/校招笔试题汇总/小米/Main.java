package study.unit.algorithm.校招笔试题汇总.小米;

import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/18 18:53.
 * 长桌隔一个位置坐人
 */
public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        String table ="100100100001";
        char[] chars = table.toCharArray();
        if(chars[table.length()-1]=='1'){table=table+0;}
        String[] split = table.split("1");
        int num = 0;
        if(split.length==1){
            num=(split[0].length()+1)/2;
            System.out.println(num);
        }
        num+=split[0].length()/2;
        if(split.length>1){
            for (int i = 1; i < split.length-1; i++) {
                num+=(split[i].length()-1)/2;
            }
        }
        num+=split[split.length-1].length()/2;

        System.out.println(num);
    }



    static boolean fun(String table, int n) {
        String[] split = table.split("1");
        int num = 0;
        if(split.length==1){
            num=(split[0].length()+1)/2;
            return n>num?false:true;
        }
        num+=split[0].length()/2;
        if(split.length>1){
            for (int i = 1; i < split.length-1; i++) {
                num+=(split[i].length()-1)/2;
            }
        }
        num+=split[split.length-1].length()/2;
        return n>num?false:true;

    }


}
