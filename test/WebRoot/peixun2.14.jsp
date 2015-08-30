<%--用application对象实现网页计数器peixun2.14.jsp文件代码--%>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<html>
	<head><title>网页计数器</title><head>
<body>
<%  if (session.getAttribute("counter")==null)
	session.setAttribute("counter","1");
	else{
		String strnum=null;
		strnum=session.getAttribute("counter").toString();
		int icount=0;
		icount=Integer.valueOf(strnum).intValue();
		icount++;
		session.setAttribute("counter",Integer.toString(icount));
		}  %>
您是第<%=session.getAttribute("counter")%>位访问者！
</body>
</html>
