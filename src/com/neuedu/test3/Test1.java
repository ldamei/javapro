package com.neuedu.test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ldamei
 * @date 2020/2/18 13:23
 */
public class Test1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://192.168.59.190:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";

        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 1.加载驱动，连哪种数据库就要加载哪种驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.创建连接，通过DriverManager类来实现
            con = DriverManager.getConnection(url,username,password);
            // 3.jdbc中要操作的库已经包含在url中（省略）

            // 4.创建一个可以写sql语句的地方
            ps = con.prepareStatement("insert into student(id,id2,name,classname) values(7,3,'苏','mm')");
            // 5.在jdbc中，该操作包含在创建PreparedStatement中了

            // 6.如果是增删改查，则用PreparedStatement对象调用 executeUpdate方法，返回int（受影响的行数）
            //   如果是查询，则用PreparedStatement对象调用executeQuery,返回ResultSet对象（结果集）
            int a = ps.executeUpdate();
            System.out.println(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 7.对于con和ps来说，都是资源，使用后要进行关闭
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
}
