package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
//	private static String DB_URL = "jdbc:postgresql://ec2-35-171-57-132.compute-1.amazonaws.com:5432/d6eutdfc1nmhl7?sslmode=require";
//    private static String USER_NAME = "tslwrpevkasnbl";
//    private static String PASSWORD = "7db9edb113037a7ead5352e0e18c9a248a57c4d4e9afb7994b05010b449200c8";
    
    private static String DB_URL = "jdbc:mysql://localhost:3306/treestore?usessl=false";
    private static String USER_NAME = "root";
    private static String PASSWORD = "Tuntun99!";
    
    public static Connection getConnection()  {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.print("success!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
		return conn;
	}
}
