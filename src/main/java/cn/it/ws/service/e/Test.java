package cn.it.ws.service.e;

import javax.xml.ws.Endpoint;

public class Test {

	public static void main(String[] args) {
		JobService jobService=new JobServiceImpl();
		String address="http://192.168.114.10:9999/ws/jobservice";
		Endpoint.publish(address, jobService);
		System.out.println("wsdl地址:"+address+"?WSDL");

	}

}
