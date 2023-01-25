package com.simpli.customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

@WebServlet("/DBConnectUser")
public class DBConnectUser {

	public static Connection getConnection() throws SQLException {

		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/flyawaydb";
		String user="root";
		String pwd="mysql";


		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return con;
	}

}