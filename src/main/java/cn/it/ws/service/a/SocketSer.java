package cn.it.ws.service.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket通信的服务端，实现大小写转化
 *
 * @author 李俊 2015年5月16日
 */
public class SocketSer {

	//http://127.0.0.1:6666/asdfdsf
	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(6666);
		boolean flag = true;
		while (flag) {
			// 接收客户端的请求
			System.out.println("监听客户端的数据:");
			Socket sc = ss.accept();
			InputStream is = sc.getInputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			len = is.read(buffer);
			String getData = new String(buffer, 0, len);
			System.out.println("从客户端获取的数据:" + getData);
			// 业务处理 大小写转化
			String outPutData = getData.toUpperCase();

			// 向客户端写数据
			OutputStream os = sc.getOutputStream();
			os.write(outPutData.getBytes("UTF-8"));

			// 释放资源
			os.close();
			is.close();
			sc.close();
		}

		ss.close();

	}

}
