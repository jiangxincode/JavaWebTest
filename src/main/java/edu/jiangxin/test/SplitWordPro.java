package edu.jiangxin.test;
/*
 * 描述：用来进行�?�向�?大匹配分�?
 * 作�?�：蒋鑫
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class SplitWordPro {
	Vector<String> vecWord;

	public SplitWordPro(String wordtableFile) { // 初始化词�?
		String strFile = wordtableFile;
		this.vecWord = new Vector<String>();
		try {
			String line = null;
			BufferedReader rin = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(strFile)), "GB2312"));
			while ((line = rin.readLine()) != null) {
				vecWord.add(line);
			}
			rin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<String> getWord(String str) {
		Vector<String> vecSplitWord = new Vector<String>();
		String tmp = str;
		String tmpcontent = str;
		while (tmpcontent.length() > 0) {
			if (this.vecWord.contains(tmp)) {
				vecSplitWord.add(tmp);// 加入本词
				tmpcontent = tmpcontent.substring(0,
						tmpcontent.length() - tmp.length());// 删除找到的词
				tmp = tmpcontent;

			} else {
				if (tmp.length() > 1)
					;
				tmp = tmp.substring(1);
				if (tmp.length() == 1) {
					vecSplitWord.add(tmp);// 加入本单个字
					tmpcontent = tmpcontent.substring(0,
							tmpcontent.length() - 1);
					tmp = tmpcontent;
				}
			}
		}
		return vecSplitWord;
	}
}
