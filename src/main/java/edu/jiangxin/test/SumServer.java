package edu.jiangxin.test;
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
	private ByteBuffer buffer = ByteBuffer.allocate(8);// 鏂扮紦鍐插尯鐨勫閲忥紝浠ュ瓧鑺備负鍗曚綅
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
		serverChannel = ServerSocketChannel.open(); // 鍒涘缓Socket杩炴帴
		serverChannel.socket().bind(new InetSocketAddress(10000)); // 寮?鍚鍙?
		serverChannel.configureBlocking(false); // 璁剧疆鎴愪负闈為樆濉炴ā寮?
		System.out.println("鏈嶅姟鍣ㄩ?氶亾宸茬粡鎵撳紑");
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private void waitForConnection() throws IOException {
		// 鍦ㄦ湇鍔″櫒濂楁帴瀛椾笂娉ㄥ唽selector骞惰缃负鎺ュ彈accept鏂规硶鐨勯?氱煡銆傝繖灏卞憡璇塖elector锛屽鎺ュ瓧鎯宠鍦╝ccept鎿嶄綔鍙戠敓鏃惰鏀惧湪ready琛? 涓婏紝鍥犳锛屽厑璁稿鍏冮潪闃诲I/O鍙戠敓銆?
		// Selector selector = Selector.open(); //杩欐槸鏈?绠?鍗曠殑鍒涘缓鏂规硶
		Selector acceptSelector = SelectorProvider.provider().openSelector();
		// 姣忎釜瑕佷负瀹㈡埛鏈鸿姹傛彁渚涙湇鍔＄殑 Channel 閮藉繀椤绘帴鐫?椤哄簭灏嗚嚜宸卞悜Selector 娉ㄥ唽銆?
		// Channel搴旀牴鎹畠灏嗗鐞嗙殑浜嬩欢杩涜娉ㄥ唽銆備緥濡傦紝鎺ュ彈浼犲叆杩炴帴鐨? Channel搴旇繖鏍锋敞鍐?
		// Channel 鍚? Selector 鐨勬敞鍐岀敤 SelectionKey 瀵硅薄琛ㄧず銆傛弧瓒充互涓嬩笁涓潯浠朵箣涓?锛? Key 灏卞け鏁堬細
		// Channel琚叧闂?係elector 琚叧闂?傞?氳繃璋冪敤 Key鐨? cancel() 鏂规硶灏? Key 鏈韩鍙栨秷銆?
		// 濡傛灉鍏抽敭瀛楁槸鍙帴鍙楋紙acceptable锛夌殑锛屽垯鎺ュ彈杩炴帴锛屾敞鍐岄?氶亾锛屼互鎺ュ彈鏇村鐨勪簨浠讹紙渚嬪锛氳鎴栧啓鎿嶄綔锛夈??
		// 濡傛灉鍏抽敭瀛楁槸鍙鐨勶紙readable锛夋垨鍙啓鐨勶紙writable锛夛紝鍒欐湇鍔″櫒浼氭寚绀哄畠宸茬粡灏辩华浜庤鍐欐湰绔暟鎹?

		SelectionKey acceptKey = serverChannel.register(acceptSelector,
				SelectionKey.OP_ACCEPT);
		int keysAdded;
		// Server 鏄偅涓皢鑷繁鍚? Selector 娉ㄥ唽浠ユ帴鍙楁墍鏈変紶鍏ヨ繛鎺ョ殑 ServerSocketChannel Server
		// 琚敞鍐屽悗锛屾垜浠牴鎹瘡涓叧閿瓧锛坘ey锛夌殑绫诲瀷浠ヨ凯浠ｆ柟寮忓涓?缁勫叧閿瓧杩涜澶勭悊銆備竴涓叧閿瓧琚鐞嗗畬鎴愬悗锛?
		// 灏遍兘琚粠灏辩华鍏抽敭瀛楋紙readykeys锛夊垪琛ㄤ腑闄ゅ幓锛屽涓嬫墍绀?
		// select鏂规硶鍦ㄤ换浣曚笂闈㈡敞鍐屼簡鐨勬搷浣滃彂鐢熸椂杩斿洖
		// Selector 鍦? select()璋冪敤鏃堕樆濉炪?傛帴鐫?锛屽畠寮?濮嬬瓑寰咃紝鐩村埌寤虹珛浜嗕竴涓柊鐨勮繛鎺ワ紝鎴栬?呭彟涓?涓嚎绋嬪皢瀹冨敜閱掞紝
		// 鎴栬?呭彟涓?涓嚎绋嬪皢鍘熸潵鐨勯樆濉炵嚎绋嬩腑鏂?傛煇瀹㈡埛宸茬粡鍑嗗濂藉彲浠ヨ繘琛孖/O鎿嶄綔浜嗭紝鑾峰彇鍏秗eady閿泦鍚?
		while ((keysAdded = acceptSelector.select()) > 0) {
			Set readyKeys = acceptSelector.selectedKeys();
			Iterator i = readyKeys.iterator();
			// 閬嶅巻ready閿泦鍚堬紝骞跺鐞嗗姞娉曡姹?
			while (i.hasNext()) {
				SelectionKey selectionkey = (SelectionKey) i.next();
				i.remove();
				ServerSocketChannel nextReady = (ServerSocketChannel) selectionkey
						.channel();
				// 鎺ュ彈鍔犳硶璇锋眰骞跺鐞嗗畠
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
