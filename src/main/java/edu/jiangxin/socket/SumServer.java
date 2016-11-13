package edu.jiangxin.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class SumServer {
	private ByteBuffer byteBuffer = ByteBuffer.allocate(8);
	private IntBuffer intBuffer = byteBuffer.asIntBuffer();
	private SocketChannel socketChannel = null;
	private ServerSocketChannel serverSocketChannel = null;

	public void start() {
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(10001));
			serverSocketChannel.configureBlocking(false);
			System.out.println("服务器通道已经打开");
			Selector acceptSelector = SelectorProvider.provider().openSelector();
			/*
			 * 在服务器套接字上注册selector并设置为接受accept方法的通知。
			 * 这就告诉Selector，套接字想要在accept操作发生时被放在ready表 上，因此，允许多元非阻塞I/O发生。
			 */
			serverSocketChannel.register(acceptSelector, SelectionKey.OP_ACCEPT);
			/* select方法在任何上面注册了的操作发生时返回 */
			while (acceptSelector.select() > 0) {
				// 某客户已经准备好可以进行I/O操作了，获取其ready键集合
				Set<SelectionKey> readyKeys = acceptSelector.selectedKeys();
				Iterator<SelectionKey> iterator = readyKeys.iterator();
				// 遍历ready键集合，并处理加法请求
				while (iterator.hasNext()) {
					SelectionKey sk = (SelectionKey) iterator.next();
					iterator.remove();
					if (sk.isAcceptable()) {
						ServerSocketChannel nextReady = (ServerSocketChannel) sk.channel();
						// 接受加法请求并处理它
						socketChannel = nextReady.accept();
						byteBuffer.clear();
						socketChannel.read(byteBuffer);
						int result = intBuffer.get(0) + intBuffer.get(1);
						byteBuffer.flip();
						byteBuffer.clear();
						intBuffer.put(0, result);
						socketChannel.write(byteBuffer);
					}
				}
			}
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

	public static void main(String[] args) {
		new SumServer().start();
	}
}
