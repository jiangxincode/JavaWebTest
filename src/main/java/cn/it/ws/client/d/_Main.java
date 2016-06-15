package cn.it.ws.client.d;

public class _Main {
   /**
    * 测试自己发布的webservice
    * @param args
    */
	public static void main(String[] args) {
		//服务
		PhoneServiceService ws=new PhoneServiceService();
		//访问方式 
		PhoneService phoneServicePort = ws.getPhoneServicePort();
		Phone phoneInfo = phoneServicePort.getPhoneInfo("android");
		
		System.out.println(phoneInfo.getName());
		System.out.println(phoneInfo.getOwner());
		System.out.println(phoneInfo.getTotal());
		
		
	}

}
