package com.instagram.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	
	private static Connection conn =null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
			if (conn!=null) {
				
				return conn;
			}
			
			else {
				
				String driver="oracle.jdbc.driver.OracleDriver";
				String url ="jdbc:oracle:thin:@localhost:1521:orcl";
				String password= "hr";
				String username= "hr";
				
				Class.forName(driver);
				conn=DriverManager.getConnection(url,username,password);
				
				
			}
		
		
		
		return conn;
	}
}
