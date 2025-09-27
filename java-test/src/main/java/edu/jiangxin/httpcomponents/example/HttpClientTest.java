package edu.jiangxin.httpcomponents.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void testHttpClient01()
			throws ClientProtocolException, IOException, NoSuchAlgorithmException, KeyManagementException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		SSLContext ctx = SSLContext.getInstance("SSL");

		ctx.init(null, new TrustManager[] { new MyX509TrustManager() }, null);

		SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx);

		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.INSTANCE).register("https", ssf).build();
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry);
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
				.setRetryHandler(new MyHttpRequestRetryHandler())
				.setServiceUnavailableRetryStrategy(new MyServiceUnavailableRetryStrategy()).build();

		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		CloseableHttpResponse response = httpclient.execute(httpGet);

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			System.out.println(EntityUtils.toString(entity, "UTF-8"));
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
		httpClient.close();
	}

	@Test
	public void testHttpClient02() throws ClientProtocolException, IOException, NoSuchAlgorithmException,
			KeyManagementException, KeyStoreException, CertificateException {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		SSLContext ctx = SSLContext.getInstance("SSL");

		FileInputStream instream = null;
		KeyStore trustStore = null;
		trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		// 密钥库路径
		instream = new FileInputStream(new File(""));
		//密钥库密码
		trustStore.load(instream, "tomcat".toCharArray());
		// 相信自己的CA和所有自签名的证书
		ctx = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();

		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(ctx)).build();
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry);
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();

		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		CloseableHttpResponse response = httpclient.execute(httpGet);

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			System.out.println(EntityUtils.toString(entity, "UTF-8"));
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();
		httpClient.close();
	}

}

class MyX509TrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {

	}

	@Override
	public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}

class MyHttpRequestRetryHandler implements HttpRequestRetryHandler {

	@Override
	public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
		return false;
	}

}

class MyServiceUnavailableRetryStrategy implements ServiceUnavailableRetryStrategy {

	@Override
	public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context) {
		return false;
	}

	@Override
	public long getRetryInterval() {
		return 0;
	}

}
