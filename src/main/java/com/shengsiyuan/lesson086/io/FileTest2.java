package com.shengsiyuan.lesson086.io;

import java.io.File;
import java.io.IOException;

public class FileTest2 {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		File file = new File("c:/abc");

		File file2 = new File("c:/abc", "xyz/hello.txt");

		file2.createNewFile();
	}
}
