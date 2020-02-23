package com.neuedu.test2.demo3;

import java.io.*;

/**
 * 1.把一个Java对象存到硬盘里 ObjectOutputStream（前提：该Java对象必须是可序列化对象）
 * 2.将序列化后的Java对象读取出来 ObjectInputStream
 *
 * 在类上实现序列化接口（java.io.Serializable）即可让对象成为可序列化对象,
 * 同时类上必须有一个序列化 UID（区分两个类是不是同一个对象）final long serialVersionUID = 1L;
 *
 * @author ldamei
 * @date 2020/2/12 22:18
 */
public class Test2 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("刘");
        student.setId(20);
        student.setAge(22);
        student.setGrade("卓越1班");
        File file = new File("d:/student");

        // 1 把一个Java对象存到硬盘里
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(student);
            oos.flush();
            os.flush();
            System.out.println("保存完成");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (oos != null)
                    oos.close();
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //  2 将序列化后的Java对象读取出来
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(file);
            ois = new ObjectInputStream(is);
            ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois != null)
                    ois.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
