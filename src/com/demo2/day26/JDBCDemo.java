package com.demo2.day26;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by whb on 2017/7/18.
 * 使用jdbc插入数据
 * 使用自己封装的 jdbc工具类
 */
public class JDBCDemo {

//    插入一条数据
    @Test
    public void testJdbc () throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        //编写sql
        String sql = "INSERT INTO kanban VALUE (?,?,?)";
        //创建于编译的语句
        PreparedStatement st = conn.prepareStatement(sql);
        //设置参数
        st.setString(2,"第二个");
        st.setString(3,"第三个");

        //执行sql
        int  i = st.executeUpdate();
        //处理结果
        if (i==1) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        //释放资源.
        //rs.close();
        st.close();
        conn.close();
    }

    @Test
    public void testJDBCUtils(){

    }
}
