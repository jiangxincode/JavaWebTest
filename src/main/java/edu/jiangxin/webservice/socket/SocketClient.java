package edu.jiangxin.webservice.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) throws Exception {
		System.out.println("Input some data:");
		Scanner input = new Scanner(System.in);
		String inputData = input.nextLine();
		input.close();

		Socket sc = new Socket("127.0.0.1", 6666);
		OutputStream os = sc.getOutputStream();
		os.write(inputData.getBytes());

		// 获取服务端回传的数据
		InputStream is = sc.getInputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		len = is.read(buffer);
		String getData = new String(buffer, 0, len);
		System.out.println("The data received from server" + getData);

		os.close();
		sc.close();
		is.close();

	}

}
