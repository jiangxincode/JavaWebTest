package com.shengsiyuan.lesson111.network;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(4000);

		while (true) {
			Socket socket = serverSocket.accept();

			// 启动读写线程
			new ServerInputThread(socket).start();
			new ServerOutputThread(socket).start();
		}
	}
}
