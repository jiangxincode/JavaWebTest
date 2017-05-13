<%@ page contentType="text/html; charset=GB2312" pageEncoding="gb2312"%>
<%@ page session="true" %>
<html>
<head>
  <title>session练习</title>
</head>

<body bgcolor="#FFFFFF" onLoad="document.loginForm.username.focus()">

<%
  String name="";
if(!session.isNew()){
    name=(String)session.getAttribute("username");
    if(name==null)name="";
}
%>
<p>欢迎光临邮件系统</p>
<p>Session ID:<%=session.getId()%></p>

<form name="loginForm" method="post" action="mailcheck.jsp">
  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>
       
        <table width="500" border="0" cellspacing="0" cellpadding="0">
         
          <tr>
            <td width="401"><div align="right">User Name:&nbsp;</div></td>
            <td width="399"><input type="text" name="username" value=<%=name%>></td>
          </tr>
          <tr>
            <td width="401"><div align="right">Password:&nbsp;</div></td>
            <td width="399"><input type="password" name="password"></td>
          </tr>
          <tr>
            <td width="401">&nbsp;</td>
            <td width="399"><br><input type="Submit" name="Submit"  value="提交"></td>
          </tr>
          
        </table> 
       
      </td>
    </tr>
  </table>
 </form>
</body>
</html>
