package edu.jiangxin.webservice.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket通信的服务端，实现大小写转化
 */
public class SocketServer {

	// http://127.0.0.1:6666/asdfdsf
	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(6666);
		boolean flag = true;
		while (flag) {
			// 接收客户端的请求
			System.out.println("Listening data from the client:");
			Socket sc = ss.accept();
			InputStream is = sc.getInputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			len = is.read(buffer);
			String getData = new String(buffer, 0, len);
			System.out.println("The data received from client:" + getData);
			// 业务处理 大小写转化
			String outPutData = getData.toUpperCase();

			// 向客户端写数据
			OutputStream os = sc.getOutputStream();
			os.write(outPutData.getBytes("UTF-8"));

			// 释放资源
			os.close();
			sc.close();
			is.close();

		}

		ss.close();

	}

}
