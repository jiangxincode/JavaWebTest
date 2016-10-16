package edu.jiangxin.webservice.mobilecodeservice;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;


public class InvokeMobileCodeServiceWithWsimportTool {
  /**
   * 通过wsimport生成本地代理 来访问 webservice服务端
   *
   */
	public static void main(String[] args) {
		//生成服务对象
		MobileCodeWS ws=new MobileCodeWS();
		//取得webservice服务的访问方式  ： Soap1.1  Soap 1.2  Http-get http-Post
		MobileCodeWSSoap mobileCodeWSSoap = ws.getMobileCodeWSSoap();
		/**
		 *  返回的数据有两种类型 ：
		 *  1. 简单的数据类型  。基本数据类型 ：整数、布尔、字符串 等
		 *  2. 复合的数据类型 ：结构体 ，数组 ，对象
		 */
		//1.简单的数据
		String result=mobileCodeWSSoap.getMobileCodeInfo("13660559129", "");
		System.out.println("返回的结果："+result);
		//2. 复合的数据  List<String> List<Student>
		ArrayOfString databaseInfo = mobileCodeWSSoap.getDatabaseInfo();
		List<String> results=databaseInfo.getStrings();
		//遍历集合
		for(String temp:results){
			System.out.println(temp);
		}
	}

}
