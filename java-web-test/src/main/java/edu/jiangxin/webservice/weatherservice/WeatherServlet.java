package edu.jiangxin.webservice.weatherservice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSHttpGet;
import cn.com.webxml.WeatherWSSoap;

public class WeatherServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private WeatherWS ws;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----------------------");
		request.setCharacterEncoding("UTF-8");
		String cityCode=request.getParameter("city");
		System.out.println("获取城市的id"+cityCode);
		/*//通过webservice获取远程的天气预报信息
		WeatherWSSoap weatherWSSoap = ws.getWeatherWSSoap();
		List<String> weathers = weatherWSSoap.getWeather(cityCode, "").getStrings();
		String weather=weathers.get(8);//取得温度信息
*/

		URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="
				+ cityCode + "&theUserID=" + "");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		String weather = "";
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream boas = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = is.read(buffer)) != -1) {
				boas.write(buffer, 0, len);
			}
			System.out.println("GET请求获取的数据:" + boas.toString());
			weather = boas.toString();
			boas.close();
			is.close();
		}

		//把结果回显给页面
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter=response.getWriter();
		printWriter.write(weather);
		printWriter.flush();
		printWriter.close();

	}

	public void init() throws ServletException {
		// Put your code here
		ws=new WeatherWS();
	}

	public static void main(String[] args) {
		WeatherWS ws=new WeatherWS();
		/*WeatherWSSoap weatherWSSoap = ws.getWeatherWSSoap();
		System.out.println(weatherWSSoap.getRegionCountry().getStrings());
		System.out.println(weatherWSSoap.getRegionProvince().getStrings());
		//31124
		System.out.println(weatherWSSoap.getSupportCityString("31124").getStrings());
		List<String> weathers = weatherWSSoap.getWeather("2349","").getStrings();*/
		WeatherWSHttpGet weatherWSSoap = ws.getWeatherWSHttpGet();
		System.out.println(weatherWSSoap.getWeather("2349", "").getString());

	}

}
