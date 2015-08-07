/**
 * 快速生成随机文本
 * @author jiangxin
 * @data 2014-6-20
 */
package edu.jiangxin.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedReader {
	public static void main(String[] args) {
		String s = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"temp/test.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"temp/output.txt"));
			while ((s = reader.readLine()) != null) {
				writer.write(s);
				writer.newLine(); // 调用newLine()方法，以系统默认的换行符填充，比直接利用'\n'要好。
			}
			writer.close();
			reader.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException e) {
		}
	}
}