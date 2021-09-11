package com.king.contest.season_2021.fall;

import com.king.util.MyPrint;
import com.king.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 2. ������ս
 * https://leetcode-cn.com/contest/season/2021-fall/problems/uOAnQW/
 * @author: King
 * @create: 2021-09-11 16:31
 */
public class Test2 {
    //ִ����ʱ�� 94 ms , ������ Java �ύ�л����� 100.00% ���û� �ڴ����ģ� 53.9 MB , ������ Java �ύ�л����� 100.00% ���û�
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        for (int card : cards) {
            if (card % 2 != 0)
                odd.add(card);
            else
                even.add(card);
        }
        int oddSize = odd.size(), evenSize = even.size();
        int evenCount = Math.min(evenSize, cnt);
        int oddCount = cnt - evenCount;
        if (oddCount % 2 != 0) {
            oddCount++;
            evenCount--;
        }
        if (oddCount > oddSize || evenCount < 0)
            return 0;
        int score = 0;
        for (int i = 1; i <= oddCount; i++)
            score += odd.get(oddSize - i);
        for (int i = 1; i <= evenCount; i++)
            score += even.get(evenSize - i);
        int maxScore = score;
        int oddIndex = oddSize - oddCount, evenIndex = evenSize - evenCount;
        while (oddIndex >= 2 && evenIndex <= evenSize - 2) {
            score -= (even.get(evenIndex) + even.get(evenIndex + 1));
            score += (odd.get(oddIndex - 1) + odd.get(oddIndex - 2));
            maxScore = Math.max(maxScore, score);
            oddIndex -= 2;
            evenIndex += 2;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        MyPrint.print(test2.maxmiumScore(StringUtil.stringToIntegerArray("[1,2,8,9]"),3));
    }
}
