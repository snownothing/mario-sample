package com.mochxiao.demo.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

/**
 * Created by Moch on 3/20/16.
 */
public class DBUtilsSelect {

    @Test
    public void testSelect() {
        Connection conn;
        QueryRunner queryRunner = new QueryRunner();
        try {
            Class.forName(DBConf.JDBC_DRIVER);
            conn = DriverManager.getConnection(DBConf.DB_URL, DBConf.USER, DBConf.PASS);

            String sql = "SELECT id, name, age FROM user WHERE id = ?";
            Map<String, Object> resultMap = queryRunner.query(conn, sql, new MapHandler(), 1);
            System.out.println(resultMap);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void testMutlipSelect() {
        Connection conn;
        QueryRunner queryRunner = new QueryRunner();
        try {
            Class.forName(DBConf.JDBC_DRIVER);
            conn = DriverManager.getConnection(DBConf.DB_URL, DBConf.USER, DBConf.PASS);

            String sql = "SELECT id, name, age FROM user";
            List<Map<String, Object>> result = queryRunner.query(conn, sql, new MapListHandler());
            System.out.println(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
