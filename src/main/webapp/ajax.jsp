<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="scripts/jquery-1.4.4.js"></script>
	
	<script type="text/javascript">
	
	$(function()
	{
		$("#button1").click(function()
		{
			$.ajax({
				
				type: "POST",
				url: "MyServlet",
				dateType: "html",
				data: {'param1': $("#param1").val(), 'param2': $("#param2").val()},
				success: function(returnedData){
					$("#result").val(returnedData);
				}
				
			});
		});
	});
	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  </head>
  
  <body>
    
    <input type="text" id="param1">+
    <input type="text" id="param2">=
    
    <input type="text" id="result"> <input type="button" value="get content from server" id="button1">
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
