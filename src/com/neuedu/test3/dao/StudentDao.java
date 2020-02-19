package com.neuedu.test3.dao;

import com.neuedu.test3.Student;
import com.neuedu.test3.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/19 9:14
 */
public class StudentDao implements IstudentDao{
   String url = "jdbc:mysql://192.168.59.190:3306/db1?useUnicode=true&characterEncoding=utf8";
   String username = "root";
   String password = "123456";

    @Override
    public List<Student> query() {
        List<Student> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接
            con = DriverManager.getConnection(url,username,password);
            // 创建命令行，写sql语句
            ps = con.prepareStatement("select id,name,classname,gender from student");
            // 执行sql语句
            // 如果是查询，调用executeQuery方法，返回一个ResultSet结果集
            rs = ps.executeQuery();
            /**
             * ResultSet每次调用next()方法的时候，会做两件事
             *  1.看一下有没有下一行，如果没有返回fasle
             *  2.如果有，将游标推向下一行，返回true
             */
            while(rs.next()){
                Student student = new Student();
                student.setIdd(rs.getInt("idd"));
                student.setName(rs.getString("name"));
                student.setClassname(rs.getString("classname"));
                student.setGender(rs.getInt("gender"));
                list.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }

    @Override
    public int add(Student student) {
        String sql = "insert into student (name,classname,gender) values (?,?,?)";
        Object[] pss = {student.getName(),student.getClassname(),student.getGender()};
        int i = JdbcUtil.executeUpdate(sql,pss);
        return i;
    }

    @Override
    public int update(Student student) {
        String sql = "update student set name=?,classname=?,gender=? where id=?";
        Object[] pss = {student.getName(),student.getClassname(),student.getGender(),student.getIdd()};
        int i = JdbcUtil.executeUpdate(sql,pss);
        return i;
    }

    @Override
    public int del(int id) {
        String sql = "delete from student where id=?";
        Object[] pss = {id};
        int i = JdbcUtil.executeUpdate(sql,pss);
        return i;
    }

    @Override
    public Student queryOne(int id) {
        return null;
    }
}
