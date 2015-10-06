package com.test.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.test.bean.Users;

/**
 * @author user
 * 
 *         TODO ���������users����ص����ݿ���������з���
 */
public class UsersDB {
	private String resource = "users.properties";

	private Properties props = null;

	// �õ����ݿ�����
	private Connection getConnection() {
		try {
			props = new Properties();

			InputStream in = getClass().getResourceAsStream(resource);

			props.load(in);

			String drivers = props.getProperty("jdbc.drivers");
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			Class.forName(drivers);// �������ݿ�����

			return DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("�������ݿ��쳣���� : " + ex.getMessage());
		}
		return null;

	}

	// ����һ�ʼ�¼
	public void save(Users bean) {
		try {
			Connection con = this.getConnection();

			String sql = "insert into users(username,password,truename,birthday,registerdate,sex,interest,remark) values(?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bean.getUsername());
			ps.setString(2, bean.getPassword());
			ps.setString(3, bean.getTruename());
			ps.setDate(4, bean.getBirthday());
			ps.setDate(5, bean.getRegisterdate());
			ps.setString(6, bean.getSex());
			ps.setString(7, bean.getInterest());
			ps.setString(8, bean.getRemark());

			ps.executeUpdate(); // ������������ݿ����

			con.close();

		} catch (Exception ex) {
			System.out.println("���Ӽ�¼�쳣������" + ex.getMessage());

		}
	}

	// ����һ�ʼ�¼
	public void update(Users bean) {
		try {
			Connection con = this.getConnection();

			String sql = "update users set password=?,truename=?,birthday=?,sex=?,interest=?,remark=? where id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bean.getPassword());
			ps.setString(2, bean.getTruename());
			ps.setDate(3, bean.getBirthday());
			ps.setString(4, bean.getSex());
			ps.setString(5, bean.getInterest());
			ps.setString(6, bean.getRemark());
			ps.setInt(7, bean.getId());

			ps.executeUpdate();// ����������ݵĸ���

			con.close();
		} catch (Exception ex) {
			System.out.println("�޸ļ�¼�쳣������" + ex.getMessage());
		}
	}

	// ɾ��һ�ʼ�¼
	public void remove(int id) {
		try {
			Connection con = this.getConnection();

			String sql = "delete from users where id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ps.executeUpdate(); // ���������ɾ��

			con.close();
		} catch (Exception ex) {
			System.out.println("ɾ����¼�쳣������" + ex.getMessage());
		}
	}

	// ��ѯһ�ʼ�¼
	public Users restore(int id) {
		Users bean = null;
		try {
			Connection con = this.getConnection();
			String sql = "select * from users where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bean = new Users();
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setTruename(rs.getString("truename"));
				bean.setBirthday(rs.getDate("birthday"));
				bean.setRegisterdate(rs.getDate("registerdate"));
				bean.setSex(rs.getString("sex"));
				bean.setInterest(rs.getString("interest"));
				bean.setRemark(rs.getString("remark"));
			}

			con.close();
		} catch (Exception ex) {
			System.out.println("��ѯ��¼�쳣������" + ex.getMessage());
		}
		return bean;
	}

	// ��ѯ���м�¼
	public ArrayList<Object> getAllUsers() {
		ArrayList<Object> arrayList = new ArrayList<Object>();

		Users bean = null;

		try {
			Connection con = this.getConnection();
			String sql = "select * from users";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bean = new Users();

				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setTruename(rs.getString("truename"));
				bean.setBirthday(rs.getDate("birthday"));
				bean.setRegisterdate(rs.getDate("registerdate"));
				bean.setSex(rs.getString("sex"));
				bean.setInterest(rs.getString("interest"));
				bean.setRemark(rs.getString("remark"));

				arrayList.add(bean);
			}

			con.close();
		} catch (Exception ex) {
			System.out.println("��ѯ���м�¼�쳣������" + ex.getMessage());
		}
		return arrayList;
	}

}