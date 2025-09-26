package edu.jiangxin.nio.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket通信的服务端，实现大小写转化
 */
public class IOSocketServer {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(Constant.PORT);
		for (int i = 0; i < Constant.CLIENT_COUNT; i++) {
			// 接收客户端的请求
			Socket socket = serverSocket.accept();
			Thread serverThread = new IOServerThread(socket);
			serverThread.start();
		}
		serverSocket.close();
		while (true) {
			// 等待所有线程结束
		}
	}

}

class IOServerThread extends Thread {

	private Socket socket;

	public IOServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		InputStream inputStream;
		OutputStream outputStream;
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = inputStream.read(buffer);
			while (len > 0) {
				String str = new String(buffer, 0, len, "UTF-8");
				outputStream.write(str.toUpperCase().getBytes("UTF-8"));
				len = inputStream.read(buffer);
			}
			outputStream.close();
			inputStream.close();
			socket.close();
			System.out.println("success: " + this.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
