package com.neuedu.test2.demo3;

import java.io.*;

/**
 * 把d盘下某个文件复制到d:/a文件夹下
 * (把文件里的内容读到内存里，再从内存写到另一个文件中)
 * @author ldamei
 * @date 2020/2/12 12:39
 */

public class Test {
    public static void main(String[] args) {
        File from = new File("d:\\01-IT技术应用.wmv");
        File parent = new File("d:\\a");
        if (!parent.exists()){
            parent.mkdir();
        }
        File to = new File("d:\\a\\"+from.getName());

        InputStream inputStream = null;
        OutputStream outputStream = null;
        byte[] b=new byte[1024];
        try {
            inputStream = new FileInputStream(from);
            outputStream = new FileOutputStream(to);
            int len = inputStream.read(b);
           while(len != -1) {
               outputStream.write(b,0,len);
               outputStream.flush();
               len = inputStream.read(b);
           }
            System.out.println("复制成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream != null)
                    outputStream.close();
                if(inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
