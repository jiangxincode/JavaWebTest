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
 * �������50�����֣���������ÿ�����ֵķ�Χ��[10,
 * 50]��ͳ��ÿ�����ֳ��ֵĴ����Լ����ִ����������������ĸ��������ÿ�����ּ�����ִ�����ӡ���������ĳ�����ֳ��ִ���Ϊ0
 * ����Ҫ��ӡ������ӡʱ�������ֵ���������
 * 
 * @author zhanglong
 * 
 */
public class RandomTest {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); // �洢���ּ�����ֵĴ�����keyΪ���֣�valueΪ���ֳ��ֵĴ�����

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

		List<Integer> list = new ArrayList<Integer>(); // �洢���ִ�����������

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

		System.out.println("���ֵ�������Ϊ��" + maxOccurs);

		System.out.println("��Щ���ֱַ��ǣ�");

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

	}
}
