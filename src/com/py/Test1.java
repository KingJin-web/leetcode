package com.py;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-28 19:13
 */
//1��/*��javaʵ��̨��ӡ�žų˷��ھ���*/
public class Test1 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (j == i) {
                    System.out.println(j + "*" + i + "=" + (j * i) + " ");
                } else {
                    System.out.print(j + "*" + i + "=" + (j * i) + " ");
                }
            }
        }
    }
}
