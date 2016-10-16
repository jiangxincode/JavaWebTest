package edu.jiangxin.webservice.jobservice.client;

import edu.jiangxin.webservice.jobservice.JobService;
import edu.jiangxin.webservice.jobservice.JobServiceImplService;

public class ClientTest {
	/**
	 * 测试通过实现接口的webservice发布方式
	 *
	 */
	public static void main(String[] args) {
		JobServiceImplService ws = new JobServiceImplService();
		JobService jobServiceImplPort = ws.getJobServiceImplPort();
		String jobs = jobServiceImplPort.getJob();
		// "JEE研发工程师|Android研发工程师|数据库工程师|前端工程师|测试工程师|运维工程师"
		String[] jobArray = jobs.split("\\|");
		System.out.println(jobArray[2]);
		System.out.println(jobArray[0]);
		System.out.println(jobArray[3]);
	}
}
