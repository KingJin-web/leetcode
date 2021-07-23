package com.king.M05;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: ��ָ Offer 40. ��С��k����
 * @author: King
 * @create: 2021-05-25 23:25
 */
public class Test23 {
    //������������ arr ���ҳ�������С�� k ���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public void ��ӡ������(){
        int length = 9;
        int height = 7;
        for (int i=0;i<height;i++) {
            for (int j=0;j<length;j++) {
                if ( i == 0 ) {
                    System.out.print("*");
                }
                else if (i == height-1) {
                    System.out.print("*");
                }
                else if (j == 0 || j == length-1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        Test23 test23 = new Test23();
        test23.��ӡ������();




        int[] arr = {3,2,1};
        int k = 2;
        int[] a = test23.getLeastNumbers(arr,k);
        System.out.println(Arrays.toString(a));

    }
}
