/**
 * 当文件所在目录不存在时创建父目录
 * @author jiangxin
 */
package edu.jiangxin.mess;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateDir {
	public static void main(String[] argv) {

		try {
			File file = new File("test/test.txt");// 创建多级目录文件
			// mkdir()创建单级目录
			// mkdirs()创建多级目录
			file.getParentFile().mkdirs();
			//file.createNewFile();
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write("--test--");
			output.close();
			System.out.println("文件创建成功");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
