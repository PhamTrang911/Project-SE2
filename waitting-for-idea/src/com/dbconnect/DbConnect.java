package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    private static String DB_URL = "jdbc:mysql://mysql-27918-0.cloudclusters.net:27918/se2_database?useSSL=false";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "laleafhanu";
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
