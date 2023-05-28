package edu.jiangxin.nio.socket;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.io.IOException;

public class NIOSocketClient {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(8);
		IntBuffer intBuffer = buffer.asIntBuffer();
		SocketChannel channel = null;
		int result = 0;
		try {
			InetSocketAddress socketAddress = new InetSocketAddress("localhost", 10001);
			channel = SocketChannel.open(socketAddress);
			buffer.clear();
			intBuffer.put(0, 12);
			intBuffer.put(1, 23);
			channel.write(buffer);
			System.out.println("发送加法请求");

			buffer.clear();
			channel.read(buffer);
			result = intBuffer.get(0);
		} catch (IOException e) {
			System.err.println(e.toString());
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
				}
			}
		}

		System.out.println("加法结果 :" + result);

	}

}
