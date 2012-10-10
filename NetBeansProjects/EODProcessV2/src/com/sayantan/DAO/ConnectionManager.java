package com.sayantan.DAO;

import java.sql.*;




public class ConnectionManager {


	public  static Connection getConnection(){


		 try
		    {
		        Class.forName(m_DBDriver);
		    }
		    catch(ClassNotFoundException classnotfoundexception)
		    {
		    	System.out.println("ERROR - Exception occured while loading MYSql driver: "
		   			 + classnotfoundexception.toString());
		    }

		    try
		    {
		        SYB_con = DriverManager.getConnection(url, username, password);
		        System.out.println("Connection Successful!");
		    }
		    catch(SQLException exception)
		    {
		    	System.out.println("ERROR - Exception occured while getting connection: "
			 				+ exception.toString());
		    }
		    return SYB_con;
	}
	static Connection SYB_con;


	// Database connectivity
	static String m_DBDriver = "org.postgresql.Driver";  
	static String url = "jdbc:postgresql://localhost:5432/MarketData";  
	static String username = "postgres";
	static String password = "AQFTrading"; //sayantan
	//static String password = "aqf@123"; //dev

}
