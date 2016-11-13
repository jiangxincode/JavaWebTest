package edu.jiangxin.socket;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;
import java.io.IOException;

public class SumClient {
	private ByteBuffer buffer = ByteBuffer.allocate(8);
	private IntBuffer intBuffer;
	private SocketChannel channel;

	public SumClient() {
		intBuffer = buffer.asIntBuffer();
	}

	public int getSum(int first, int second) {
		int result = 0;
		try {
			InetSocketAddress socketAddress = new InetSocketAddress("localhost", 10001);
			channel = SocketChannel.open(socketAddress);
			buffer.clear();
			intBuffer.put(0, first);
			intBuffer.put(1, second);
			channel.write(buffer);
			System.out.println("发送加法请求" + first + "+" + second);

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
		return result;
	}

	public static void main(String[] args) {
		SumClient sumClient = new SumClient();
		System.out.println("加法结果 :" + sumClient.getSum(100, 324));

	}

}
