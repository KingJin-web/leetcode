package com.king.M11;

/**
 * @program: leetcode
 * @description: 598. ��Χ��� II
 * @author: King
 * @create: 2021-11-07 23:43
 */
public class Test7 {

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û�
    //�ڴ����ģ� 38.4 MB , ������ Java �ύ�л����� 66.72% ���û�
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0){
            return m*n;
        }
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        for(int i=0;i<ops.length;i++){
            a=Math.min(a,ops[i][0]);
            b=Math.min(b,ops[i][1]);
        }
        return a*b;
    }
}
