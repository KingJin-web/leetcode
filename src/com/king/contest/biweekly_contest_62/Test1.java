package com.king.contest.biweekly_contest_62;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 5871. ��һά����ת��ɶ�ά����
 * @author: King
 * @create: 2021-10-02 22:35
 */
public class Test1 {
    //����һ���±�� 0 ��ʼ��һά�������� original ���������� m ��  n ������Ҫʹ�� original �� ���� Ԫ�ش���һ�� m �� n �еĶ�ά���顣
    //original ���±�� 0 �� n - 1 ���� ���� ����Ԫ�ع��ɶ�ά����ĵ�һ�У�
    // �±�� n �� 2 * n - 1 ���� ���� ����Ԫ�ع��ɶ�ά����ĵڶ��У��������ơ�
    //��������������̷���һ�� m x n �Ķ�ά���顣����޷����������Ķ�ά���飬���㷵��һ���յĶ�ά���顣
    public int[][] construct2DArray(int[] original, int m, int n) {
        int ln = original.length;
        if (n * m != ln) {
            return new int[0][];
        }
        int[][] result = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                result[i][j] = original[index++];
        return result;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.construct2DArray(LeetcodeUtil.stringToIntegerArray("[1,2,3,4]"), 2, 2));
    }
}
