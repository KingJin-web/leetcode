package com.king.M12;

/**
 * @program: leetcode
 * @description: 383. �����
 * @author: King
 * @create: 2021-12-04 23:22
 */
public class Test4 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // ��ͳ��magazine�еĴ�Ƶ
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        // �ٱ���ransomNote�е��ַ����Ӵ�Ƶ���м�ȥ
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i) - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }

}
