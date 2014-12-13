package edu.jiangxin.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ClickFilter implements Filter {
	public final static String ClickstreamMapKey = "simpleClickstreamMap";
	Map<String,Integer> statMap;
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		Integer clicks = statMap.get(uri);
		if(clicks == null)clicks=0;
		clicks++;
		statMap.put(uri, clicks);
		if(uri.endsWith("/Click")){
			Set<Map.Entry<String,Integer>> entries = statMap.entrySet();
			List<Map.Entry<String,Integer>> entriesList = new ArrayList<Map.Entry<String,Integer>>();
			entriesList.addAll(entries);
			//Ҳ������Arrays��
			Collections.sort(entriesList, new Comparator<Map.Entry<String,Integer>>() {
				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			request.setAttribute("entriesList", entriesList);
			request.getRequestDispatcher("JSP/ClickFilter/Clicks.jsp").forward(request, response);
			return;
		}
	
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		statMap = new Hashtable<String, Integer>();
		fConfig.getServletContext().setAttribute(ClickstreamMapKey, statMap);
	}

	public void destroy() {
	}

}