package com.cluster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver got connected");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","naveen","naveen");
		System.out.println("connection established");
		return connection;
		
	}

}
