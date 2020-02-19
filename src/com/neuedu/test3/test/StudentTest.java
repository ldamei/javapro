package com.neuedu.test3.test;

import com.neuedu.test3.Student;
import com.neuedu.test3.util.JdbcUtil;
import com.neuedu.test3.web.StudentWeb;

import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/19 9:18
 */
public class StudentTest {
    public static void main(String[] args) {
        StudentWeb studentWeb = new StudentWeb();
//        studentWeb.showmain();
//        studentWeb.input();

        /**
         * 反射：获取Class类型的对象
         * 获取该对象的方法
         *   1.类名.class
         *   2.对象名.getClass( )
         *   3.Class.forName("类的完全限定名")
         */
        /*// 1
        Class cls = Student.class;
        // 2
        Student student = new Student();
        Class cls2 = student.getClass();
        // 3
        try {
            Class cls3 = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        Class clz = Student.class;
        // 调用该类的无参构造创建一个对象
        try {
            clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 类下，每一个方法都会封装成 Method 类型的对象
        // 类下，每一个属性都会封装成 Field 类型的对象
        // 有多少个属性，就有多少个 Field；有多少个方法，就有多少个 Method
        /*Field[] fields = clz.getDeclaredFields();  // 可以获取到私有属性
        for (Field f : fields) {
            System.out.println(f.getName());
        }*/

         List<Student> list = JdbcUtil.executeQuery("select id,name,classname,gender from student",Student.class);
        System.out.println(list);
    }
}
