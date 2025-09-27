<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script type="text/javascript">
    
    function selectAll()
    {
    	var allMails = document.getElementsByName("allMails")[0];
    	var mails = document.getElementsByName("email");
    	
    	if(allMails.checked)
    	{
    		for(var i = 0; i < mails.length; i++)
    		{
    			mails[i].checked = true;
    		}
    	}
    	else
    	{
    		for(var i = 0; i < mails.length; i++)
    		{
    			mails[i].checked = false;
    		}
    	}
    	
    	var nodes = document.getElementsByTagName("input");
    	for(var i = 0; i < nodes.length; i++)
    	{
    		alert(nodes[i].type);
    	}
    	
    }
    
    </script>

  </head>
  
  <body>
   
   全选<input type="checkbox" onclick="selectAll()" name="allMails"><br><br><br>
   
   <input type="checkbox" name="email"><br>
   <input type="checkbox" name="email"><br>
   <input type="checkbox" name="email"><br>
   
   <input type="radio"><br>
   <input type="text">
   <input type="password">
   <input type="file">   
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  </body>
</html>
