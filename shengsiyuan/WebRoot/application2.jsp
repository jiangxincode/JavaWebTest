<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>application</title>
	</head>
	
	<body>
		
		<%
			
		out.println("Java Servlet API Version "
					+ application.getMajorVersion() + "."
					+ application.getMinorVersion() + "<br>");
			
		out.println("URL of 'application2.jsp' is: "
					+ application.getResource("/application2.jsp") + "<br>");
			
		out.println("getServerInfo()=" + application.getServerInfo()
					+ "<br>");
	    // getRealPath�����᷵����Դ�ڷ������ϵľ���·��
		out.println(application.getRealPath("/application2.jsp"));
		%>
	</body>
</html>