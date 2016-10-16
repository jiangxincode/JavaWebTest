package edu.jiangxin.webservice.mobilecodeservice;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 调用第三方的webservice服务 ，获取电话号码信息
 * </p>
 * http://ws.webxml.com.cn
 * </p>
 * http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?op=getMobileCodeInfo
 */
public class InvokeMobileCodeServiceWithoutWsimportTool {

	/**
	 * http-get方式访问webservice
	 *
	 * @param mobileCode
	 * @param userID
	 * @throws Exception
	 */
	public void get(String mobileCode, String userID) throws Exception {
		URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="
				+ mobileCode + "&userID=" + userID);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream boas = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = is.read(buffer)) != -1) {
				boas.write(buffer, 0, len);
			}
			System.out.println("GET请求获取的数据:" + boas.toString());
			boas.close();
			is.close();
		}
	}

	/**
	 * Post请求 ：通过Http-Client 框架来模拟实现 Http请求.
	 *
	 * HttpClient访问网络的实现步骤:
	 * </p>
	 * 1. 准备一个请求客户端:浏览器
	 * </p>
	 * 2. 准备请求方式： GET 、POST
	 * </p>
	 * 3. 设置要传递的参数
	 * </p>
	 * 4. 执行请求
	 * </p>
	 * 5. 获取结果
	 * </p>
	 *
	 * @param mobileCode
	 * @param userID
	 * @throws Exception
	 */
	public void post(String mobileCode, String userID) throws Exception {
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(
				"http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
		// 3.设置请求参数
		postMethod.setParameter("mobileCode", mobileCode);
		postMethod.setParameter("userID", userID);
		// 4.执行请求 ,结果码
		int code = client.executeMethod(postMethod);
		if (code == 200) {
			// 5. 获取结果
			String result = postMethod.getResponseBodyAsString();
			System.out.println("Post请求的结果：" + result);
		}

	}

	/**
	 * Post请求 ：通过Http-Client 框架来模拟实现 Http请求
	 *
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public void soap() throws Exception {

		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
		// 3.设置请求参数
		String path = InvokeMobileCodeServiceWithoutWsimportTool.class.getResource("soap.xml").getPath();
		postMethod.setRequestBody(new FileInputStream(path));
		// 修改请求的头部
		postMethod.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
		// 4.执行请求 ,结果码
		int code = client.executeMethod(postMethod);
		if (code == 200) {
			// 5. 获取结果
			String result = postMethod.getResponseBodyAsString();
			System.out.println("Post请求的结果：" + result);
		}

	}

	public static void main(String[] args) throws Exception {
		InvokeMobileCodeServiceWithoutWsimportTool ws = new InvokeMobileCodeServiceWithoutWsimportTool();
		ws.get("15626217879", "");
		ws.post("15626217879", "");
		ws.soap();

	}

}
