package edu.jiangxin.sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Test {
	public static void main(String[] args) throws FindFailed, InterruptedException {
		Screen s = new Screen();
		//定义图片存放路径
		String imgpath = Test.class.getResource("").getPath();
		//双击桌面chrome浏览器图标
		s.doubleClick(imgpath + "chrome.png");
		Thread.sleep(5000);
		//输入url
		s.type("https://www.baidu.com/");
		//s.type(imgpath + "url.png", "www.bing.com");
		s.click(imgpath + "lianxiang.png");
		Thread.sleep(2000);
		//在bing输入框输入搜索关键字：sikuli,并点击搜索按钮
		s.type(imgpath + "sreach_input.jpg", "sikuli");
		s.click(imgpath + "sreach_button.png");

		System.out.println("end");
	}

}
