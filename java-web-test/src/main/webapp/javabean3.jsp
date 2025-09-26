<%@ page language="java" import="com.shengsiyuan.bean.Student"
	pageEncoding="UTF-8"%>
<html>
	<body>
		
		<%-- 引用自己编写的javaBean生成的bean组件 --%>
		<jsp:useBean id="student" scope="application"
			class="com.shengsiyuan.bean.Student" />
		
		<%=student.getName()%><br>
		
		<%
			student.setName("cong");
		%>
		<%-- 用getProperty动作来返回bean组件的属性值 --%>
		<jsp:getProperty name="student" property="classNo" />
		<br>
		<jsp:getProperty name="student" property="name" />
		<br>
		<jsp:getProperty name="student" property="age" />
		<br>
		<jsp:getProperty name="student" property="sexy" />
		<br>
		<%-- 取属性值 --%>
		<%=student.getClassNo()%>
		<br>
		<%=student.getName()%>
		<br>
		<%=student.getAge()%>
		<br>
		<%=student.isSexy()%>
		<br>
		
		<jsp:useBean id="date" class="java.util.Date" scope="application"></jsp:useBean>
		
		<%= date.toLocaleString() %>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</body>
</html>