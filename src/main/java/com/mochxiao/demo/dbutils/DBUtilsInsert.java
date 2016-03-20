package com.mochxiao.demo.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Moch on 3/20/16.
 */
public class DBUtilsInsert {

    @Test
    public void testInsert() {
        Connection conn;
        QueryRunner queryRunner = new QueryRunner();
        ArrayHandler arrayHandler = new ArrayHandler();
        try {
            Class.forName(DBConf.JDBC_DRIVER);
            conn = DriverManager.getConnection(DBConf.DB_URL, DBConf.USER, DBConf.PASS);

            String sql = "INSERT INTO user(name, age) VALUES(?, ?)";
            Object[] objectArr = queryRunner.insert(conn, sql, arrayHandler, "日天", 18);
            System.out.println("数组长度：" + objectArr.length + "；第0个元素的值：" +objectArr[0]);
            objectArr = queryRunner.insert(conn, sql, arrayHandler, "良辰", 19);
            System.out.println("数组长度：" + objectArr.length + "；第0个元素的值：" +objectArr[0]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
