<%@ page language="java" pageEncoding="gb2312" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<body>  
<%-- 引用自己编写的javaBean生成的bean组件 --%>
<jsp:useBean id="student" scope="application" class="com.test.bean.Student"/> 
<%=student.getName()%><br>
<% student.setName("cong"); %> 

<%-- 用getProperty动作来返回bean组件的属性值 --%> 
<jsp:getProperty name="student" property="classNo" /> <br>
<jsp:getProperty name="student" property="name" /> <br>
<jsp:getProperty name="student" property="age" /> <br>
<jsp:getProperty name="student" property="sexy" /> <br>
<%-- 取属性值 --%>
<%=student.getClassNo() %> <br>
<%=student.getName() %> <br>
<%=student.getAge() %> <br>
<%=student.isSexy() %> <br>


</body>
</html>

