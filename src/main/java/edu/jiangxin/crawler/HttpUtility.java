package edu.jiangxin.crawler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

@SuppressWarnings("deprecation")
public class HttpUtility {
	// 伪装用的agent
	private static String[] m_agent = {
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2)",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)", };

	private static final Logger m_debug = LogManager.getLogger("Debuglogger");

	// 取得"url"指定的entity
	public static HttpEntity GetEntity(String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet getMethod = new HttpGet(UrlUtility.Encode(url));
		getMethod.getParams().setParameter("http.protocol.cookie-policy",
				CookiePolicy.BROWSER_COMPATIBILITY);

		// 伪装agent
		java.util.Random r = new java.util.Random();
		getMethod.setHeader("User-Agent", m_agent[r.nextInt(m_agent.length)]);

		HttpResponse response = null;
		try {
			response = client.execute(getMethod);
		} catch (Exception e) {
			m_debug.debug("can't get response from " + url);
			m_debug.debug("reason is : " + e.getMessage());
			return null;
		}

		int statusCode = response.getStatusLine().getStatusCode();
		if ((statusCode == HttpStatus.SC_MOVED_PERMANENTLY)
				|| (statusCode == HttpStatus.SC_MOVED_TEMPORARILY)
				|| (statusCode == HttpStatus.SC_SEE_OTHER)
				|| (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) { // 转向抓取新链接
			return GetEntity(response.getLastHeader("Location").getValue());
		} else if (statusCode == HttpStatus.SC_NOT_FOUND) { // 找不到网页
			m_debug.debug(url + " : page was no found");
			response = null;
		}

		if (response != null)
			return response.getEntity();
		else
			return null;
	}

	// 从"entity"得到网页内容
	public static String GetContent(HttpEntity entity) {
		if (entity != null) {
			byte[] bytes;
			try {
				bytes = EntityUtils.toByteArray(entity);
			} catch (IOException e) {
				m_debug.debug("can't get bytes from entity. Reason are: "
						+ e.getMessage());
				return null;
			}

			String charSet = EntityUtils.getContentCharSet(entity); // 得到网页编译格式
			if (charSet != null) { // 网页本身有告知编码
				try {
					return new String(bytes, charSet);
				} catch (UnsupportedEncodingException e) {
					m_debug.debug("unsupported charset " + charSet);
					return null;
				}
			} else {
				return GetContent(bytes);
			}
		}

		return null;
	}

	// 使用ICU4J检测编码，并将编码后的网页内容返回
	public static String GetContent(byte[] bytes) {
		CharsetDetector detector = new CharsetDetector();
		detector.setText(bytes);
		CharsetMatch match = detector.detect();

		try {
			return match.getString();
		} catch (Exception e) {
			m_debug.debug("can't get content. Reason are: " + e.getMessage());
			return null;
		}
	}

}
