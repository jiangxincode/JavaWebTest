package edu.jiangxin.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement
 */
public class JDBCPreparedStatement {

	public static void main(String[] args) {

		String DriverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost/test";
		String dbuser = "root";
		String dbpassword = "xxxxxx";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DriverName).newInstance();
			conn = DriverManager.getConnection(dbURL, dbuser, dbpassword);

			String updateSql = "insert into worker(name,gender,age) values(?,?,?)";

			pstmt = conn.prepareStatement(updateSql);
			pstmt.setString(1, "Tom");
			pstmt.setString(2, "male");
			pstmt.setInt(3, 20);
			pstmt.executeUpdate();

			String updateSql2 = "update worker set name='Rose',gender='female' where name='Tom'";
			int cnt = pstmt.executeUpdate(updateSql2);
			System.out.println("更新了" + cnt + "条。");

			String sql = "select name,age,gender from worker where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Rose");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print("name:" + rs.getString("name"));
				System.out.print(" age:" + rs.getInt("age"));
				System.out.println(" gender:" + rs.getString("gender"));
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
			if (pstmt != null) {
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