package com.test.accounts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Db {
	public static boolean isInit = false;
	public static Connection conn = null;
	public static String url = "jdbc:ucanaccess://C:\\Users\\ebaby\\Desktop\\Assignments\\Naggaro\\Accounts\\accountsdb.accdb";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//if (conn == null) {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conn = DriverManager.getConnection(url);
		//}
		return conn;
	}
}