<%@page contentType="text/html;gb2312" pageEncoding="gb2312"%>

<HTML>
  <BODY>
  <%
    String Name=request.getParameter("userName");
    session.setAttribute("LogName", Name);
  %>
  �������"<%=Name%>"�Ѿ�д��session 
  <br>
  <a href='check_session.jsp'>check</a>
  </BODY>
</HTML>

