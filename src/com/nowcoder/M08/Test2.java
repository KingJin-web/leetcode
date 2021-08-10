package com.nowcoder.M08;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: [�����]����ַ�
 * https://www.nowcoder.com/questionTerminal/b2b816e20e8343b49abbaf493886ce26
 * @author: King
 * @create: 2021-08-10 23:00
 */
public class Test2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String a = in.nextLine();
            String b = in.nextLine();

            int max = 0;

            char[] chars1 = a.toCharArray();
            char[] chars2 = b.toCharArray();
            for (int i = 0; i <= b.length() - a.length(); ++i) {
                int count = 0;
                for (int j = 0; j < a.length(); ++j) {
                    if (chars1[j] == chars2[j + i])
                        ++count;

                }
                max = Math.max(max, count);

            }
            System.out.println(a.length() - max);
        }
    }

}
/**
 * ʱ�����ƣ�C/C++ 1�룬��������2��
 * <p>
 * �ռ����ƣ�C/C++ 32M����������64M
 * <p>
 * ţţ������һ���ַ���A�������������һ���ַ���B��B�ĳ��ȴ��ڵ���A������ţţ���A����ú�B��һ���������������Ը���ţţһ�����ˡ�
 * ����A�ĳ������ӵ���B��һ������ʱ�򣬶�Ӧ��ÿһλ��ȵ�Խ�࣬�����Խϲ��������"abc"��"abd"��Ӧ��ȵ�λ��Ϊ2��Ϊǰ��λ��
 * ţţ������A�Ŀ�ͷ���߽�β��������ַ���ʹ�ó��Ⱥ�Bһ����������ţţ��A��������ַ�֮�󣬲���ȵ�λ�������ж���λ��
 * <p>
 * ��������:
 * ��һ��Ϊ�ַ���A���ڶ���Ϊ�ַ���B��A�ĳ���С�ڵ���B�ĳ��ȣ�B�ĳ���С�ڵ���50.�ַ���ΪСд��ĸ��
 * <p>
 * �������:
 * ���һ��������ʾA��������ַ�֮�󣬲���ȵ�λ�������ж���λ��
 * <p>
 * ��������1:
 * abe
 * cabc
 * <p>
 * �������1:
 * 1
 **/
