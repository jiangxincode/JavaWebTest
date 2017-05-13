<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*, java.io.*"%>
<%@ page import="org.apache.log4j.PropertyConfigurator"%>
<%
    String state = request.getParameter("state");
    if(state != null && state.trim().equals("start"))
    {
    	PropertyConfigurator.configure("./log4j.properties");
    }
%>
<HTML>
<HEAD>
<TITLE>动态更新log4j配置</TITLE>
</HEAD>
<BODY>
	<A HREF="log4jReload.jsp?state=start">开始</A>
</BODY>
</HTML>
