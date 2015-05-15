package com.shengsiyuan.lesson050;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * 随机生成50个数字（整数），每个数字的范围是[10,
 * 50]，统计每个数字出现的次数以及出现次数最多的数字与它的个数，最后将每个数字及其出现次数打印出来，如果某个数字出现次数为0
 * ，则不要打印它。打印时按照数字的升序排列
 * 
 * @author zhanglong
 * 
 */
public class RandomTest {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); // 存储数字及其出现的次数（key为数字，value为数字出现的次数）

		Random random = new Random();

		for (int i = 0; i < 50; i++) {
			int number = random.nextInt(41) + 10;

			Integer in = new Integer(number);

			if (map.get(in) == null) {
				map.put(in, new Integer(1));
			} else {
				int value = ((Integer) map.get(in)).intValue();
				map.put(in, new Integer(value + 1));
			}
		}

		Collection<Integer> cols = map.values();

		Integer maxOccurs = (Integer) Collections.max(cols);

		Set<Entry<Integer, Integer>> set = map.entrySet();

		List<Integer> list = new ArrayList<Integer>(); // 存储出现次数最大的数字

		for (Iterator<Entry<Integer, Integer>> iter = set.iterator(); iter
				.hasNext();) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iter
					.next();

			Integer key = (Integer) entry.getKey();
			Integer value = (Integer) entry.getValue();

			if (value.intValue() == maxOccurs.intValue()) {
				list.add(key);
			}

			System.out.println(key + " : " + value);
		}

		System.out.println("出现的最多次数为：" + maxOccurs);

		System.out.println("这些数字分别是：");

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

	}
}
