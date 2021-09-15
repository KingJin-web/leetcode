package com.king.contest.problems.OneDay;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: LCP 28. �ɹ�����
 * https://leetcode-cn.com/problems/4xy4Wx/
 * @author: King
 * @create: 2021-09-15 21:55
 */
public class Test1 {
    public int purchasePlans1(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= target) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count % 1000000007;
    }

    //ִ����ʱ�� 32 ms , ������ Java �ύ�л����� 92.52% ���û�
    // �ڴ����ģ� 48.4 MB , ������ Java �ύ�л����� 6.61% ���û�
    public int purchasePlans(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int res = 0;
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res += (right - left);
                res %= 1000000007;//��д��һ��res�ᳬ��2^32,��ֹԽ��
                left++;
            }
        }
        return res % 1000000007;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.purchasePlans(LeetcodeUtil.stringToIntegerArray("[2,2,1,9]"),10));
    }
    public int purchasePlans2(int[] nums, int target) {
        int left, right;
        int n = 0;
        Arrays.sort(nums);
        int l = nums.length;
        for (left = 0, right = l - 1; left < right; ) {
            if (nums[left] + nums[right] > target) right--;
            else {
                n = n + right - left;
                left++;
            }
        }
        return n % 1000000007;
    }
    //С���� N ������ı��۴������� nums��С��Ԥ��Ϊ target���ٶ�С�����������������Ҫ��������Ļ��Ѳ�����Ԥ�㣬
    // �������ж����ֲɹ�������
    //
    //ע�⣺����Ҫ�� 1e9 + 7 (1000000007) Ϊ��ȡģ���磺�����ʼ���Ϊ��1000000008���뷵�� 1
    //
    //ʾ�� 1��
    //
    //���룺nums = [2,5,3,5], target = 6
    //
    //�����1
    //
    //���ͣ�Ԥ���ڽ��ܹ��� nums[0] �� nums[2]��
    //
    //ʾ�� 2��
    //
    //���룺nums = [2,2,1,9], target = 10
    //
    //�����4
    //
    //���ͣ�����Ԥ��Ĳɹ��������£�
    //nums[0] + nums[1] = 4
    //nums[0] + nums[2] = 3
    //nums[1] + nums[2] = 3
    //nums[2] + nums[3] = 10
    //
    //��ʾ��
    //
    //2 <= nums.length <= 10^5
    //1 <= nums[i], target <= 10^5

}
