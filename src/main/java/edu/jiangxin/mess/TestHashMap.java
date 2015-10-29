package edu.jiangxin.mess;
import java.util.HashMap;
import java.util.Map;


public class TestHashMap {
	public static void main(String[] args) {
		Map<Long,Long> map = new HashMap<Long, Long>();
		for(long i=0;i<Integer.MAX_VALUE+2;i++) {
			map.put(i, 0l);
		}
	}

}
