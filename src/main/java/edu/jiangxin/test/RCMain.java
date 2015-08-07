package edu.jiangxin.test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * @author Administrator
 *
 */
public class RCMain {

/*	static final String encoding = "UTF-8";
	static final String type = "UTF-8";

	public static void main(String args[]) throws IOException {

		String sUrl = "E:/temp/java/Test/src"; // 婧愭枃浠跺す
		String tUrl = "E:/temp/java/Test/srctemp"; // 鐩爣鏂囦欢澶?
		(new File(tUrl)).mkdirs(); // 鍒涘缓鐩爣鏂囦欢澶?
		File[] file = (new File(sUrl)).listFiles(); // 鑾峰彇婧愭枃浠跺す褰撳墠涓嬬殑鏂囦欢鎴栫洰褰?
		for (int i = 0; i < file.length; i++) {

			if (file[i].isFile()) {
				// 澶嶅埗鏂囦欢
				
				String type = file[i].getName().substring(file[i].getName().lastIndexOf(".") + 1);
				System.out.println(type);

				if (type.equalsIgnoreCase("java")) {
					copyJavaFile(file[i], tUrl + File.separator + file[i].getName(), encoding);
				} else {
					copyOtherFile(file[i], new File(tUrl + file[i].getName()));
					System.out.println("here");
				}

			}

			if (file[i].isDirectory()) {
				// 澶嶅埗鐩綍
				String sourceDir = sUrl + File.separator + file[i].getName();
				String targetDir = tUrl + File.separator + file[i].getName();
				copyDirectiory(sourceDir, targetDir);
			}
		}
	}

	*//**
	 * 澶嶅埗闈瀓ava鏂囦欢
	 * 
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException
	 *//*
	public static void copyOtherFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 鏂板缓鏂囦欢杈撳叆娴佸苟瀵瑰畠杩涜缂撳啿
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 鏂板缓鏂囦欢杈撳嚭娴佸苟瀵瑰畠杩涜缂撳啿
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缂撳啿鏁扮粍
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 鍒锋柊姝ょ紦鍐茬殑杈撳嚭娴?
			outBuff.flush();
		} finally {
			// 鍏抽棴娴?
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	// 澶嶅埗鏂囦欢澶?
	public static void copyDirectiory(String sourceDir, String targetDir)
			throws IOException {
		// 鏂板缓鐩爣鐩綍
		(new File(targetDir)).mkdirs();
		// 鑾峰彇婧愭枃浠跺す褰撳墠涓嬬殑鏂囦欢鎴栫洰褰?
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 婧愭枃浠?
				File sourceFile = file[i];

				// 澶嶅埗鏂囦欢
				String type = file[i].getName().substring(
						file[i].getName().lastIndexOf(".") + 1);

				if (type.equalsIgnoreCase(type)) {

					copyJavaFile(sourceFile,
							new File(targetDir).getAbsolutePath()
									+ File.separator + file[i].getName(),
							encoding);

				}

				else {
					copyOtherFile(file[i],
							new File(new File(targetDir).getAbsolutePath()
									+ File.separator + file[i].getName()));
				}

			}
			if (file[i].isDirectory()) {
				// 鍑嗗澶嶅埗鐨勬簮鏂囦欢澶?
				String dir1 = sourceDir + "/" + file[i].getName();
				// 鍑嗗澶嶅埗鐨勭洰鏍囨枃浠跺す
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}*/

	/**
	 * 瀛楃涓插啓鍏ユ枃浠?
	 * 
	 * @param content
	 * @param fileName
	 */
/*	private static void saveAsFileWriter(String content, String fileName) {

		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(fileName);
			fwriter.write(content);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fwriter.flush();
				fwriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}*/

	/**
	 * 淇濆瓨java鏂囦欢
	 * 
	 * @param srcFileName
	 * @param destFileName
	 * @param srcCoding
	 * @throws IOException
	 */
/*	public static void copyJavaFile(File srcFileName, String destFileName,String srcCoding) throws IOException {
		BufferedReader br = null;
		BufferedWriter bw = null;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					srcFileName), srcCoding));
			RemoveComments c = new RemoveComments();
			String text = c.remove(br);
			saveAsFileWriter(text, destFileName);


			if (br != null)
				br.close();

	}*/
	public static void removeJavaFileComment(String srcFileString,String desFileString,String encoding) throws IOException {
		//File srcFileFile = new File(srcFileString);
		File desFileFile = new File(desFileString);
		//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileFile), encoding));
		//String tempString = RemoveComments.remove(reader);
		FileWriter writer = new FileWriter(desFileFile);
		//writer.write(tempString);
		writer.close();
	}
	public static void removeJavaFileComment(String fileString,String encoding) throws IOException {
		removeJavaFileComment(fileString,fileString,encoding);
		
	}
	public static void removeJavaFilesComment(ArrayList<File> files,String encoding) throws IOException {
		Iterator<File> it = files.iterator();
		while(it.hasNext()) {
			removeJavaFileComment(it.next().getAbsolutePath(), encoding);
		}
	}

}