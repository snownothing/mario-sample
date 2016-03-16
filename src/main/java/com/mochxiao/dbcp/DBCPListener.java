package com.mochxiao.dbcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Moch on 3/17/16.
 */

@WebListener
public class DBCPListener implements ServletContextListener {
    // 应用启动时，该方法被调用
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("设置数据库连接池");
            ServletContext application = sce.getServletContext();
            Properties properties = new Properties();
            InputStream inStream = application.getResourceAsStream("/WEB-INF/classes/dbcp.properties");
            properties.load(inStream);
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            application.setAttribute("dataSource", dataSource);
        }
        catch(Exception ex) {
            System.err.println("数据库连接池设置出现异常：" + ex.getMessage());
        }
    }

    // 应用关闭时，该方法被调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}