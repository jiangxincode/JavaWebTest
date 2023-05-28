package edu.jiangxin.webservice.jobservice.server;

import javax.xml.ws.Endpoint;

public class ServerTest {

	public static void main(String[] args) {
		JobService jobService = new JobServiceImpl();
		String address = "http://localhost:33000/ws/jobservice";
		Endpoint.publish(address, jobService);
		System.out.println("wsdl地址:" + address + "?WSDL");

	}

}
