<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
	
	function del()
	{
		if(confirm("Are you sure?"))
		{
			return true;
		}
		
		return false;
	}
	</script>


  </head>
  
  <body>
   	
   	 <h1><font color="red"><center>Users List</center></font></h1>
   
   
   <table border="1" width="80%" align="center">
   
   	<tr>
   	
   	<td>
   		序号
   	</td>
   	
   	<td>
   		姓
   	</td>
   	
   	<td>
   		名
   	</td>
   	
   	<td>
   		年龄
   	</td>
   	
   	<td>
   		删除
   	</td>
   	
   	<td>
   		更新
   	</td>
   	
   	</tr>
   
   	<s:iterator value="#request.list" id="us">
   	
   		<tr>
   		
   			<td>
   				<s:property value="#us.id"/>
   			</td>
   			
   			<td>
   				<s:property value="#us.firstname"/>
   			</td>
   			
   			<td>
   				<s:property value="#us.lastname"/>
   			</td>
   			
   			<td>
   				<s:property value="#us.age"/>
   			</td>
   			
   			<td>
   				<s:a href="deleteUser.action?user.id=%{#us.id}" onclick="return del();">delete</s:a>
   			</td>
   			
   			<td>
   				<s:a href="updatePUser.action?user.id=%{#us.id}">update</s:a>
   			</td>
   		
   		
   		</tr>
   	
   	
   	</s:iterator>
   
   
   
   
   
   </table>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  </body>
</html>
