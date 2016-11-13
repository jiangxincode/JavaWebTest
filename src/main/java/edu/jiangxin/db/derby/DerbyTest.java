package edu.jiangxin.db.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");// from
																// derbyclient.jar
			String url = "jdbc:derby://localhost:1527/MyDbTest;create=true";// create=true必须写，MyDbTest任意名称
			try {
				conn = DriverManager.getConnection(url, "admin", "admin");// 用户名密码不能是1，1
				// System.out.println(conn.toString());
				String sql = "select * from myuser";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}