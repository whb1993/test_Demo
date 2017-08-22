package study.unit.algorithm.demo1;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/14.
 */
public class TestDemo1 {
    @Test
    public void getDis() {
       Integer[] A={5,4,3,2,1};
       int n=5;
        int dis = 0;
        if (n > 1) {
            int min = A[0];
            for (int i = 1; i < n; i++) {
                if (A[i] - min > dis) {
                    dis = A[i] - min;
                }
                if (min > A[i]) {
                    min = A[i];
                }
            }
        }
        System.out.println(dis);
    }

    /**
     * 求字符串的最长不重复子串的长度
     * 举例：
     abcabcbb，返回abc；
     bbbbb，返回b；
     pwwkew，返回wke。注意pwke是子序列，不是子串。
     问题分析：
     记字符串存放在字符数组cs中，遍历cs的下标为i。分析可知，想求截止到i的最长不重复子串的长度，
     只要从i向左，找到第1个重复的字符，其右边的数标记为left，则所求长度就是i-left+1与之前求得的结果中的最大值。
     */
    @Test
    public void lengthOfLongestSubstring() {
        String str ="aabbcc";
        // String str ="pwwkewwabc";
        if(str==null||str.length()==0)
            System.out.println(0);

        char[] cs = str.toCharArray();
        int[] charMap = new int[256];
        Arrays.fill(charMap , -1);
        int max = 0;
        int left = 0;
        for(int i=0;i<cs.length;i++){
            if(charMap[cs[i]]>=left)
                left = charMap[cs[i]]+1;
            int tmp = i-left+1;
            if(tmp>max)
                max = tmp;
            charMap[cs[i]]=i;
        }
        System.out.println(max);
    }

    /**
     *  两个字符串的最长公共子串
     */
    @Test
    public void getLongestCommonSubstring(){
        String str1 ="adsfasf";
        String str2 = "adasf";
        //check input parameters
        if(str1==null||str2==null)
            System.out.println(0);
        //find out the bigger string and the smaller one
        String big = str1.length()>=str2.length()?str1:str2;
        String small = str1.length()<str2.length()?str1:str2;
        //get the end of the longest common substring in small
        int[] help = new int[small.length()];
        int end = 0;
        int length = 0;
        for(int i=0;i<big.length();i++){
            for(int j=small.length()-1;j>=0;j--){
                if(big.charAt(i)==small.charAt(j)){
                    if(j==0)
                        help[j]=1;
                    else{
                        help[j]=help[j-1]+1;
                        if(help[j]>length){
                            length = help[j];
                            end = j;
                        }
                    }
                }else
                    help[j]=0;
            }
        }
        //get the longest common substring and return it
        if(length==0)
            System.out.println(0);
        else
            System.out.println(small.substring(end-length+1,end+1));
    }
}
