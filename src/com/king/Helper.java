package com.king;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
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

    public static void print(Object[] o) {
        System.out.println(Arrays.toString(o));
    }

    public static void print(Object[]... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static void print(int[] ...s) {
        System.out.println(Arrays.deepToString(s));
    }

    public static void print(String[] ...s) {
        System.out.println(Arrays.deepToString(s));
    }

    public static void print(char[] ...chars) {
        System.out.println(Arrays.deepToString(chars));
    }

    public static void printList(List<List<Integer>> o) {
        for (List<Integer> l: o) {
            System.out.println(l);
        }
    }
//    public static List<String> getArrays(String nums) {
//        return Arrays.asList(nums);
//    }

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true; // auto detect if possible.
    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString( last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
