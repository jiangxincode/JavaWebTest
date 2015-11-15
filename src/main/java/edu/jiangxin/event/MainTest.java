package edu.jiangxin.event;

public class MainTest {

	public static void main(String[] args) {
		EventSourceObject object = new EventSourceObject();
		//注册监听器
		object.addCusListener(new CusEventListener() {
			@Override
			public void fireCusEvent(CusEvent e) {
				super.fireCusEvent(e);
			}
		});
		//触发事件
		object.setName("jiangxin");
	}
}
