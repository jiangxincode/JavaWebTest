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

		String sUrl = "E:/temp/java/Test/src"; // 源文件夹
		String tUrl = "E:/temp/java/Test/srctemp"; // 目标文件夹
		(new File(tUrl)).mkdirs(); // 创建目标文件夹
		File[] file = (new File(sUrl)).listFiles(); // 获取源文件夹当前下的文件或目录
		for (int i = 0; i < file.length; i++) {

			if (file[i].isFile()) {
				// 复制文件
				
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
				// 复制目录
				String sourceDir = sUrl + File.separator + file[i].getName();
				String targetDir = tUrl + File.separator + file[i].getName();
				copyDirectiory(sourceDir, targetDir);
			}
		}
	}

	*//**
	 * 复制非java文件
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
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	// 复制文件夹
	public static void copyDirectiory(String sourceDir, String targetDir)
			throws IOException {
		// 新建目标目录
		(new File(targetDir)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];

				// 复制文件
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
				// 准备复制的源文件夹
				String dir1 = sourceDir + "/" + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}*/

	/**
	 * 字符串写入文件
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
	 * 保存java文件
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