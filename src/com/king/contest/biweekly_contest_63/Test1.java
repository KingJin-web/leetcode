package com.king.contest.biweekly_contest_63;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 5885. ʹÿλѧ��������λ�������ƶ�����
 * https://leetcode-cn.com/problems/minimum-number-of-moves-to-seat-everyone/
 * @author: King
 * @create: 2021-10-16 22:48
 */
public class Test1 {

    //ִ����ʱ�� 1 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 37.8 MB , ������ Java �ύ�л����� 100.00% ���û�
    int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < n; i++) ans += Math.abs(seats[i] - students[i]);
        return ans;
    }

    //���룺seats = [4,1,5,9], students = [1,3,2,6]
    //�����7
    //���ͣ�ѧ���ƶ���ʽ���£�
    //- ��һλѧ�����ƶ���
    //- �ڶ�λѧ����λ�� 3 �ƶ���λ�� 4 ���ƶ� 1 �Ρ�
    //- ����λѧ����λ�� 2 �ƶ���λ�� 5 ���ƶ� 3 �Ρ�
    //- ����λѧ����λ�� 6 �ƶ���λ�� 9 ���ƶ� 3 �Ρ�
    //�ܹ� 0 + 1 + 3 + 3 = 7 ���ƶ���
    //
    //��Դ�����ۣ�LeetCode��
    //���ӣ�https://leetcode-cn.com/problems/minimum-number-of-moves-to-seat-everyone
    //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.minMovesToSeat(LeetcodeUtil.stringToIntegerArray("[4,1,5,9]"),
                LeetcodeUtil.stringToIntegerArray(" [1,3,2,6]")));
    }
}
