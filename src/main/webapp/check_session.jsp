<%@page contentType="text/html;gb2312" pageEncoding="GBK"%>
<HTML><BODY>
  <%
    String yourName=(String)session.getAttribute("LogName");
    if (yourName == null)
    {
    %>Äú»¹Î´µÇÂ¼
    <%
    }else
    {
    %>
    "<%=yourName%>"ÒÑ¾­µÇÂ¼
    <%
    }
  %>
</BODY></HTML>
