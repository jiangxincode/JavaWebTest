<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
	function validate()
	{
		with(document.form1)
		{
			if(username.value.length < 1)
			{
				alert("用户名必填");
				username.focus();
				return false;
			}
			if(username.value.length < 4)
			{
				alert("用户名长度过短");
				username.focus();
				return false;
			}
			if(username.value.length > 10)
			{
				alert("用户名长度过长");
				username.focus();
				return false;
			}
			
			if(password.value.length < 1)
			{
				alert("密码必填");
				password.focus();
				return false;
			}
			if(password.value.length < 4)
			{
				alert("密码长度过短");
				password.focus();
				return false;
			}
			if(password.value.length > 10)
			{
				alert("密码长度过长");
				password.focus();
				return false;
			}
			
			if(!sex[0].checked && !sex[1].checked)
			{
				alert("性别必须选择");
				return false;
			}
			
			var count = 0;
			
			for(var i = 0 ; i < interest.length ; ++i)
			{
				if(interest[i].checked)
				{
					++count;
				}
			}
			
			if(count < 1)
			{
				alert("兴趣必须选择");
				return false;
			}
			if(count > 3)
			{
				alert("兴趣最多选择3项");
				return false;
			}
			
			if(remark.value.length < 1)
			{
				alert("说明必须填写");
				return false;
			}	
		}
	
		return true;
	}
	
	</script>

  </head>
  
  <body>
    
    <form name="form1" onsubmit="return validate();">
		
		用户名：<input type="text" name="username" size="20"><br>
		密码:  <input type="password" name="password" size="20"><br>
		性别：男<input type="radio" name="sex" value="男">&nbsp;&nbsp;&nbsp;
			 女<input type="radio" name="sex" value="女"><br>
		兴趣：足球<input type="checkbox" name="interest" value="足球">&nbsp;&nbsp;
			 篮球<input type="checkbox" name="interest" value="篮球">&nbsp;&nbsp;
			 排球<input type="checkbox" name="interest" value="排球">&nbsp;&nbsp;
			 羽毛球<input type="checkbox" name="interest" value="羽毛球">&nbsp;&nbsp;<br>
		地址：<select name="city">
				<option value="shanghai">上海</option>
				<option value="beijing">北京</option>
				<option value="qingdao">青岛</option>
				<option value="rizhao">日照</option>
			 </select>	 <br>
	    说明：<textarea rows="15" cols="15" name="remark"></textarea>
		<br>
		
		<input type="submit" value="点击提交">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置">


	</form>
	    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
