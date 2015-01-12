package com.yuqiaotech.helloj2ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement。
 *
 */
public class JDBCPreparedStatement {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// 如果是其他数据库，需要修改这里，并下载相应的JDBC驱动包。xampp php
		String DriverName = "org.gjt.mm.mysql.Driver";
		String dbURL = "jdbc:mysql://localhost/test";
		String dbuser = "root";
		String dbpassword = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 得到一个数据库连接
			// 反射
			// 相当于 new org.gjt.mm.mysql.Driver();
			Class.forName(DriverName).newInstance();
			conn = DriverManager.getConnection(dbURL, dbuser, dbpassword);

			// sql语句
			String updateSql = "insert into worker(name,gender,age) values(?,?,?)";
			// 产生一个statement对象，该对象用来执行sql语句。
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setString(1, "Tom");
			pstmt.setString(2, "male");
			pstmt.setInt(3, 20);
			pstmt.executeUpdate();

			// 对数据进行一些修改
			String updateSql2 = "update worker set name='Rose',gender='female' where name='Tom'";
			int cnt = pstmt.executeUpdate(updateSql2);
			System.out.println("更新了" + cnt + "条。");

			// 查询数据
			String sql = "select name,age,gender from worker where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Rose");
			// 查询结果是保存在一个ResultSet的对象里
			rs = pstmt.executeQuery();

			// 对resultset调用next方法，可以讲数据指向第一条，
			// 调用类似getString之类的方法就可以获取该数据某个字段的值
			System.out.println("打印查询记录的内容。");
			while (rs.next()) {
				System.out.print("name:" + rs.getString(1));
				System.out.print(" age:" + rs.getInt("age"));
				// System.out.print(" age:"+rs.getString("age"));
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
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
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