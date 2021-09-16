package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1115. �����ӡFooBar
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/print-foobar-alternately
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author: King
 * @create: 2021-09-16 19:34
 */
public class Test16 {
    static class FooBar {
        private int n;
        private volatile boolean finish = false;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (finish) {
                    Thread.yield();
                }
                printFoo.run();
                finish = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (!finish) {
                    Thread.yield();
                }
                printBar.run();
                finish = false;
            }
        }


    }

    public static void main(String[] args) {
        //a��b������runnable ʵ������foo����bar����ִ�е���ԭ����run������
        Runnable a = ()->{
            System.out.print("foo");
        };

        Runnable b = ()->{
            System.out.print("bar");
        };

        FooBar fooBar2 = new FooBar(11);

        //����start���������lamada���ʽ������������
        new Thread(()->{
            try {
                fooBar2.bar(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooBar2.foo(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

//ִ����ʱ�� 24 ms , ������ Java �ύ�л����� 31.45% ���û� �ڴ����ģ� 38.3 MB , ������ Java �ύ�л����� 93.63% ���û�


