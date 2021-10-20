package com.king.M10;

/**
 * @program: leetcode
 * @description: 453. ��С��������ʹ����Ԫ�����
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-10-20 23:14
 */
public class Test20 {

    // �Ż�ǰ 2 ms
    public int minMoves1(int[] nums) {
        int l = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - l * min;
    }

    // �Ż��� 1 ms
    //ִ����ʱ�� 2 ms , ������ Java �ύ�л����� 73.83% ���û�
    //�ڴ����ģ� 39 MB , ������ Java �ύ�л����� 16.53% ���û�
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }


    //����һ������Ϊ n ���������飬ÿ�β�������ʹ n - 1 ��Ԫ������ 1 ����������������Ԫ����ȵ���С����������
    //���룺nums = [1,2,3]
    //�����3
    //���ͣ�
    //ֻ��Ҫ3�β�����ע��ÿ�β�������������Ԫ�ص�ֵ����
    //[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]


}
