package edu.jiangxin.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * a simple example of jdbc
 * see also create_table_worker.sql
 */
public class JDBCSample {
	public static void main(String[] args) {

		/*
		 * see http://stackoverflow.com/questions/5808160/what-is-the-jdbc-driver-org-gjt-mm-mysql-driver-for
		 * for the difference of "com.mysql.jdbc.Driver" and "org.gjt.mm.mysql.Driver"
		 */
		String DriverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost/test";
		String dbUser = "root";
		String dbPassword = "xxxxxx";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * get a instance of mysql driver
			 */
			Class.forName(DriverName).newInstance();
			conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			stmt = conn.createStatement();

			String updateSql = "insert into worker(name,gender,age) values('Tom','male',30)";
			stmt.executeUpdate(updateSql);

			String updateSql2 = "update worker set name='Rose',gender='female' where name='Tom'";
			stmt.executeUpdate(updateSql2);

			String sql = "select name,gender from worker";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// System.out.println(rs.getString(1));
				System.out.println(rs.getString("name"));
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
