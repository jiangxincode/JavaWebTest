//ArrayList遍历的4种方法 

package edu.jiangxin.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String args[]) {

		List<String> list = new ArrayList<String>();
		list.add("luojiahui");
		list.add("luojiafeng");

		// 方法1
		Iterator<String> it1 = list.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		// 方法2 怪异！
		for (Iterator<String> it2 = list.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
		}

		// 方法3
		for (String tmp : list) {
			System.out.println(tmp);
		}

		// 方法4
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
