package com.king.contest.biweekly_contest_62;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 5872. ���Ӻ����Ŀ���ַ������ַ�����
 * @author: King
 * @create: 2021-10-02 22:44
 */
public class Test2 {
    //����һ�� ���� �ַ������� nums ��һ�� ���� �ַ��� target ��
    //���㷵�� nums[i] + nums[j] �������ַ������ӣ�������� target ���±� (i, j) �������� i != j������Ŀ��
    public int numOfPairs(String[] nums, String target) {
        int ln = nums.length;
        int result = 0;
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln ; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)){
                    ++result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        MyPrint.print(test2.numOfPairs(Helper.getArrays("777","7","77","77"),"7777"));
        MyPrint.print(test2.numOfPairs(Helper.getArrays("123","4","12","34"),"1234"));
    }

    //���룺nums = ["777","7","77","77"], target = "7777"
    //�����4
    //���ͣ�����Ҫ����±�԰�����
}
