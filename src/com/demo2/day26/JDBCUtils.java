package com.demo2.day26;

import java.sql.*;

/**
 * Created by whb on 2017/7/18.
 * 简单的jdbc工具类实现
 */
public class JDBCUtils {
    //获取连接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        return conn;
    }
    /**
     * 释放资源
     * @param conn 连接
     * @param st 语句执行者
     * @param rs 结果集
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConn(conn);
    }

    private static void closeConn(Connection conn) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn=null;
        }
    }

    private static void closeStatement(Statement st) {
        if (st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st=null;
        }
    }

    /**
     * 释放结果集
     * @param rs 结果集
     */
    private static void closeResultSet(ResultSet rs) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs=null;
        }
    }

}
