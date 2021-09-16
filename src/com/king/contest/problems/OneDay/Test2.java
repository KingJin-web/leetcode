package com.king.contest.problems.OneDay;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: LCP 29. ����վλ
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/SNJvJP
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-16 20:04
 */
public class Test2 {
    public int orchestraLayout(int num, int x, int y) {
        //��ȷ�����λ���ڵڼ�Ȧ,circle��0��ʼ���������ڡ�һ��ȦΪcircle == 0
        long circle = Math.min(Math.min(x, num - 1 - x), Math.min(y, num - 1 - y));

        //len ��¼��circleȦ�ı߳����߳�Ϊ�����α߳�-1��ÿȦ����߳���2
        long len = num - 1 - 2 * circle;

        //countһ�������������ο� @�Ұ��� �ϸ��count�ⷨ��
        long count = (long) num * num - (len + 1) * (len + 1);

        //����pos�ڲ�ͬ������������count����ʵ������Ҫ�Ż�����
        if (x == circle && y < num - 1 - circle) {
            count += y - circle + 1;          //���ʱ�����ϱߵı�
        } else if (y == num - 1 - circle && x < num - 1 - circle) {
            count += len + x - circle + 1;        //���ұߵı�
        } else if (x == num - 1 - circle && y > circle) {
            count += 2 * len + num - circle - y;    //���±ߵı�
        } else {
            count += 3 * len + num - circle - x;
        }
        return (int) (count % 9 == 0 ? 9 : count % 9);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        //���룺num = 3, Xpos = 0, Ypos = 2
        //�����3
        MyPrint.print(test2.orchestraLayout(3,0,2));
    }
    //ĳ���ŵ��ݳ����ؿ����� num * num �Ķ�ά���� grid�����Ͻ�����Ϊ [0,0])��ÿ��λ��վ��һλ��Ա��
    // ���Ź��� 9 ���������������Ϊ 1~9��ÿλ��Ա���� 1 ��������
    //Ϊ��֤���ֻ��Ч������Ավλ����Ϊ���� grid ���Ͻǿ�ʼ˳ʱ������������ѭ���� 1��2��...��9 ѭ���ظ����С�
    // ���統 num = 5 ʱ��վλ��ͼ��ʾ


}
