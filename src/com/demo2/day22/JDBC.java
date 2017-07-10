package com.demo2.day22;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Administrator on 2017/7/10.
 */
public class JDBC {
    public static void main(String[] args) {

    }
    @Test
    public void f1 (){
        System.out.println("hello");
    }
    @Test
    public void f2 () throws Exception {
        System.out.println("hello World");
//        DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pmo", "root", "root");
        String sql = "select * from kanban";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("id") + " *****"+ rs.getString("kanban_cn"));
        }
        //释放资源.
        rs.close();
        st.close();
        conn.close();
    }
}
