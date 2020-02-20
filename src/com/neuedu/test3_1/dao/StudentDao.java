package com.neuedu.test3_1.dao;

import com.mysql.jdbc.Driver;
import com.neuedu.test3.util.JdbcUtil;
import com.neuedu.test3_1.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/20 16:54
 */
public class StudentDao implements IstudentDao {
    String url = "jdbc:mysql://192.168.59.190:3306/db1?useUnicode=true&characterEncoding=utf8";
    String usename = "root";
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
            con = DriverManager.getConnection(url, usename, password);
            // 创建命令行，写sql语句
            ps = con.prepareStatement("select id,name,classname,gender from student");
            // 执行sql语句
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setClassname(rs.getString("classname"));
                student.setGender(rs.getInt("gender"));
                list.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        return list;
    }

    @Override
    public int add(Student student) {
        Object[] pss = {student.getName(),student.getClassname(),student.getGender()};
        return JdbcUtil.executeUpdate("insert into student(name,classname,gender) values(?,?,?)",pss);
    }

    @Override
    public int update(Student student) {
        Object[] pss = {student.getName(),student.getClassname(),student.getGender(),student.getId()};
        return JdbcUtil.executeUpdate("update student set name=?,classname=?,gender=? where id=?",pss);
    }

    @Override
    public int del(int id) {
        Object[] pss = {id};
        return JdbcUtil.executeUpdate("delete from student where id=?",pss);
    }
}
