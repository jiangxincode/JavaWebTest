package edu.jiangxin.crawler;
import java.util.HashSet;
import java.util.LinkedList;

public class Queue {
	private static HashSet<String> m_appear = new HashSet<String>();
	private static LinkedList<String> m_queue = new LinkedList<String>();
		
	public synchronized static void Add(String url) {
    	if( !m_appear.contains(url) ) {	//未保存过的URL
    		m_appear.add(url);
    		m_queue.addLast(url);
    	}
    }
	
	public synchronized static String Fetch() {
    	if( !m_queue.isEmpty() ) {
    		return m_queue.poll();
    	}
    	
    	return null;
    }
	
	public static int Size() {
		return m_queue.size();
	}
}
