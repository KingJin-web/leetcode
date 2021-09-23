package com.king.util;

import MyJava.exam.T1;
import com.king.Helper;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public static void main(String[] args) {
//        String[] ss = LeetcodeUtil.stringToStringArray("[\"ale\",\"apple\",\"monkey\",\"plea\"]");
//        List<String[]> dictionary = new ArrayList<>();
////        dictionary.add(ss);
////        dictionary.add(new String[]{"a", "s0"});
////        MyPrint.print(dictionary);
////        MyPrint.print(dictionary, dictionary);
//        print(T1.class);
        List<Integer> list = Helper.getList(1,2,3,6,4,8,9);
        List<Integer> list1 = Helper.getList(1,3,6,9,2,4);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list);
        lists.add(list1);
        print(lists);
    }


    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(List... os) {
        for (Object o : os) {
            print(o);
        }
    }

    public static void printf(Object o) {
        System.out.print(o);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    //���һ������
    public static void print() {
        printf('\n');
    }

    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     * //�Լ���װ�����������ֱ�Ӵ�ӡ���飬list����
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
//                Helper.print(coll);
                print(coll);
            }
        } else if (o instanceof List) {
            List list = (List) o;
            print("=========list-start=========");
            if (list.size() <= 0) {
                print("null");
                return;
            }
            if (!isArray(list.get(0))) {
                if (list.get(0) instanceof Number || list.get(0) instanceof String){
                    System.out.println(list);
                }else {
                    list.forEach(MyPrint::println);
                }

            } else {
                for (Object o1 : list) {
                    int length = Array.getLength(o1);
                    List<Object> coll = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        Object value = Array.get(o1, i);
                        coll.add(value);
                    }
                    print(coll.toArray());
                }
            }
            print("=========list-end=========");
        } else {
            System.out.println(o);
        }

    }


    public static void printIsLn(Object o) {
        print(o, true);
        print();
    }

    //    print(MyPrint.class);
    public static void print(Class<?> c) {
        Field[] fields = c.getFields();
        print(fields.length);
        Method[] methods1 = c.getMethods();
        print(methods1, 1);
        print();
        Method[] methods2 = c.getDeclaredMethods();
        print(methods2, 1);
    }


    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     *
     * @param o
     */
    public static void print(Object o, boolean b) {

        if (isArray(o)) {
            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value, true);
                } else {
                    coll.add(value);
                }
            }
            if (!coll.isEmpty()) {
                print(coll, true);
            }
        } else if (getType(o).contains("List")) {
            List list = (List) o;
            print("[", false);
            for (Object object : list) {
                print(object, false);
            }
            print("]", false);
        } else {
            if (b) {
                System.out.println(o);
            } else {
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
        if (o.length <= 0) {
            print("null");
            return;
        }
        if (o.length == 1) {
            print(o[0]);
            return;
        }
        for (int i = 1; i < o.length; ++i) {
            System.out.print(o[i - 1] + ", ");
            if (i % l == 0) {
                print();
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

//    public static void print(List<List<Integer>> o) {
//        o.forEach(MyPrint::print);
//    }

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
//    public static boolean isType(Object obj,Class type) {
//        if (null == obj) {
//            throw new NullPointerException("Object is null");
//        }
//        return obj instanceof type;
//    }

    /**
     * �����Ƿ�Ϊ�������
     *
     * @param obj ����
     * @return �Ƿ�Ϊ����������Ϊ{@code null} ���ؿ�ָ��
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            //throw new NullPointerException("Object check for isArray is null");
            print("null");
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
