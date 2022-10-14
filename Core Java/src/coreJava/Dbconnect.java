package coreJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dbconnect {

	public static Connection dbConnection()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver Found");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/aegisisc","root","root");
			
			
			Statement stmt = connection.createStatement();
	       {		      
	          String sql = "CREATE TABLE Student " +
	                   "(rollNo INTEGER not NULL, " +
	                   " name VARCHAR(255), " + 
	                   " contactNo VARCHAR(255), " + 
	                   " city VARCHAR(255), " + 
	                   " email VARCHAR(255), " + 
	                   " standard VARCHAR(255), " + 
	                   " PRIMARY KEY ( rollNo ))"; 

	         stmt.executeUpdate(sql);
//	         System.out.println("Created table in given database...");
	       }
			
		}
		catch (Exception e) {
//			System.out.println(e);
		}
		return connection;
	}
	
}

