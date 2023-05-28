package edu.jiangxin.webservice.languageservice.client;

import edu.jiangxin.webservice.languageservice.LanguageManager;
import edu.jiangxin.webservice.languageservice.LanguageService;

public class Test {
  /**测试有CXF框架发布的webservice服务
   *
   * @param args
   */
	public static void main(String[] args) {
		LanguageManager ws=new LanguageManager();
		LanguageService languageServicePort = ws.getLanguageServicePort();
		System.out.println(languageServicePort.getLanguage(1));
	}

}
