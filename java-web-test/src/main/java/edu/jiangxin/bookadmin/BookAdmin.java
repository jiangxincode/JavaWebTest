package edu.jiangxin.bookadmin;

import edu.jiangxin.utils.PropertyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class BookAdmin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		String act = req.getParameter("act");
		if("createForm".equals(act)) {
			createForm(req,resp);
		} else if("editForm".equals(act)) {
			editForm(req,resp);
		} else if("save".equals(act)) {
			save(req,resp);
			search(req,resp);
		} else if("delete".equals(act)) {
			delete(req,resp);
			search(req,resp);
		} else {
			search(req,resp);
		}
	}
	
	void search(HttpServletRequest req, HttpServletResponse resp) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		String bookName = req.getParameter("q_bookName");
		String author = req.getParameter("q_author");
		String sql = "select * from book where 1=1";
		if((bookName != null) && (!"".equals(bookName))) {
			sql += " and bookName like '%"+bookName+"%'";
		}
		if((author != null) && (!"".equals(author))) {
			sql += " and author like '%"+author+"%'";
		}
		
		try {
			conn = getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			while(rs.next()) {
				Map<String,Object> map = rsToMap(rs);
				list.add(map);
			}
			req.setAttribute("books", list);
			req.getRequestDispatcher("JSP/BookAdmin/book_list.jsp").forward(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	void createForm(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("JSP/BookAdmin/book_edit_form.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void save(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		if((id != null) && (!"".equals(id))) {
			update(req,resp);
		} else {
			insert(req,resp);
		}
	}

	void delete(HttpServletRequest req, HttpServletResponse resp) {
		Connection conn = null;
		Statement stat = null;
		long id = Long.parseLong(req.getParameter("id"));
		try {
			conn = getConnection();
			stat = conn.createStatement();
			stat.executeUpdate("delete from book where id="+id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	void editForm(HttpServletRequest req, HttpServletResponse resp) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		long id = Long.parseLong(req.getParameter("id"));
		try {
			conn = getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from book where id="+id);
			rs.next();
			Map<String,Object> map = rsToMap(rs); //why
			req.setAttribute("book", map);
			req.getRequestDispatcher("JSP/BookAdmin/book_edit_form.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	void insert(HttpServletRequest req, HttpServletResponse resp) {
		Connection conn = null;
		PreparedStatement stat = null;
		
		String bookName = req.getParameter("bookName");
		String author = req.getParameter("author");
		Float price = null;
		if((req.getParameter("price") != null) && (!"".equals(req.getParameter("price")))) {
			price = Float.parseFloat(req.getParameter("price"));
		}
		Date publicationDate = null;
		if((req.getParameter("publicationDate") != null) && (!"".equals(req.getAttribute("publicationDate")))) {
			try {
				publicationDate = sdf.parse(req.getParameter("publicationDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			conn = getConnection();
			String sql = "insert into book (bookName,author,price,publicationDate) values (?, ?, ?, ?)";
			stat = conn.prepareStatement(sql);
			int i = 1;
			stat.setString(i++, bookName);
			stat.setString(i++,author);
			stat.setObject(i++, price);
			java.sql.Date sqlDate = null;
			if(publicationDate != null) {
				sqlDate = new java.sql.Date(publicationDate.getTime());
			}
			stat.setDate(i++, sqlDate);
			stat.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	void update(HttpServletRequest req, HttpServletResponse resp) {
		Connection conn = null;
		PreparedStatement stat = null;
		
		Long id = Long.parseLong(req.getParameter("id"));
		String bookName = req.getParameter("bookName");
		String author = req.getParameter("author");
		Float price = null;
		if((req.getParameter("price") != null) && (!"".equals(req.getParameter("price")))) {
			price = Float.parseFloat(req.getParameter("price"));
		}
		Date publicationDate = null;
		if((req.getParameter("publicationDate") != null) && (!"".equals(req.getParameter("publicationDate")))) {
			try {
				publicationDate = sdf.parse(req.getParameter("publicationDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			conn = getConnection();
			String sql = "update book set bookName=?,author=?,price=?,publicationDate=? where id=?";
			stat = conn.prepareStatement(sql);
			int i = 1;
			
			stat.setString(i++, bookName);
			stat.setString(i++, author);
			stat.setObject(i++, price);
			java.sql.Date sqlDate = null;
			if(publicationDate != null) {
				sqlDate = new java.sql.Date(publicationDate.getTime());
			}
			stat.setDate(i++, sqlDate);
			stat.setLong(i++, id);
			stat.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = PropertyUtils.getProperty("jdbc.driver");
		String url = PropertyUtils.getProperty("jdbc.url");
		String username = PropertyUtils.getProperty("jdbc.username");
		String password = PropertyUtils.getProperty("jdbc.password");
		
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
		
	}
	
	Map<String,Object> rsToMap(ResultSet rs) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", rs.getLong("id"));
		map.put("bookName", rs.getString("bookName"));
		map.put("author", rs.getString("author"));
		map.put("price", rs.getString("price"));
		map.put("publicationDate", rs.getDate("publicationDate"));
		return map;
		
	}
}
