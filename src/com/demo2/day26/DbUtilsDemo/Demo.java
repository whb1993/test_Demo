package com.demo2.day26.DbUtilsDemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by whb on 2017/7/18.
 * DbUtils 测试使用
 */
public class Demo {
    @Test
    public void insert() throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from kanban";
        Object[] query = qr.query(sql, new ArrayHandler());
        System.out.println(Arrays.toString(query));
    }
}
/**
 AbstractListHandler 将ResultSet转为List的抽象类
 ArrayHandler 将ResultSet转为一个Object[]的ResultSetHandler实现类
 ArrayListHandler 将ResultSet转换为List<Object[]>的ResultSetHandler实现类
 BeanHandler 将ResultSet行转换为一个JavaBean的ResultSetHandler实现类
 BeanListHandler 将ResultSet转换为List<JavaBean>的ResultSetHandler实现类
 ColumnListHandler 将ResultSet的一个列转换为List<Object>的ResultSetHandler实现类
 KeyedHandler 将ResultSet转换为Map<Map>的ResultSetHandler实现类
 MapHandler 将ResultSet的首行转换为一个Map的ResultSetHandler实现类
 MapListHandler 将ResultSet转换为List<Map>的ResultSetHandler实现类
 ScalarHandler 将ResultSet的一个列到一个对象。
  */
