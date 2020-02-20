package com.neuedu.test4.demo2;

import com.neuedu.test3_1.Student;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ldamei
 * @date 2020/2/20 22:19
 */
public class Shiwu {
    static String url = "jdbc:mysql://192.169.59.190:3306/db1?useUnicode=true&Encoding=utf8";
    static String usename = "root";
    static String password = "123456";

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();  // 创建线程池
        // 开启一个线程执行事务1
        service.execute(()->{
            shiwu1();
        });
        // 开启另一个线程执行事务2
        service.execute(()->{
            shiwu12();
        });
    }

    public static void shiwu1() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usename, password);
            con.setAutoCommit(false);
            con.setTransactionIsolation(1);  // 隔离级别为1
            ps = con.prepareStatement("insert into student (name,classname,gender)values (?,?,?)");
            ps.setString(1, "刘");
            ps.setString(2, "1班");
            ps.setInt(3, 0);
            int i = ps.executeUpdate();
            System.out.println(i);

            Thread.sleep(3000);
            int j = 100/0;
            con.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void shiwu12() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usename, password);
            con.setAutoCommit(false);
            ps = con.prepareStatement("select id,name,classname,gender from student");
            Thread.sleep(1000);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setClassname(rs.getString("classname"));
                student.setGender(rs.getInt("gender"));
                System.out.println(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
