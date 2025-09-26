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
			$.get("GetImageServlet",
			{
				categoryName: $("#categoryName").val(),
				picSource: $("input[name=picSource]:checked").val()
			}, function(returnedData, status)
			{
				$("#div1").empty();
				
				var html = "";
				
				for(var i = 0; i < returnedData.length; i++)
				{
					html += "<img src='" + returnedData[i] + "' width='150' height='150'>";
				}
				
				$("#div1").append(html);
			});
		});
		
		$("#button2").click(function()
		{
			$("#div2").html("<font color='red'>processing</font>");
			
			$.post("SaveImageServlet",{},function()
			{
				
			});
			
		});
		
	});
	
	
	
	</script>
	
	
	
	
	
  </head>
  
  <body>
    
    <input type="text" id="categoryName">
    <input type="radio" name="picSource" value="google" checked>Google
    <input type="radio" name="picSource" value="flickr">Flickr
    <input type="button" value="click" id="button1">
    <input type="button" value="save" id="button2">
    
    <div id="div2"></div>
    
    <div id="div1"></div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
