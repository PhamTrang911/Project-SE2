package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    
//    private static String DB_URL = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12395850?usessl=false";
//    private static String USER_NAME = "sql12395850";
//    private static String PASSWORD = "yVSitKAG2H";
    private static String DB_URL = "jdbc:mysql://mysql-22516-0.cloudclusters.net:22528/se2_database?useSSL=false";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "toan1999";
    public static Connection getConnection()  {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
		return conn;
	}
}
