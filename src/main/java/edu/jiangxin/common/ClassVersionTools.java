package edu.jiangxin.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class ClassVersionTools {
	private static final Logger LOGGER = Logger.getLogger(ClassVersionTools.class);

	public static void getClassVersion(String pathname) {
		if (pathname == null) {
			LOGGER.debug("filePath is null.");
			return;
		}
		File srcDirFile = new File(pathname);
		if (!srcDirFile.exists()) {
			LOGGER.warn("Can't find the target file or directory: " + srcDirFile.getAbsolutePath());
			return;
		}
		ArrayList<File> arrayList = new FileFilterWrapper().list(pathname, ".class");
		if (arrayList.isEmpty()) {
			LOGGER.warn("Can't find class file.");
			return;
		}
		Iterator<File> it = arrayList.iterator();
		while (it.hasNext()) {
			File classFile = it.next();

			byte[] bVersion = new byte[8];
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(classFile);
				fis.read(bVersion, 0, 8);
			} catch (IOException e) {
				LOGGER.error("Some io errors happened.");
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						LOGGER.error("Can't close the fis.");
						continue;
					}
				}
			}

			String majorVersion = String.valueOf((bVersion[6] << 8 & 0xff00) | bVersion[7]);
			String minorVersion = String.valueOf((bVersion[4] << 8 & 0xff00) | bVersion[5]);

			LOGGER.debug("majorVersion: " + majorVersion + "; minorVersion: " + minorVersion);

			LOGGER.info("The version of " + classFile.getAbsolutePath() + " is: " + majorVersion + "." + minorVersion);
		}
	}

	/**
	 *
	 * @param srcDirString
	 *            The directory of source
	 * @param desDirString
	 *            The directory of target
	 * @throws IOException
	 */
	public static void modifyClassVersion(String srcDirString, String desDirString, byte[] newVersion) {
		File srcDirFile = new File(srcDirString);
		if (!srcDirFile.exists()) {
			LOGGER.error("srcDirString isn't exist: " + srcDirFile.getAbsolutePath());
			return;
		}

		if (!srcDirFile.isDirectory()) {
			LOGGER.error("srcDirString isn't a directory: " + srcDirFile.getAbsolutePath());
			return;
		}

		if (newVersion == null || newVersion.length != 4) {
			LOGGER.error("The param is error: " + newVersion);
		}

		FileProcess.copyDirectory(srcDirString, desDirString);

		ArrayList<File> arrayList = new FileFilterWrapper().list(desDirString, ".class");
		Iterator<File> it = arrayList.iterator();
		while (it.hasNext()) {

			File file = it.next();

			byte[] content = new byte[1024 * 1024];
			int len = 0;

			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				len = fis.read(content);
			} catch (FileNotFoundException e) {
				LOGGER.error("Can't find the file: " + file.getName());
			} catch (IOException e) {
				LOGGER.error("Some io errors happened.");
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						LOGGER.error("Can't close the fis.");
						continue;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				content[i + 4] = newVersion[i];
			}

			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				fos.write(content, 0, len);
			} catch (FileNotFoundException e) {
				LOGGER.error("Can't find the file: " + file.getName());
			} catch (IOException e) {
				LOGGER.error("Some io errors happened.");
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						LOGGER.error("Can't close the fos.");
						continue;
					}
				}
			}

			LOGGER.info("Process file success." + file.getAbsolutePath());
		}
	}

}
