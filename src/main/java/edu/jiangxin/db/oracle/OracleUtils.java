package edu.jiangxin.db.oracle;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import oracle.sql.BLOB;

public class OracleUtils {

	/**
	 * 将blob转化为byte[],只对纯文本的有效
	 *
	 * @param blob
	 * @return
	 */
	private byte[] getBytes(BLOB blob) {
		try {
			InputStream ins = blob.getBinaryStream();
			byte[] b = new byte[1024];
			int num = 0;
			String res = "";
			while ((num = ins.read(b)) != -1) {
				res += new String(b, 0, num);
			}
			return res.getBytes();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将blob转化为byte[],可以转化二进制流的
	 *
	 * @param blob
	 * @return
	 */
	private byte[] blobToBytes(BLOB blob) {
		InputStream is = null;
		byte[] b = null;
		try {
			is = blob.getBinaryStream();
			b = new byte[(int) blob.length()];
			is.read(b);
			return b;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				is = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

}
