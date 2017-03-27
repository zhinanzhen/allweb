package com.foundation.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
	private static Connection connection;
	private static String password ="";
	private static String userName = "root";
	private static String url = "jdbc:mysql://127.0.0.1/rjpk";
	private static String driver = "com.mysql.jdbc.Driver";
//	private static String driver = "Oracle.jdbc.driver.OracleDriver";
//	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:yuewei";
	private Connections(){
		
	}
	private static class InnerConn{
		public static Connection getConn(){
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
	public static Connection getConn(){
		if(connection == null){
			connection = InnerConn.getConn();
		}
		return connection;
	}
	private static void select(){
		Connection conn = getConn();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from account_2016");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float money = resultSet.getFloat(3);
				Date date = resultSet.getDate(4);
//				int id = resultSet.getInt("id");
//				String name = resultSet.getString("aname");
//				float money = resultSet.getFloat("money");
//				Date date = resultSet.getDate("tradeDate");
				System.out.println(id + ":" + name + ":" + money + ":" + date);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void insert(){
		Connection conn = getConn();
		try {
			conn.setAutoCommit(false);
			PreparedStatement prepareStatement = conn.prepareStatement("insert into account_2016 values(?,?,?,?)");
			prepareStatement.setInt(1, 6);
			prepareStatement.setString(2, "nn");
			prepareStatement.setFloat(3, 78.9f);
			prepareStatement.setDate(4, new java.sql.Date(0));
			prepareStatement.execute();
			
			PreparedStatement prepareStatement2 = conn.prepareStatement("update account_2016 set aname =? where id=?");
			prepareStatement2.setString(1, "mmm");
			prepareStatement2.setInt(2, 6);
			prepareStatement2.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		insert();
	}
}
