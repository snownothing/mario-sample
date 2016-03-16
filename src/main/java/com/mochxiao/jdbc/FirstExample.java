package com.mochxiao.jdbc;
//STEP 1. Import required packages

import org.junit.Test;

import java.sql.*;

/**
 * Created by Moch on 3/16/16.
 */
public class FirstExample {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/MXDB";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "8008208820";

    @Test
    public void testJDBC() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    @Test
    public void testSQLDateTime() {
        //Get standard date and time
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        System.out.println("The Java Date is:" + javaDate.toString());

        //Get and display SQL DATE
        java.sql.Date sqlDate = new java.sql.Date(javaTime);
        System.out.println("The SQL DATE is: " + sqlDate.toString());

        //Get and display SQL TIME
        java.sql.Time sqlTime = new java.sql.Time(javaTime);
        System.out.println("The SQL TIME is: " + sqlTime.toString());

        //Get and display SQL TIMESTAMP
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
        System.out.println("The SQL TIMESTAMP is: " + sqlTimestamp.toString());
    }

    @Test
    public void testTranscation() {
        Connection conn = null;
        Statement stmt = null;
        Savepoint savepoint1 = null;

        try {
            System.out.println("start try...");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Assume a valid connection object conn
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            savepoint1 = conn.setSavepoint("Savepoint1");

            String SQL = "INSERT INTO Employees VALUES (106, 20, 'Rita', 'Tez')";
            stmt.executeUpdate(SQL);

            //Submit a malformed SQL statement that breaks
            SQL = "INSERTED INTO Employees VALUES (107, 22, 'Sita', 'Singh')";
            stmt.executeUpdate(SQL);

            // If there is no error.
            conn.commit();

            System.out.println("ending try...");
        } catch (SQLException se) {
            // If there is any error.
            try {
                // 回滚到指定的还原点
                conn.rollback(savepoint1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                try {
                    if(conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}
