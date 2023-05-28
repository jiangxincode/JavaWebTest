package edu.jiangxin.webservice.phoneservice.client;

import edu.jiangxin.webservice.phoneservice.Phone;
import edu.jiangxin.webservice.phoneservice.PhoneService;
import edu.jiangxin.webservice.phoneservice.PhoneService_Service;

public class InvokePhoneServiceWithWsimport {
	/**
	 * 测试自己发布的webservice
	 */
	public static void main(String[] args) {
		// 服务
		PhoneService_Service ws = new PhoneService_Service();
		// 访问方式
		PhoneService phoneServicePort = ws.getPhoneServicePort();
		Phone phoneInfo = phoneServicePort.getMobileInfo("android");

		System.out.println(phoneInfo.getName());
		System.out.println(phoneInfo.getOwner());
		System.out.println(phoneInfo.getTotal());

	}

}
