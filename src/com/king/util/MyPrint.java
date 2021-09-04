package com.king.util;

import com.king.Helper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-04 11:26
 */
public class MyPrint {
    public static void printf(Object o) {
        System.out.print(o);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void print() {
        printf('\n');
    }

    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     *
     * @param o
     */
    public static void print(Object o) {

        if (isArray(o)) {
            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value);
                } else {
                    coll.add(value);
                }
            }
            if (!coll.isEmpty()) {
                Helper.print(coll);
            }
        } else if (getType(o).contains("List")){
            List list  = (List) o;
            System.out.print("[");
            for (Object object :list) {
                    print(object);
            }
           // printf(']');
        } else {
            System.out.println(o);
        }

    }

    public static void printIsLn(Object o){
        print(o,true);
        print();
    }
    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     *
     * @param o
     */
    public static void print(Object o,boolean b) {

        if (isArray(o)) {
            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value,true);
                } else {
                    coll.add(value);
                }
            }
            if (!coll.isEmpty()) {
                print(coll,true);
            }
        } else if (getType(o).contains("List")){
            List list  = (List) o;
            print("[",false);
            for (Object object :list) {
                print(object,false);
            }
           print("]",false);
        } else  {
            if (b){
                System.out.println(o);
            }else {
                System.out.print(o);
            }
        }

    }
//    public static void print(int[]... s) {
//        print(Arrays.deepToString(s));
//    }

    public static void print(Object o, int n) {
        if (isArray(o)) {
            Collection<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                coll.add(value);
            }
            print(toString(coll.toArray(), n));
        } else {
            print("�ⲻ������ !");
            print(o);
        }
    }

    public static void print(Object[] o, int l) {

        for (int i = 1; i < o.length; ++i) {
            System.out.print(o[i - 1] + ", ");
            if (i % l == 0) {
                System.out.print('\n');
            }
        }
        System.out.println(o[o.length - 1]);

    }

    public static void println(int... objects) {
        print(objects);
    }

    public static void print(Object[]... o) {
        print(Arrays.deepToString(o));
    }


    public static void print(String[]... s) {
        print(Arrays.deepToString(s));
    }

    public static void print(char[]... chars) {
        print(Arrays.deepToString(chars));
    }

    public static void print(List<List<Integer>> o) {
        for (List<Integer> l : o) {
            System.out.println(l);
        }
    }

    public static void printList(List list) {


        for (Object o : list) {
            if (o instanceof List) {
                printList((List) o);
            } else {
                System.out.print(o + " ");
            }
        }
        System.out.println();
    }

    /**
     * �����Ƿ�Ϊ�������
     *����
     * @param obj ����
     * @return �Ƿ�Ϊ����������Ϊ{@code null} ���ؿ�ָ��
     */
//    public static boolean isType(Object obj,Class<T> type) {
//        if (null == obj) {
//            throw new NullPointerException("Object is null");
//        }
//        return obj instanceof List;
//    }
    /**
     * �����Ƿ�Ϊ�������
     *
     * @param obj ����
     * @return �Ƿ�Ϊ����������Ϊ{@code null} ���ؿ�ָ��
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            throw new NullPointerException("Object check for isArray is null");
        }
//        ���� �������
        return obj.getClass().isArray();
    }


    /**
     * �����ҳ
     *
     * @param o ����
     * @param l ÿҳ������
     * @return
     */
    private static String toString(Object[] o, int l) {
        if (o == null)
            return "null";
        int iMax = o.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[ ");
        for (int i = 1; i < o.length; ++i) {

            b.append(String.format("%-5s ", o[i - 1]));
            if (i % l == 0) {
                b.append("]\n[ ");
            }

        }
        b.append(o[iMax]).append(" ]\n");

        return b.toString();
    }

    /**
     * ��ȡ������������
     *
     * @param o
     * @return
     */
    public static String getType(Object o) {
        return o.getClass().getSimpleName();
    }

    public static void printError(String message) {
        System.err.println(message);
    }
}