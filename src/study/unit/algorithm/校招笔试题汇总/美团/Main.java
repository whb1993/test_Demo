package study.unit.algorithm.校招笔试题汇总.美团;


import java.util.Scanner;

/**
 * Created by wanghongbin on 2017/9/14 18:56.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int  n = scanner.nextInt();
        int [] arrNum = new int[n];
        int A[] =new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            arrNum[i] =  A[i];
        }
        boolean flag =true;
        for (int j = 0; j < n - 1; j++){
            for (int i = 0; i < n - 1 - j; i++){
                if (A[i] > A[i + 1]){
                    Swap(A,i,i + 1);
                    break;
                }
            }
        }
        int num =0;
        int index=0;
        for (int i = 0; i < n; i++) {
            if(A[i] !=arrNum[i]){
                num =A[i];
                index=i;
                flag = false;
                break;
            }
        }

        if (flag){
            Swap(arrNum,n-2,n-1);
        }else {
            for (int i = (n-1); i > (index); i--) {
                if(num ==arrNum[i]){
                    Swap(arrNum,i,index);
                    break;
                }
            }
        }

        String out = arrNum[0]+"";

        for (int i = 1; i < n; i++) {
            out =out +" "+arrNum[i] ;
        }
        System.out.println(out);
    }
    private static void Swap(int A[], int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
