package com.king.M11;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 319. ���ݿ���
 * @author: King
 * @create: 2021-11-15 00:46
 */
public class Test15 {
//��ʼʱ��?n �����ݴ��ڹر�״̬����һ�֣��㽫������е��ݡ��������ĵڶ��֣��㽫��ÿ�������ݹر�һ����
//
//�����֣���ÿ�������ݾ��л�һ�����ݵĿ��أ������򿪱�رգ��رձ�򿪣����� i �֣���ÿ i �����ݾ��л�һ�����ݵĿ��ء�ֱ���� n �֣���ֻ��Ҫ�л����һ�����ݵĿ��ء�
//
//�ҳ������� n?�ֺ��ж��ٸ����ŵĵ��ݡ�
//
//��Դ�����ۣ�LeetCode��
//���ӣ�https://leetcode-cn.com/problems/bulb-switcher
//����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
    /**
     * ��ʼ��n�����ݹر�
     * ��i�ֵĲ�����ÿi�������л�һ�ο��أ���->�գ���->���������л�i�ı���λ�õĿ��ء�
     * ��n�ֺ����ŵĵ��ݣ�
     * ��1����i��ʱ�����л��ĵ���λ����i�ı�����
     * ��2���ɣ�1���ó������ڵ�p��������˵��ֻ����ڡ����ӡ��ֲŻ��л���������q�����ӣ������ձ��л�q�Ρ���Ϊ��ʼ״̬�ǹر�״̬����ô�������������ĵ������������ŵġ�
     * ��3��ֻ��ƽ���������Ӹ������ǳɶԳ��֣�������4=1*4,2*2����������1,2,4��
     * ��4����ô��Ŀ����ת��Ϊ1~n��ƽ�����ĸ���������ת��Ϊ��n��ƽ����������ȡ�����ɡ�
     */

    //ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 34.8 MB , ������ Java �ύ�л����� 96.95% ���û�
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }


    public static void main(String[] args) {
        Test15 test15 = new Test15();
        MyPrint.print(test15.bulbSwitch(3));
    }
}