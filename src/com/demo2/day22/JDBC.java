package com.demo2.day22;

import org.junit.Test;

import java.sql.*;

/**
 * Created by Administrator on 2017/7/10.
 * jdbc练习
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
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pmo", "root", "root");
        //编写sql
        String sql = "select * from kanban";
        //创建于编译的语句
        PreparedStatement st = conn.prepareStatement(sql);
        //设置参数

        //执行sql
        ResultSet rs = st.executeQuery();
        //处理结果
        while (rs.next()){
            System.out.println(rs.getString("id") + " *****"+ rs.getString("kanban_cn"));
        }
        //释放资源.
        rs.close();
        st.close();
        conn.close();
    }
}
