package com.mochxiao.dbcp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by Moch on 3/16/16.
 */

@WebServlet(name = "DBCPSample", urlPatterns = {"/dbcp"})
public class DBCPSample extends HttpServlet {

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            Properties properties = new Properties();
//            properties.load(getServletContext().getResourceAsStream("dbcp.properties"));
//            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
//            Connection conn = dataSource.getConnection();
//            String sql = "select 1+1 as result;";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//
//            if(rs.next()) {
//                int result = rs.getInt("result");
//                out.println("result: " + result);
//            }
//
//            rs.close();
//            pstmt.close();
//            conn.close();
//
//        } catch (Exception ex) {
//            out.println(ex.getMessage());
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        processRequest(request, response);
//    }

}
