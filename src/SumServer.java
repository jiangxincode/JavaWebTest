import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;

public class SumServer {
	private ByteBuffer buffer = ByteBuffer.allocate(8);// 新缓冲区的容量，以字节为单位
	private IntBuffer intBuffer = buffer.asIntBuffer();
	private SocketChannel socketChannel = null;
	private ServerSocketChannel serverChannel = null;
	
	public void start() {
		try {
			openChannel();
			waitForConnection();
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

	private void openChannel() throws IOException {
		serverChannel = ServerSocketChannel.open(); // 创建Socket连接
		serverChannel.socket().bind(new InetSocketAddress(10000)); // 开启端口
		serverChannel.configureBlocking(false); // 设置成为非阻塞模式
		System.out.println("服务器通道已经打开");
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private void waitForConnection() throws IOException {
		// 在服务器套接字上注册selector并设置为接受accept方法的通知。这就告诉Selector，套接字想要在accept操作发生时被放在ready表 上，因此，允许多元非阻塞I/O发生。
		// Selector selector = Selector.open(); //这是最简单的创建方法
		Selector acceptSelector = SelectorProvider.provider().openSelector();
		// 每个要为客户机请求提供服务的 Channel 都必须接着顺序将自己向Selector 注册。
		// Channel应根据它将处理的事件进行注册。例如，接受传入连接的 Channel应这样注册
		// Channel 向 Selector 的注册用 SelectionKey 对象表示。满足以下三个条件之一， Key 就失效：
		// Channel被关闭。Selector 被关闭。通过调用 Key的 cancel() 方法将 Key 本身取消。
		// 如果关键字是可接受（acceptable）的，则接受连接，注册通道，以接受更多的事件（例如：读或写操作）。
		// 如果关键字是可读的（readable）或可写的（writable），则服务器会指示它已经就绪于读写本端数据

		SelectionKey acceptKey = serverChannel.register(acceptSelector,
				SelectionKey.OP_ACCEPT);
		int keysAdded;
		// Server 是那个将自己向 Selector 注册以接受所有传入连接的 ServerSocketChannel Server
		// 被注册后，我们根据每个关键字（key）的类型以迭代方式对一组关键字进行处理。一个关键字被处理完成后，
		// 就都被从就绪关键字（readykeys）列表中除去，如下所示
		// select方法在任何上面注册了的操作发生时返回
		// Selector 在 select()调用时阻塞。接着，它开始等待，直到建立了一个新的连接，或者另一个线程将它唤醒，
		// 或者另一个线程将原来的阻塞线程中断。某客户已经准备好可以进行I/O操作了，获取其ready键集合
		while ((keysAdded = acceptSelector.select()) > 0) {
			Set readyKeys = acceptSelector.selectedKeys();
			Iterator i = readyKeys.iterator();
			// 遍历ready键集合，并处理加法请求
			while (i.hasNext()) {
				SelectionKey selectionkey = (SelectionKey) i.next();
				i.remove();
				ServerSocketChannel nextReady = (ServerSocketChannel) selectionkey
						.channel();
				// 接受加法请求并处理它
				// socketChannel = nextReady.accept().socket();
				socketChannel = nextReady.accept();
				processRequest();
				socketChannel.close();
			}
		}
	}

	private void processRequest() throws IOException {
		buffer.clear();
		socketChannel.read(buffer);
		int result = intBuffer.get(0) + intBuffer.get(1);
		buffer.flip();
		buffer.clear();
		intBuffer.put(0, result);
		socketChannel.write(buffer);
	}

	public static void main(String[] args) {
		new SumServer().start();
	}
}
