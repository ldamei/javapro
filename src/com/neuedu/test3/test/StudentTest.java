package com.neuedu.test3.test;

import com.neuedu.test3.Student;
import com.neuedu.test3.util.JdbcUtil;
import com.neuedu.test3.web.StudentWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
         * 类在第一次主动使用的时候，会把class加载到内存的方法区中，
         * 并且在堆区创建一个Class类型的对象，并指向该方法区，
         * 反射：获取该Class类型的对象
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

        // 自定义的是什么泛型，就返回什么什么泛型
         List<Student> list = JdbcUtil.executeQuery("select id,name,classname,gender from student",Student.class);
//        System.out.println(list);

        /**
         * 事务
         */
        Connection con2 = JdbcUtil.getConnection();
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        // 如果实现事务管理，就必须不能让每次增删改之后都自动提交
        try {
            con2.setAutoCommit(false);  // 设置是否自动提交
            ps2 = con2.prepareStatement("insert into student (name,classname,gender) values (?,?,?)");
            ps2.setString(1, "琴");
            ps2.setString(2, "卓越1班");
            ps2.setInt(3, 0);
            ps3 = con2.prepareStatement("insert into student (name,classname,gender) values (?,?,?)");
            ps3.setString(1, "琪");
            ps3.setString(2, "卓越1班");
            ps3.setInt(3, 1);

            int i = ps2.executeUpdate();
            System.out.println(i);
//            int a = 100/0;
            int j = ps3.executeUpdate();
            System.out.println(j);
            con2.commit();
        } catch (SQLException e) {
            try {
                con2.rollback();  // 回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps3 != null)
                    ps3.close();
                if (ps2 != null)
                    ps2.close();
                if (con2 != null)
                    con2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
