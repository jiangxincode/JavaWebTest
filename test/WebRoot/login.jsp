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
				alert("�û�������");
				username.focus();
				return false;
			}
			if(username.value.length < 4)
			{
				alert("�û������ȹ���");
				username.focus();
				return false;
			}
			if(username.value.length > 10)
			{
				alert("�û������ȹ���");
				username.focus();
				return false;
			}
			
			if(password.value.length < 1)
			{
				alert("�������");
				password.focus();
				return false;
			}
			if(password.value.length < 4)
			{
				alert("���볤�ȹ���");
				password.focus();
				return false;
			}
			if(password.value.length > 10)
			{
				alert("���볤�ȹ���");
				password.focus();
				return false;
			}
			
			if(!sex[0].checked && !sex[1].checked)
			{
				alert("�Ա����ѡ��");
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
				alert("��Ȥ����ѡ��");
				return false;
			}
			if(count > 3)
			{
				alert("��Ȥ���ѡ��3��");
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
  
  <body>
    
    <form name="form1" onsubmit="return validate();">
		
		�û�����<input type="text" name="username" size="20"><br>
		����:  <input type="password" name="password" size="20"><br>
		�Ա���<input type="radio" name="sex" value="��">&nbsp;&nbsp;&nbsp;
			 Ů<input type="radio" name="sex" value="Ů"><br>
		��Ȥ������<input type="checkbox" name="interest" value="����">&nbsp;&nbsp;
			 ����<input type="checkbox" name="interest" value="����">&nbsp;&nbsp;
			 ����<input type="checkbox" name="interest" value="����">&nbsp;&nbsp;
			 ��ë��<input type="checkbox" name="interest" value="��ë��">&nbsp;&nbsp;<br>
		��ַ��<select name="city">
				<option value="shanghai">�Ϻ�</option>
				<option value="beijing">����</option>
				<option value="qingdao">�ൺ</option>
				<option value="rizhao">����</option>
			 </select>	 <br>
	    ˵����<textarea rows="15" cols="15" name="remark"></textarea>
		<br>
		
		<input type="submit" value="����ύ">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="����">


	</form>
	    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  </body>
</html>
