<%--application对象示例，peixun2.13.jsp文件代码--%>
<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>application</title>
	<head>
	<body>
		<% out.println("Java Servlet API Version "+application.getMajorVersion()
	+"."+application.getMinorVersion()+"<br>");
	out.println("URL of 'peixun2.13.jsp' is: "+application.getResource("/peixun2.13.jsp")+"<br>");
	out.println("getServerInfo()="+application.getServerInfo()+"<br>");
	out.println(application.getRealPath(""));
	application.log("Add a Record to log_file");  %>
	</body>
</html>
