package com.shengsiyuan.junit3;

public class Largest {
	public int getLargest(int[] array) throws Exception {
		if (null == array || 0 == array.length) {
			throw new Exception("���鲻��Ϊ�գ�");
		}

		int result = array[0];

		for (int i = 0; i < array.length; i++) {
			if (result < array[i]) {
				result = array[i];
			}
		}

		return result;
	}
}
