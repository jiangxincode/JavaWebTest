<%@ page language="java" pageEncoding="gb2312" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<body>  
<%-- �����Լ���д��javaBean���ɵ�bean��� --%>
<jsp:useBean id="student" scope="application" class="com.test.bean.Student"/> 
<%=student.getName()%><br>
<% student.setName("cong"); %> 

<%-- ��getProperty����������bean���������ֵ --%> 
<jsp:getProperty name="student" property="classNo" /> <br>
<jsp:getProperty name="student" property="name" /> <br>
<jsp:getProperty name="student" property="age" /> <br>
<jsp:getProperty name="student" property="sexy" /> <br>
<%-- ȡ����ֵ --%>
<%=student.getClassNo() %> <br>
<%=student.getName() %> <br>
<%=student.getAge() %> <br>
<%=student.isSexy() %> <br>


</body>
</html>

