package edu.jiangxin.db.oracle;

import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobUtils {

	/*
	--建表语句如下：
	create table t_clob(id varchar2(32) primary key,clobfield CLOB);
	 */

	/**
	 * 读取CLOB字段的代码示例
	 */
	@SuppressWarnings("deprecation")
	public void readClob() {
		//自定义的数据库连接管理类　
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:Oracle", "epet", "epet");
			PreparedStatement stat = conn.prepareStatement("select clobfield from t_clob where id='1'");
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("clobfield");
				String value = clob.getSubString(1, (int) clob.length());
				System.out.println("CLOB字段的值：" + value);
			}
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写入、更新CLOB字段的代码示例
	 */
	@SuppressWarnings("deprecation")
	public void writeClob() {
		//自定义的数据库连接管理类　
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:Oracle", "epet", "epet");
			conn.setAutoCommit(false);
			// 1.这种方法写入CLOB字段可以。
			PreparedStatement stat = conn.prepareStatement("insert into t_clob (id,clobfield) values(sys_guid(),?)");
			String clobContent = "This is a very very long string";
			StringReader reader = new StringReader(clobContent);
			stat.setCharacterStream(1, reader, clobContent.length());
			stat.executeUpdate();

			// 2.使用类似的方法进行更新CLOB字段，则不能成功　
			// stat.close();
			// stat =null;
			// stat =
			// conn.prepareStatement("update t_clob set clobfield=? where id=1");
			// stat.setCharacterStream(1, reader, clobContent.length());
			// stat.executeUpdate();

			// 3.需要使用for update方法来进行更新，
			// 但是，特别需要注意，如果原来CLOB字段有值，需要使用empty_clob()将其清空。
			// 如果原来是null，也不能更新，必须是empty_clob()返回的结果。
			stat = conn.prepareStatement("select clobfield from t_clob where id='1' for update");
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob("clobfield");
				Writer outStream = clob.getCharacterOutputStream();
				char[] c = clobContent.toCharArray();
				outStream.write(c, 0, c.length);
				outStream.flush();
				outStream.close();
			}
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
