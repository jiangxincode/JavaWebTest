<%@ page language="java" pageEncoding="GB2312" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>�û�ע��</title>
<script language="javascript">

function validate()
{
	with(document.form1)
	{
		if(username.value.length < 1)
		{
			alert("�û�������Ϊ��");
			return false;
		}
		if(password.value.length < 1)
		{
			alert("���벻��Ϊ��");
			return false;
		}
		if(password_again.value.length < 1)
		{
			alert("�ظ����벻��Ϊ��");
			return false;
		}
		
		if(username.value.length < 4)
		{
			alert("�û������ȹ���");
			return false;
		}
		if(username.value.length > 10)
		{
			alert("�û������ȹ���");
			return false;
		}
		if(password.value.length < 4)
		{
			alert("���볤�ȹ���");
			return false;
		}
		if(password.value.length> 10 )
		{
			alert("���볤�ȹ���");
			return false;
		}
		
		if(password.value != password_again.value)
		{
			alert("�������벻һ��");
			return false;
		}
		if(truename.value.length < 1)
		{
			alert("��ʵ��������Ϊ��");
			return false;
		}
		if(birthday.value.length < 1)
		{
			alert("���ղ���Ϊ��");
			return false;
		}
		
		if(!sex[0].checked && !sex[1].checked)
		{
			alert("�Ա����ѡ��");
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
			alert("��Ȥ������Ҫѡ��һ��");
			return false;
		}
		if(n > 3)
		{
			alert("��Ȥ���ѡ������");
			return false;
		}
		
		
		
		if(remark.value.length < 1)
		{
			alert("˵��������д");
			return false;
		}
	}
	
	return true;
}

</script>

</head>
<body bgcolor="#FFFFFF">

<form action="/test/ProcessUsersServlet" method="post" name="form1" onSubmit="return validate();">

�û�����<input type="text" name="username" size="20"><br>
��  �룺<input type="password" name="password" size="20"><br> 
�ظ��������룺<input type="password" name="password_again" size="20"><br>
��ʵ������<input type="text" name="truename" size="20"><br> 
�������ڣ�<input type="text" name="birthday" size="20"><br>
�Ա���<input type="radio" name="sex" value="0">&nbsp;&nbsp;
Ů<input type="radio" name="sex" value="1"><br>
��Ȥ: ����<input type="checkbox" name="interest" value="0">&nbsp;&nbsp;
����<input type="checkbox" name="interest" value="1">&nbsp;&nbsp;
����<input type="checkbox" name="interest" value="2">&nbsp;&nbsp;
��ë��<input type="checkbox" name="interest" value="3">&nbsp;&nbsp;<br>

˵����<textarea name="remark" rows="15" cols="20"></textarea><br>
<input type="submit" value="���ȷ��">&nbsp;&nbsp;&nbsp;<input type="reset" value="��  ��">
<input type="hidden" name="type" value="save">
</form>

</body>
</html>