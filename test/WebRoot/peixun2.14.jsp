<%--��application����ʵ����ҳ������peixun2.14.jsp�ļ�����--%>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<html>
	<head><title>��ҳ������</title><head>
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
���ǵ�<%=session.getAttribute("counter")%>λ�����ߣ�
</body>
</html>
