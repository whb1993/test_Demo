package study.unit.algorithm.校招笔试题汇总.京东;

/**
 * Created by wanghongbin on 2017/9/8 19:32.
 * 京东笔试算法题
 */

public class Main {
    public static void main(String[] args) {
       //  Scanner in = new Scanner(System.in);
       // String s =in.next();
       String s ="((()))(())()()()";
        int i;
       int num = 1 ;
        do {

            do {
                s = s.replaceFirst("\\(\\)", "\\*");
                if(s.indexOf("(*)") == -1){
                    continue;
                }
                i=2;
                while (s.indexOf("((*))") != -1) {
                    s = s.replaceFirst("\\(\\*\\)", "\\*");
                    num = num * (i++);
                }
                num = num * i;
                s = s.replaceAll("\\(\\*\\)", "");
            } while (s.indexOf("()") != -1);
        }while (s=="");
        System.out.println(num);
    }

}