package edu.jiangxin.test;
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
	} // SumClient constructor
	public int getSum(int first, int second) {
		int result = 0;
		try {
			channel = connect();
			sendSumRequest(first, second);
			result = receiveResponse();
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

	private SocketChannel connect() throws IOException {
		InetSocketAddress socketAddress = new InetSocketAddress("localhost",
		10000);
		return SocketChannel.open(socketAddress);
	}

	private void sendSumRequest(int first, int second) throws IOException {
		buffer.clear();
		intBuffer.put(0, first);
		intBuffer.put(1, second);
		channel.write(buffer);
		System.out.println("发�?�加法请�? " + first + "+" + second);
	}

	private int receiveResponse() throws IOException {
		buffer.clear();
		channel.read(buffer);
		return intBuffer.get(0);
	}

	public static void main(String[] args) {
		SumClient sumClient = new SumClient();
		System.out.println("加法结果�? :" + sumClient.getSum(100, 324));

	}

} // SumClient
