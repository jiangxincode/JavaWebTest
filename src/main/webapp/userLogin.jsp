<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>login</title>
<script language="javascript">

function validate()
{
	with(document.form1)
	{
		if(username.value.length < 1)
		{
			alert("用户名不能为空");
			return false;
		}
		if(password.value.length < 1)
		{
			alert("密码不能为空");
			return false;
		}
		if(username.value.length < 4)
		{
			alert("用户名长度过短");
			return false;
		}
		if(username.value.length > 10)
		{
			alert("用户名长度过长");
			return false;
		}
		if(password.value.length < 4)
		{
			alert("密码长度过短");
			return false;
		}
		if(password.value.length> 10 )
		{
			alert("密码长度过长");
			return false;
		}
		
		if(!sex[0].checked && !sex[1].checked)
		{
			alert("性别必须选择");
			return false;			
		}
		
		var n = 0;
		
		for(var i = 0 ; i < 4 ; i++)
		{
			if(interest[i].checked)
			{
				n++;
			}
		}
		if(n < 1)
		{
			alert("兴趣至少需要选择一个");
			return false;
		}
		if(n > 3)
		{
			alert("兴趣最多选择三个");
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
<body bgcolor="#FFFFFF">
<!-- /test/ProcessServlet1 为服务器验证 -->
<form action="/test/ProcessServlet1" method="post" name="form1">

用户名：<input type="text" name="username" size="20"><br>
密  码：<input type="password" name="password" size="20"><br> 
性别：男<input type="radio" name="sex" value="男">&nbsp;&nbsp;
女<input type="radio" name="sex" value="女"><br>
兴趣: 足球<input type="checkbox" name="interest" value="足球">&nbsp;&nbsp;
篮球<input type="checkbox" name="interest" value="篮球">&nbsp;&nbsp;
排球<input type="checkbox" name="interest" value="排球">&nbsp;&nbsp;
羽毛球<input type="checkbox" name="interest" value="羽毛球">&nbsp;&nbsp;<br>
地址：<select name="address">
<option value="上海">上海</option>
<option value="北京">北京</option>
<option value="天津">天津</option>
<option value="广东">广东</option>
</select><br>

说明：<textarea name="remark" rows="15" cols="20"></textarea><br>
<input type="submit" value="点击确认">&nbsp;&nbsp;&nbsp;<input type="reset" value="重  置">

</form>

</body>
</html>