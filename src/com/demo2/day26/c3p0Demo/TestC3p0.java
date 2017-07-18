package com.demo2.day26.c3p0Demo;

import com.demo2.day22.JdbcUtils;
import com.demo2.day26.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by whb on 2017/7/18.
 */
public class TestC3p0 {
    /**
     * 硬编码模式的c3p0
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void test() throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql:///test");
        ds.setUser("root");
        ds.setPassword("root");
        Connection conn = ds.getConnection();
        String sql = "update kanban set test = ? where cid = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,"a");
        st.setString(2,"b");
        int i = st.executeUpdate();
        System.out.println(i);
        JDBCUtils.closeResource(conn,st,null);
    }

    /**
     * 使用配置文件方式
     * @throws Exception
     */
    @Test
    public void f2 () throws Exception{
        ComboPooledDataSource ds = new ComboPooledDataSource("c3p01");
        Connection conn = ds.getConnection();
        String sql = "insert into kanban values (?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,"a");
        st.setString(2,"b");
        int i = st.executeUpdate();
        System.out.println(i);
        JDBCUtils.closeResource(conn,st,null);
    }
}
