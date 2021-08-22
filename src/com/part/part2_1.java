package com.part;


import com.king.Helper;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @program: leetcode
 * @description: д?�������ܹ���ѹ���� 2.1.zip �е����к�׺Ϊtxt��?��?���� ע��:
 * 1. ����?����������?��������ֻҪ��ѹtxt?����
 * 2. ѹ����??��������ѹ����
 * 3. ����??д?��������ɽ�ѹ�����Ե�?����?�⣬������ʹ?�ⲿ���������ѹ��
 * @author: King
 * @create: 2021-08-21 22:26
 */
public class part2_1 {


    /**
     * ��ѹ ָ��ѹ���ļ������� .txt�ļ�
     *
     * @param zipPath ѹ���ļ�·��
     * @param outPath ��ѹ�ļ�·�� ���Ϊ�վͻ�Ĭ�Ͻ�ѹ��ѹ���ļ�Ŀ¼��
     * @return
     */
    public static boolean UnZipInTxt(String zipPath, String outPath) {
        File infile = new File(zipPath); //��ѹ�ļ�
        File outfile = null; //��ѹ����Ŀ¼
        if (outPath.equals("")) {
            outPath = infile.getParentFile().getPath();
        }
        byte[] buf = new byte[1024];
        int readedBytes;
        if (!infile.exists() || !zipPath.endsWith(".zip")) {
            System.out.println("�ļ������ڣ������ļ�����zip�ļ�");
            return false;
        }
        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(infile)), Charset.forName("gbk"))) {
            ZipEntry zipEntry = null;
            String fileName;
            while ((zipEntry = zis.getNextEntry()) != null) {

                fileName = zipEntry.getName(); //��ȡ�ļ���
                if (fileName.endsWith(".txt")) {
                    outfile = new File(outPath + "\\" + zipEntry.getName()); //��ý�ѹĿ��·��
                    //���ָ���ļ���Ŀ¼������,�򴴽�֮.
                    File parent = outfile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outfile))) {
                        while ((readedBytes = zis.read(buf)) > 0) {
                            bos.write(buf, 0, readedBytes);
                        }
                    }
                } else {
                    if (zipEntry.isDirectory()) {
                        outfile = new File(outPath + "\\" + zipEntry.getName()); //��ý�ѹĿ��·��
                        System.out.println(outfile.getPath());
                        outfile.mkdirs();
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        UnZipInTxt("D:\\a\\a.zip", "");
    }

}



