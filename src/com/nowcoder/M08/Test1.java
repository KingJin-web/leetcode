package com.nowcoder.M08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: [�����]����任
 * ţţ��һ�����飬����������ܲ���ȣ���������������Ϊ�����е�������ȡ����Ƿ���С�
 * ţţ���Խ��еĲ����ǣ��������е�����һ������Ϊ�������������
 * ���������ʹ�ô������ޣ�Ҳ���Բ�ʹ�ã����ҿ��Զ�ͬһ��λ��ʹ�ö�Ρ�
 * @author: King
 * @create: 2021-08-10 21:50
 */
public class Test1 {

    static int anotherIs2Power(int num) {
        while ((num & 1) == 0)
            num >>= 1;
        return num;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = anotherIs2Power(in.nextInt());

            }
            Arrays.sort(arr);
            System.out.println(arr[0] == arr[n - 1] ? "YES" : "NO");
        }

    }

}
