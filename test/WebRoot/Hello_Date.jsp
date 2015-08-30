<%@ page import="java.util.*" pageEncoding="gb2312"%>
<%@ page contentType="text/html;
                  charset=gb2312" %>
<HTML>
  <BODY>
    你好,今天是
  <%
    Date today=new Date();
  %>
    <%=today.getDate()%>号，
    星期<%=today.getDay()%>
  </BODY>
</HTML>
