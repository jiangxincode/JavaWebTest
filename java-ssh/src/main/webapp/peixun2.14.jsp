<%--��application����ʵ����ҳ������peixun2.14.jsp�ļ�����--%>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312"%>
<html>
	<head><title>��ҳ������</title><head>
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
���ǵ�<%=application.getAttribute("counter")%>λ�����ߣ�
</body>
</html>
