package edu.jiangxin.nio.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import edu.jiangxin.random.RandomString;

public class IOSocketClient {

	public static void main(String[] args) {

		for (int i = 0; i < Constant.CLIENT_COUNT; i++) {
			Thread clientThread = new IOClientThread();
			clientThread.start();
		}

	}

}

class IOClientThread extends Thread {
	@Override
	public void run() {
		super.run();

		Socket socket;
		try {
			String data = RandomString.nextString(Constant.CHAR_LENGTH, "lowercase");
			System.out.println(data);
			socket = new Socket(Constant.IP, Constant.PORT);
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(data.getBytes());
			outputStream.close();
			
			byte[] buffer = new byte[1024];
			int len = inputStream.read(buffer);
			while (len > 0) {
				System.out.print(new String(buffer, 0, len));
				len = inputStream.read(buffer);
			}
			System.out.println();
			
			inputStream.close();

			socket.close();

			System.out.println("success: " + this.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
