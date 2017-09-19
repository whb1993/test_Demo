package study.unit.algorithm.校招笔试题汇总.小米;

/**
 * Created by wanghongbin on 2017/9/18 19:50.
 * 添加一个是否为回文
 */
public class main02 {
    public static void main(String[] args) {
        System.out.println(fun("asddsa"));
    }

    static boolean fun(String str) {
        char[] chars = str.toCharArray();
        int n =chars.length;
        boolean flag =true;
        boolean flag1 =true;
        boolean flag2 =true;

        int index=0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < (n+1)/2; i++) {
            if(!flag){
                if(chars[i]!=chars[n-i]){
                    flag2 =false;
                    num1++;
                }
            }
            if(!flag){
                if(chars[i-1]!=chars[n-1-i]){
                    flag1 =false;
                    num2++;
                }
            }
            if(chars[i]!=chars[n-1-i]){
                flag =false;
            }

        }
        if(flag){return true;}
        if(flag1||flag2){return true;}

        return false;
    }
}
