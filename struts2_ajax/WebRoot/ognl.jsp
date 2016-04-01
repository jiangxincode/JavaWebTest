<%@ page language="java" import="java.util.*, com.opensymphony.xwork2.*, com.opensymphony.xwork2.util.*, com.shengsiyuan.action.ognl.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  username: <s:property value="username"/><br>
  password: <s:property value="password"/><br>
  
  ----------------------------------------<br>
  
  username: <s:property value="#parameters.username"/><br>
  password: <s:property value="#parameters.password"/><br>
  
  ----------------------------------------<br>
  
  request: <s:property value="#request.hello"/><br>
  session: <s:property value="#session.hello"/><br>
  application: <s:property value="#application.hello"/><br>
  attr: <s:property value="#attr.hello"/><br>
  
  ----------------------------------------<br>
  
  request: <%= ((Map)ActionContext.getContext().get("request")).get("hello") %><br>
  session: <%= ActionContext.getContext().getSession().get("hello") %><br>
  application: <%= ActionContext.getContext().getApplication().get("hello") %><br>
  attr: <%= ((Map)ActionContext.getContext().get("attr")).get("hello") %><br>
  
  ----------------------------------------<br>
  
  person1: address: <s:property value="list[0].address"/><br>
  person2: age: <s:property value="list[1].age"/><br>
  person1: cat1: name: <s:property value="list[0].cat.name"/><br>
  size: <s:property value="list.size"/><br>
  isEmpty: <s:property value="list.isEmpty()"/><br>
  
  ----------------------------------------<br>
  
  person1: address: <%= ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getList().get(0).getAddress() %><br>
  person2: age: <%= ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getList().get(1).getAge() %><br>
  person1: cat1: name: <%= ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getList().get(0).getCat().getName() %><br>
 
  ----------------------------------------<br>
  
  person2:friend: <s:property value="list[1].friends[2]"/><br>
  person2:frined: <%= ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getList().get(1).getFriends()[2] %><br>
  
  ----------------------------------------<br>
  
  person2: map2: <s:property value="list[1].map['hello2']"/><br>
  
  ----------------------------------------<br>
  
  filtering: <s:property value="list.{? #this.name.length() > 2}[1].name"/><br>
  
  ----------------------------------------<br>
   
  <s:iterator value="list.{? #this.name.length() > 2}">
  
  <s:property value="name"/><br>
  <s:property value="cat.color"/><br>
  <s:property value="friends[0]"/><br>
  
  </s:iterator>
   
   ----------------------------------------<br>
   
   projection: <br>
  
  <s:iterator value="list.{age}">
  
  <s:property/><br>
  
  </s:iterator>
  
  
  
  </body>
</html>