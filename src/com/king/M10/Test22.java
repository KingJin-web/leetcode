package com.king.M10;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 229. ������ II
 * @author: King
 * @create: 2021-10-22 20:37
 */

public class Test22 {
    //����һ����СΪ n ���������飬�ҳ��������г��ֳ��� ? n/3 ? �ε�Ԫ�ء�

    //ִ����ʱ�� 11 ms , ������ Java �ύ�л����� 28.12% ���û� �ڴ����ģ� 41.3 MB , ������ Java �ύ�л����� 94.25% ���û�
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int n = length / 3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                list.add(entry.getKey());
            }

        }
        return list;
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        MyPrint.print(test22.majorityElement(Helper.getArrays(1, 1, 2, 3, 6, 1, 1)));
    }
}
