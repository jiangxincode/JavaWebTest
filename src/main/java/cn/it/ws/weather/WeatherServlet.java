package cn.it.ws.weather;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class WeatherServlet extends HttpServlet {
	private WeatherWS ws;

	public WeatherServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cityCode=request.getParameter("city");
		System.out.println("获取城市的id"+cityCode);
		//通过webservice获取远程的天气预报信息
		WeatherWSSoap weatherWSSoap = ws.getWeatherWSSoap();
		List<String> weathers = weatherWSSoap.getWeather(cityCode, "").getString();
		String weather=weathers.get(8);//取得温度信息
		
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

}
