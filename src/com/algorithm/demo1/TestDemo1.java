package com.algorithm.demo1;

import org.junit.Test;

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
}
