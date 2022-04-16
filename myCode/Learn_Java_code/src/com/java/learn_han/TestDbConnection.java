package com.java.learn_han;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
public class TestDbConnection {

    private static String SERVER_MYSQL5_7 = "jdbc:mysql://192.168.23.129:3306/";
    private static String SERVER_MYSQL5_7_USER = "root";
    private static String SERVER_MYSQL5_7_PASS = "root";
    private static String SERVER_MYSQL8 = "jdbc:mysql://localhost:3306/";
    private static String SERVER_MYSQL8_USER = "root";
    private static String SERVER_MYSQL8_PASS = "123456";

    private static String TABLE_NAME = "tbl_book";

    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";  //获取mysql数据库的驱动类
        String url = SERVER_MYSQL5_7 + "ssm_db"; //连接数据库（kucun是数据库名）
        String name = SERVER_MYSQL5_7_USER;//连接mysql的用户名
        String pwd = SERVER_MYSQL5_7_PASS;//连接mysql的密码
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, name, pwd);//获取连接对象
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection cc = TestDbConnection.getConnection();
        if (!cc.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        Statement statement = cc.createStatement();
        String sql = "select * from " + TABLE_NAME;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("id") + " " + rs.getString("name"));
        }
    }
}