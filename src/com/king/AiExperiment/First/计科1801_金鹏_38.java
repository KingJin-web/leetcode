package com.king.AiExperiment.First;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-05 17:18
 */
public class �ƿ�1801_����_38 {
    public static void main(String[] args) {
        int nDisks = 5;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("���� 1 �� " + from + " �� " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("���� " + topN + " �� " + from + " �� " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
