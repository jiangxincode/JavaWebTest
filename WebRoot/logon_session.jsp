<%@page contentType="text/html;gb2312" pageEncoding="gb2312"%>

<HTML>
  <BODY>
  <%
    String Name=request.getParameter("userName");
    session.setAttribute("LogName", Name);
  %>
  你的名字"<%=Name%>"已经写入session 
  <br>
  <a href='check_session.jsp'>check</a>
  </BODY>
</HTML>

