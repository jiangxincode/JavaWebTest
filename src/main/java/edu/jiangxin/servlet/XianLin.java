package edu.jiangxin.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class XianLin extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sql;
	private String var;

	public int doStartTag() throws JspException {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> m = rsToMap(rs);
				list.add(m);
			}
			HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
			req.setAttribute(var, list);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return super.doStartTag();
	}

	Connection getConnection() {
		try {
			String driveClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/JavaWebTest?useUnicode=true&characterEncoding=GBK";
			String user = "root";
			String password = "";
			Class.forName(driveClass).newInstance();
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private Map<String, Object> rsToMap(ResultSet rs) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();
			for (int i = 0; i < colCount; i++) {
				String colName = md.getColumnName(i + 1);
				map.put(colName, rs.getObject(colName));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return map;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
}
