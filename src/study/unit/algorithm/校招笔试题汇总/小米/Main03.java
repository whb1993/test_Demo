package study.unit.algorithm.校招笔试题汇总.小米;

import java.util.Locale;

/**
 * Created by wanghongbin on 2017/9/18 20:30.
 * 三角形中出现第一次位置
 */
public class Main03 {
    public static void main(String[] args) {

        System.out.println(fun(10));
    }
    static long fun(long x) {
        long[] num;
        long[] numOld= {1,1};
        if(x==1){return 1;}
        for (int i = 0; i <= x+3; i++) {
            num = new long[i+1];
            for (int j = 0; j < i-1; j++) {
                if(j==0){num[j]=1;continue;}
                num[j]=numOld[j]+numOld[j-1];
                if(x==num[j]){return i-1;}
            }
            numOld=num;
        }
        return 1;
    }
}
