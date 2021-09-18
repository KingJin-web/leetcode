package com.king.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-17 20:46
 */
public class StringUtil {


    //����ַ������Ƿ�������  ���������ķ���
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Matcher m = p.matcher(str);
        return m.find();
    }

    //����ַ������Ƿ���˫�ֽ��ַ���������,���ķ���
    public static boolean isContainTwoByte(String str) {
        Pattern p = Pattern.compile("[^\\x00-\\xff]");
        Matcher m = p.matcher(str);
        return m.find();
    }


}
