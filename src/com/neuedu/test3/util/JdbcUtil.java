package com.neuedu.test3.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ldamei
 * @date 2020/2/19 14:19
 */
public class JdbcUtil<T> {
    private static final String URL = "jdbc:mysql://192.168.59.190:3306/db1?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    static{
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 创建连接
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 封装通用的增删改方法
    public static int executeUpdate(String sql,Object[] pss){
        int result = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            if (pss != null){
                for (int i = 0; i < pss.length; i++) {
                    ps.setObject(i+1,pss[i]);
                }
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,ps);
        }
        return result;
    }

    // 封装通用的查询方法
    public static <T> List<T> executeQuery(String sql,Class<T> clz,Object... pss){
        List<T> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            if (pss != null){
                for (int i = 0; i < pss.length; i++) {
                    ps.setObject(i+1,i);
                }
            }
            rs = ps.executeQuery();
            while(rs.next()){
                // 创建一个T类型的对象
                // 该方法是通过反射 class对象，调用无参构造来创建对象
                T t = clz.newInstance();
                // 通过字段名，从rs中拿值，然后赋值给对象的属性
                // 在不知道该类有多少个属性的情况下，有多少个属性，就set多少个属性
                Field[] fields = clz.getDeclaredFields();
                for (Field f : fields) {
                    // 属性名刚好和数据库里的字段名一样
                    // 可以把属性名当做字段名，用rs.getObject(属性名);拿出来
                    try {
                        // f.getName()可能和数据库中的字段名不同
                        // 先看该属性有没有Column注解，如果有，用注解的值当做字段名
                        // 如果没有注解，再把f.getName()当做字段名
                        String column = f.getName();
                        if (f.isAnnotationPresent(Column.class)){
                            Column column1 = f.getAnnotation(Column.class);
                            column1.value();
                        }
                        Object value = rs.getObject(f.getName());
                        // 拿出值之后，给属性赋值
                        // 属性对象是Filed，但必须指明给哪个对象的属性赋值
                        // 调用filed，调用set方法进行赋值
                        /**
                         * 第一个参数，传一个对象，表示为哪个对象赋值
                         * 第二个参数，传值，表示赋什么样的值
                         * 注意：如果该属性是private，在赋值之前必须先打开权限
                         */
                        f.setAccessible(true);
                        f.set(t, value);
                    }catch (Exception ex){}
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 封装关闭方法
    static void close(Connection con,PreparedStatement ps){
        try {
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void close(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            close(con,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
