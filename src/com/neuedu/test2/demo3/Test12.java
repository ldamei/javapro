package com.neuedu.test2.demo3;


import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * @author ldamei
 * @date 2020/2/11 22:33
 */
public class Test12 {
    public static void main(String[] args) {

        File file = new File("d:\\id\\new\\src\\com\\itdr\\basic1\\demo3\\Test2.java");
        /*System.out.println(file.getName());  // 获取文件名
        System.out.println(file.getPath());  // 获取文件路径
        System.out.println(file.length());  // 获取文件大小（字节）
//        System.out.println(file.mkdir());  // 创建目录，只创建目录的最后一级，必须保证前面的父目录存在
//        System.out.println(file.mkdirs());  // 创建目录，无论是任何一级，不存在就创建
//        System.out.println(file.delete());  // 删除文件
        System.out.println(file.exists());  // 查看文件是否存在
//        System.out.println(file.isDirectory());  // 查看是否是目录
//        System.out.println(file.isFile());  // 查看是否是文件
        try {
            System.out.println(file.createNewFile());  // 创建文件，如果不存在，就创建（返回true）；如果存在，就不创建（返回false）
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /**
         * 字节输出流 OutputStream
         *
         * 流属于对资源进行操作，所以必须要关闭
         * 字节输出流，默认将内容写入到文件中（覆盖源文件）
         * 如果想保留原先的内容，在构造的时候设置为追加内容
         */
        /*OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
            String a = "\n111111"; // 内存和文件之间架起一条传输管道
            outputStream.write(a.getBytes());  // write：把写的内容发送到管道上
            outputStream.flush();  // flush：把管道里的内容压入到文件里
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream != null)
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        /**
         * 字节输入流 InputStream
         */
        /*InputStream inputStream =null;
        try {
            inputStream = new FileInputStream(file);
            byte[] a = new byte[8];
            int b = inputStream.read(a);
            while(b != -1){
                System.out.println("读取字节个数："+b);
                System.out.println(new String(a,0,b));
                b = inputStream.read(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        /**
         * 字符输入流 Reader
         * 实现按行读：BufferedReader
         */
        char[] a = new char[8];
        Reader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader(file);
            br = new BufferedReader(reader);
//            int b = reader.read(a);
            String str = br.readLine();
            while (/*b != -1*/str != null) {
               /* System.out.println("读取字符个数：" +b);
                System.out.println(new String(a,0,b));
                b = reader.read(a);*/
                System.out.println(str);
                str = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 字符输出流 Writer
         */
       /* Writer writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write("ruvbuijdkduiefui");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}

