<%@ page language="java" pageEncoding="GB2312" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>用户注册</title>
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
		if(password_again.value.length < 1)
		{
			alert("重复密码不能为空");
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
		
		if(password.value != password_again.value)
		{
			alert("密码输入不一致");
			return false;
		}
		if(truename.value.length < 1)
		{
			alert("真实姓名不能为空");
			return false;
		}
		if(birthday.value.length < 1)
		{
			alert("生日不能为空");
			return false;
		}
		
		if(!sex[0].checked && !sex[1].checked)
		{
			alert("性别必须选择");
			return false;			
		}
		
		var n = 0;
		
		for( i = 0 ; i < 4 ; i++)
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

<form action="/test/ProcessUsersServlet" method="post" name="form1" onSubmit="return validate();">

用户名：<input type="text" name="username" size="20"><br>
密  码：<input type="password" name="password" size="20"><br> 
重复输入密码：<input type="password" name="password_again" size="20"><br>
真实姓名：<input type="text" name="truename" size="20"><br> 
出生日期：<input type="text" name="birthday" size="20"><br>
性别：男<input type="radio" name="sex" value="0">&nbsp;&nbsp;
女<input type="radio" name="sex" value="1"><br>
兴趣: 足球<input type="checkbox" name="interest" value="0">&nbsp;&nbsp;
篮球<input type="checkbox" name="interest" value="1">&nbsp;&nbsp;
排球<input type="checkbox" name="interest" value="2">&nbsp;&nbsp;
羽毛球<input type="checkbox" name="interest" value="3">&nbsp;&nbsp;<br>

说明：<textarea name="remark" rows="15" cols="20"></textarea><br>
<input type="submit" value="点击确认">&nbsp;&nbsp;&nbsp;<input type="reset" value="重  置">
<input type="hidden" name="type" value="save">
</form>

</body>
</html>