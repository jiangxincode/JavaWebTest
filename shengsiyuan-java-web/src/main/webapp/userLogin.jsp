<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <script type="text/javascript">
    
    function validate()
    {
    	var username = document.getElementsByName("username")[0];
    	var password = document.getElementsByName("password")[0];
    	var gender = document.getElementsByName("gender");
    	var interest = document.getElementsByName("interest");
    	var comment = document.getElementsByName("comment")[0];
    	
    	if(username.value.length < 1)
    	{
    		alert("用户名不能为空！");
    		
    		return false;
    	}
    	
    	if(password.value.length < 1)
    	{
    		alert("密码不能为空！");
    		
    		return false;
    	}
    	
    	if(username.value.length < 4 || username.value.length > 10)
    	{
			alert("用户名长度应该介于4到10之间");    	
			
			return false;
    	}
    	
    	if(password.value.length < 4 || password.value.length > 10)
    	{
			alert("密码长度应该介于4到10之间");    	
			
			return false;
		}
    	
    	if(!gender[0].checked && !gender[1].checked)
    	{
    		alert("性别必须要选择");
    		
    		return false;
    	}
    	
    	var n = 0;
    	
    	for(var i = 0; i < interest.length; i++)
    	{
    		if(interest[i].checked)
    		{
    			n++;
    		}
    	}
    	
    	if(n < 1)
    	{
    		alert("兴趣至少选择一个!");
    		return false;
    	}
    	
    	if(n > 3)
    	{
    		alert("兴趣最多选择三个");
    		return false;
    	}
    	
    	if(comment.value.length < 1)
    	{
    		alert("说明必须要填写!");
    		return false;
    	}
    	
    	return true;
    }
    
    </script>
    
  </head>
  
  <body>
   
   <form action="ProcessServlet">
   
 用户名：<input type="text" name="username"><br>
 密  码： <input type="password" name="password"><br>
 
 性别： 男<input type="radio" name="gender" value="男"> 
 &nbsp;&nbsp;女<input type="radio" name="gender" value="女"><br>
 
兴趣：足球<input type="checkbox" name="interest" value="足球">&nbsp;&nbsp;
篮球<input type="checkbox" name="interest" value="篮球">&nbsp;&nbsp;
排球<input type="checkbox" name="interest" value="排球">&nbsp;&nbsp;
羽毛球<input type="checkbox" name="interest" value="羽毛球">&nbsp;&nbsp;<br>

地址：
<select name="address">
	<option value="上海">上海</option>
	<option value="北京">北京</option>
	<option value="天津">天津</option>
</select>
<br>
说明：
<textarea name="comment" rows="15" cols="20"></textarea><br>

<input type="submit" value="点击确认">&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置">
   
   </form>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  </body>
</html>
