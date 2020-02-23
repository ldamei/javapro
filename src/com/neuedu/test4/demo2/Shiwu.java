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
    public static String url = "jdbc:mysql://192.168.59.190:3306/db1?useUnicode=true&characterEncoding=utf8";
    public static String usename = "root";
    public static String password = "123456";

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();  // 创建线程池
        // 开启一个线程执行事务1（写线程）
        service.execute(()->{
            shiwu1();
        });
        // 开启另一个线程执行事务2（读线程）
        service.execute(()->{
            shiwu12();
        });
        service.shutdown();
    }

    public static void shiwu1() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usename, password);
            con.setAutoCommit(false);// 设置自动提交（默认为true）
            Thread.sleep(1000);
            ps = con.prepareStatement("insert into student (id,name,classname,gender)values (?,?,?,?)");
//            ps = con.prepareStatement("update student set name=?,classname=?,gender=? where id=?");
            ps.setInt(1,1);
            ps.setString(2, "刘");
            ps.setString(3, "2班");
            ps.setInt(4, 0);
            int i = ps.executeUpdate();
            System.out.println("事务1执行："+i);

//            Thread.sleep(3000);
//            int j = 100/0;
            con.commit();  // 提交

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                con.rollback();  // 回滚
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
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usename, password);
            con.setAutoCommit(false);
            // 设置隔离级别为1时，允许脏读（读未提交）
            // 设置隔离级别为2时，读已提交
            // 设置隔离级别为4时，可重复读
            con.setTransactionIsolation(8);
            ps = con.prepareStatement("select id,name,classname,gender from student where id=1");
//            Thread.sleep(1000);
            rs = ps.executeQuery();
            /*while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setClassname(rs.getString("classname"));
                student.setGender(rs.getInt("gender"));
                System.out.println(student);
            }*/
            if (rs.next()){
                System.out.println("事务2执行：存在id=1，不能添加");
            }else{
                System.out.println("事务2执行：不存在，可以添加");
                Thread.sleep(3000);
                ps2 = con.prepareStatement("insert into student (id,name,classname,gender)values (?,?,?,?)");
                ps2.setInt(1,1);
                ps2.setString(2, "刘");
                ps2.setString(3, "2班");
                ps2.setInt(4, 0);
                int i = ps2.executeUpdate();
                System.out.println("事务2执行："+i);
            }
            con.commit();

            /*Thread.sleep(3000);
            ps2 = con.prepareStatement("select id,name,classname,gender from student");
            rs = ps2.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setClassname(rs.getString("classname"));
                student.setGender(rs.getInt("gender"));
                System.out.println(student);
            }*/
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
                if (ps2 != null)
                    ps2.close();
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
