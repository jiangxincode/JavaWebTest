<%@page contentType="text/html;gb2312" pageEncoding="GBK"%>
<HTML><BODY>
  <%
    String yourName=(String)session.getAttribute("LogName");
    if (yourName == null)
    {
    %>����δ��¼
    <%
    }else
    {
    %>
    "<%=yourName%>"�Ѿ���¼
    <%
    }
  %>
</BODY></HTML>
