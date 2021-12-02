package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class myConnection {
	public static Connection getConnection() {
	Connection con = null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "pdomagni","Jesus2020");
		return con;
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
}
