package cn.it.ws.service.e;

import javax.jws.WebService;

/**面向接口的webservice发布方式
 * 
 * 
 * @author 李俊  2015年5月17日
 */
@WebService
public interface JobService {
	public String getJob();
}
