package com.emp.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

public class AbsDao {
	static {
		ResourceBundle rb = ResourceBundle.getBundle("Empl");
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public java.sql.Connection getConn() throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("Empl");
		String url = rb.getString("url");
		String uname = rb.getString("uname");
		String pwd = rb.getString("pwd");
		java.sql.Connection conn = DriverManager.getConnection(url, uname, pwd);

		return conn;

	}

	public void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
