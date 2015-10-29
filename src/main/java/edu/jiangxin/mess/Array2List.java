package edu.jiangxin.mess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Array和List相互转换
 *
 */
public class Array2List {
	
	public static void main(String[] args) {
		
		/**
		 * Array转List
		 */
		String[] strArray1 = {"aa","bb","cc"};
		
		List<String> list1 = new ArrayList<String>();
		Collections.addAll(list1, strArray1);
		
		list1 = Arrays.asList(strArray1); // 返回一个受指定数组支持的固定大小的列表,所以不能做add、remove等操作
		list1 = new ArrayList<String>(Arrays.asList(strArray1)); //这种方式可以进行add remove操作
		
		list1 = new ArrayList<String>(strArray1.length);
		for(String str: strArray1) {
			list1.add(str);
		}
		
		/**
		 * List转Array
		 */
		List<String> list2 = new ArrayList<String>();
		list2.add("aa");
		list2.add("bb");
		String[] strArray2 = (String[]) list2.toArray();
		
		//也可以指定大小：
		final int size = list2.size();
		strArray2 = (String[])list2.toArray(new String[size]);
		
		//笨方法
		list2 = new ArrayList<String>();
		list2.add("aa");
		list2.add("bb");
		strArray2 = new String[list2.size()];
		for(int i=0;i<list2.size();i++) {
			strArray2[i] = list2.get(i);
		}
	}

}
