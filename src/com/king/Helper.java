package com.king;

import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-07 21:04
 */
public class Helper {
    public static int[] getArrays(int... nums) {
        return nums;
    }

    public static String[] getArrays(String... s) {
        return s;
    }

    public static List<String> getList(String... s) {
        return Arrays.asList(s);
    }

    public static void print(Object o) {
        System.out.println(o);
    }
//    public static List<String> getArrays(String nums) {
//        return Arrays.asList(nums);
//    }
}
