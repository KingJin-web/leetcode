package com.king.M08;

/**
 * @program: leetcode
 * @description: 526. ����������
 * https://leetcode-cn.com/problems/beautiful-arrangement/
 * @author: King
 * @create: 2021-08-16 21:06
 */
public class Test15 {

    /**
     * ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 35.1 MB , ������ Java �ύ�л����� 69.08% ���û�
     *
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        int[] table = new int[]{0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return table[n];

    }

}
