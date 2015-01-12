package com.yuqiaotech.helloj2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCMetaData。
 *
 */
public class JDBCMetaData {
	public static void main(String[] args) {

		// 如果是其他数据库，需要修改这里，并下载相应的JDBC驱动包。xampp php
		String DriverName = "org.gjt.mm.mysql.Driver";
		String dbURL = "jdbc:mysql://localhost/test";
		String dbuser = "root";
		String dbpassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 得到一个数据库连接
			// 反射
			// 相当于 new org.gjt.mm.mysql.Driver();
			Class.forName(DriverName).newInstance();
			conn = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			// 产生一个statement对象，该对象用来执行sql语句。
			stmt = conn.createStatement();

			// 获取所有的表
			System.out.println("打印test库的所有表名");
			ResultSet rsTables = conn.getMetaData().getTables(null, null, null,
					new String[] { "TABLE" });
			while (rsTables.next()) {
				System.out.println(rsTables.getString("TABLE_NAME"));
			}

			System.out.println("打印worker表的所有字段");
			ResultSet rsColumns = conn.getMetaData().getColumns(null, null,
					"worker", null);// "%"
			while (rsColumns.next()) {
				System.out.println(rsColumns.getString("COLUMN_NAME"));
			}

			// 查询数据
			String sql = "select name,gender from worker";
			// 查询结果是保存在一个ResultSet的对象里
			rs = stmt.executeQuery(sql);
			// 通过ResultSetMetaData可以获取结果集本身的一些信息，如字段等
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();

			// 对resultset调用next方法，可以讲数据指向第一条，
			// 调用类似getString之类的方法就可以获取该数据某个字段的值
			System.out.println("打印查询记录的列名和内容。");
			while (rs.next()) {
				for (int i = 0; i < colCount; i++) {
					String colName = md.getColumnName(i + 1);
					System.out.print(" " + colName + ":" + rs.getObject(i + 1));
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
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
/*
 * 可以下载xampp一次性安装mysql和mysql的一个管理工具phpmyadmin
 * 也可以单独下载mysql安装程序，mysql本身没有完善的界面化管理工具，你可以在网上自己找一个。 CREATE TABLE IF NOT EXISTS
 * worker ( id int NOT NULL auto_increment, name varchar(20) NOT NULL, gender
 * varchar(10) default NULL, age int(3) default NULL, PRIMARY KEY (`id`) )
 * DEFAULT CHARSET=gbk ;
 */