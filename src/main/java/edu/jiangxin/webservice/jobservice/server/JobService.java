package edu.jiangxin.webservice.jobservice.server;

import javax.jws.WebService;

/**
 * 面向接口的webservice发布方式
 */
@WebService(targetNamespace = "http://jobservice.webservice.jiangxin.edu")
public interface JobService {
	public String getJob();
}
