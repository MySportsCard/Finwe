package com.sports.arena.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testdb {
	
	 private static Connection connect = null;
	 private static Statement statement = null;
	 private static ResultSet resultSet = null;

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/mysportscard?"
		              + "user=root&password=password");
		
		statement = connect.createStatement();
		
		resultSet = statement
		          .executeQuery("select * from user_data");
		     
		while (resultSet.next()) {
		System.out.println(resultSet.getString("user_name"));
		}

	}

}
