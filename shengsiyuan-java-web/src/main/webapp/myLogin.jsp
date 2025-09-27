<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <script type="text/javascript">
    
    	function validate()
    	{
    		//var username = document.getElementById("username1");
    		//var password = document.getElementById("password1");
    		//var repassword = document.getElementById("repassword1");
    		
    		var username = document.getElementsByName("username")[0];
    		var password = document.getElementsByName("password")[0];
    		var repassword = document.getElementsByName("repassword")[0];
    		
    		if(username.value.length == 0)
    		{
				alert("username can't be blank!");
				
				return false;
    		}
    		
    		if(password.value.length < 6 || password.value.length > 10)
    		{
    			alert("length of password is invalid!");
    			
    			return false;
    		}
    		
    		if(repassword.value.length < 6 || repassword.value.length > 10)
    		{
    			alert("length of repassword is invalid!");
    			
    			return false;
    		}
    		
    		if(password.value != repassword.value)
    		{
    			alert("password not the same");
    			
    			return false;
    		}
    		
    		return true;
    	}
    
    
    </script>
    
  </head>
  
  <body>
    
    
    <form  action="ValidateServlet">
    
    username: <input type="text" name="username" id="username1"><br>
    password: <input type="password" name="password" id="password1"><br>
    re-password: <input type="password" name="repassword" id="repassword1"><br>
    
    <input type="submit" value="submit"> 
    
    </form>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
