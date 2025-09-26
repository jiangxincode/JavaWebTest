package edu.jiangxin.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	public static void main(String[] args) throws IOException {
		String inputFilePath = FileChannelTest.class.getResource("asm4-guide.pdf").getPath();
		String outputFilePath = FileChannelTest.class.getResource("").getPath() + "asm4-guide.bak.pdf";

		FileInputStream fileInputStream = new FileInputStream(inputFilePath);
		FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);

		FileChannel inFileChannel = fileInputStream.getChannel();
		FileChannel outFileChannel = fileOutputStream.getChannel();

		//ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024); //Direct Buffer的效率会更高。
		long start = System.currentTimeMillis();
		while (true) {
			int eof = inFileChannel.read(byteBuffer);
			if (eof == -1)
				break;
			byteBuffer.flip();
			outFileChannel.write(byteBuffer);
			byteBuffer.clear();
		}
		System.out.println("spending : " + (System.currentTimeMillis() - start));
		inFileChannel.close();
		outFileChannel.close();

		fileInputStream.close();
		fileOutputStream.close();
	}
}