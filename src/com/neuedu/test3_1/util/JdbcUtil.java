package com.neuedu.test3_1.util;

import java.sql.*;

/**
 * @author ldamei
 * @date 2020/2/20 18:27
 */
public class JdbcUtil {
    private static final String URL = "jdbc:mysql://192.168.59.190:3306/db1?useUnicode=true&characterEncoding=utf8";
    private static final String USENAME = "root";
    private static final String PASSWORD = "123456";

    static {
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 创建连接方法
    public static Connection getconnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USENAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 通用增删改方法
    public static int executeUpdate(String sql, Object[] pss) {
        int result = 0;
        Connection con = getconnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            // 判断问号的个数
            if (pss != null) {
                for (int i = 0; i < pss.length; i++) {
                    ps.setObject(i + 1, i);
                }
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con,ps);
        }
        return result;
    }

    // 通用关闭方法
    public static void close(Connection con, PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            close(con,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
