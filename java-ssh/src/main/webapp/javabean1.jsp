<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<body>
<%-- �����Լ���д��javaBean���ɵ�bean��� --%>
<jsp:useBean id="student" scope="session" class="com.test.bean.Student" />

<%-- ȡ����ֵ --%>
<%=student.getClassNo() %> <br>
<%=student.getName() %> <br>
<%=student.getAge() %> <br>
<%=student.isSexy() %> <br>
<!--��JSP�������趨bean���������ֵ-->
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
