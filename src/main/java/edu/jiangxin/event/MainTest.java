package edu.jiangxin.event;

public class MainTest {

	/**
	 * java事件机制包括三个部分：事件、事件监听器、事件源。
	 * @param args
	 */
	public static void main(String[] args) {
		EventSourceObject object = new EventSourceObject();
		//注册监听器
		object.addCusListener(new CusEventListener());
		//触发事件
		object.setName("jiangxin");
	}
}
