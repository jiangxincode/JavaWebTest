<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<body>
<%-- 引用自己编写的javaBean生成的bean组件 --%>
<jsp:useBean id="student" scope="session" class="com.test.bean.Student" />

<%-- 取属性值 --%>
<%=student.getClassNo() %> <br>
<%=student.getName() %> <br>
<%=student.getAge() %> <br>
<%=student.isSexy() %> <br>
<!--用JSP类属性设定bean组件的属性值-->
<%student.setClassNo(000002); %>
<%student.setName("John"); %>
<%student.setAge(26); %>
<%student.setSexy(false); %>
<br>
<%=student.getClassNo() %> <br>
<%=student.getName() %> <br>
<%=student.getAge() %> <br>
<%=student.isSexy() %> <br>
</body>
</html>
