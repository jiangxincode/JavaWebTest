package edu.jiangxin.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMetaData {
	public static void main(String[] args) {

		String DriverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost/test";
		String dbuser = "root";
		String dbpassword = "xxxxxx";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			Class.forName(DriverName).newInstance();
			conn = DriverManager.getConnection(dbURL, dbuser, dbpassword);

			stmt = conn.createStatement();

			System.out.println("打印test库的所有表名");
			ResultSet rsTables = conn.getMetaData().getTables(null, null, null, new String[] { "TABLE" });
			while (rsTables.next()) {
				System.out.println(rsTables.getString("TABLE_NAME"));
			}

			System.out.println("打印worker表的所有字段");
			ResultSet rsColumns = conn.getMetaData().getColumns(null, null, "worker", null);// "%"
			while (rsColumns.next()) {
				System.out.println(rsColumns.getString("COLUMN_NAME"));
			}

			String sql = "select name,gender from worker";
			rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();

			System.out.println("打印查询记录的列名和内容。");
			while (rs.next()) {
				for (int i = 0; i < colCount; i++) {
					String colName = md.getColumnName(i + 1);
					System.out.print(colName + ":" + rs.getObject(i + 1));
				}
				System.out.println();
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