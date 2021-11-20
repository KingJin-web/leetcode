package com.king.M11;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 594. ���г������
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-11-20 23:17
 */
public class Test20 {

    //��г������ָһ��������Ԫ�ص����ֵ����Сֵ֮��Ĳ�� ������ 1 ��
    //
    //���ڣ�����һ���������� nums �����������п��ܵ����������ҵ���ĺ�г�����еĳ��ȡ�
    //
    //�������������һ���������������������У�������ͨ��ɾ��һЩԪ�ػ�ɾ��Ԫ�ء��Ҳ��ı�����Ԫ�ص�˳����õ���


    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1)
                begin++;
            if (nums[end] - nums[begin] == 1)
                res = Math.max(res, end - begin + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        //���룺nums = [1,3,2,2,5,2,3,7]
        //�����5
        //���ͣ���ĺ�г�������� [3,2,2,2,3]

        Test20 test20 = new Test20();
        int a = test20.findLHS(LeetcodeUtil.stringToIntegerArray("[1,3,2,2,5,2,3,7]"));
        MyPrint.print(a);
    }
}
