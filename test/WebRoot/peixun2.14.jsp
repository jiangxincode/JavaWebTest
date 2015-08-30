<%--用application对象实现网页计数器peixun2.14.jsp文件代码--%>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<html>
	<head><title>网页计数器</title><head>
<body>
<%  if (application.getAttribute("counter")==null)
	application.setAttribute("counter","1");
	else{
		String strnum=null;
		strnum=application.getAttribute("counter").toString();
		int icount=0;
		icount=Integer.valueOf(strnum).intValue();
		icount++;
		application.setAttribute("counter",Integer.toString(icount));
		}  %>
您是第<%=application.getAttribute("counter")%>位访问者！
</body>
</html>
