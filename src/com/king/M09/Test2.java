package com.king.M09;

import com.king.Helper;
import com.king.ListNode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: leetcode
 * @description: ��ָ Offer 22. �����е�����k���ڵ�
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: King
 * @create: 2021-09-02 18:08
 */
public class Test2 {


//ִ����ʱ�� 0 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 36.3 MB , ������ Java �ύ�л����� 41.18% ���û�
public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode fast = head;
    while(fast!=null) {
        fast = fast.next;
        if(k==0) {
            head = head.next;
        }else {
            k--;
        }
    }
    return head;
}

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        ListNode listNode = new ListNode(Helper.getArrays(1,2,3,4,5,6));
        Helper.print(test2.getKthFromEnd(listNode,2));
    }











    public static class s{
        /**
         * �������ڻ�������ܵ�����
         *
         * @param mdate
         * @return
         */
        @SuppressWarnings("deprecation")
        public static List<Date> dateToWeek(Date mdate) {
            int b = mdate.getDay();

            Date fdate;
            List<Date> list = new ArrayList<>();
            long fTime = mdate.getTime() - (long) b * 24 * 3600000;
            for (int a = 1; a <= 7; a++) {
                fdate = new Date();
                fdate.setTime(fTime + (a * 24 * 3600000)); //һ�ܴ���һ��ʼ�㣬��ʹ�ô˷�ʽ
                //fdate.setTime(fTime + ((a-1) * 24*3600000)); //һ�ܴ����տ�ʼ�㣬��ʹ�ô˷�ʽ
                list.add(a - 1, fdate);
            }

            return list;
        }

        /**
         * ����
         *
         * @param args
         */
        public static void main(String[] args) {
            // ����������ڸ�ʽ
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            List<Date> days = dateToWeek(currentDate);
            System.out.println("���������: " + sdf.format(currentDate));
            for (Date date : days) {
                System.out.println(sdf.format(date));

            }
            List<Date> list = dateToWeek(new Date());
            String startDate = sdf.format(list.get(0));
            String endDate = sdf.format(list.get(1));
            Helper.print(startDate + " " +endDate);
        }
    }
}
