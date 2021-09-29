package com.interview.py;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 2��/*ʵ�ֱ���D:\test\srcĿ¼�µ�����ͼƬ(jpg)
 * @author:King
 * @create:2021-09-28 19:15
 */

public class Test2 {
    static List<File> jpgFiles = new ArrayList<>();
    public static void findAllJpg(File file){

        if(!file.exists()){
            System.out.println("�ļ���Ŀ¼������!");
            return;
        }
        File[] fileArray= file.listFiles();

        for (File file1:fileArray){
            if (file1.isDirectory()){
                findAllJpg(file1);
            }else if (file1.getName().endsWith(".jpg")){
                jpgFiles.add(file1);
            }
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\test\\src\\");
        findAllJpg(file);
        jpgFiles.forEach(System.out::println);
    }
}
