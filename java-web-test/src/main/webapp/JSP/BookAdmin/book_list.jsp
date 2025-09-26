<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="xl" uri="http://javaxp.net/xl" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>书籍列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/book_admin.css" />
</head>

<body>
	<form action="${ctx }/BookAdmin">
	<input type="hidden" name="act" value="search"/>
	书名包含:<input type="text" name="q_bookName" value="${param.q_bookName}"/><br/>
	作者包含:<input type="text" name="q_author" value="${param.q_author}"/>
	<input type="submit" value="查询">
	</form>
	<br /><br />
	
	<table cellspacing="0">
	<thead>
	<tr>
		<th>序号</th><th>书名</th><th>作者</th><th>价格</th><th>出版日期</th><th>编辑</th><th>删除</th>
	</tr>
	</thead>

<xl:queryForList sql="select * from book 
where 1=1 and bookName like '%${param.q_bookName}%' 
and author like '%${param.q_author}%'" var="books"/>

	<tbody>
		<c:forEach items="${books}" var="book" varStatus="status">
		<tr><td>${status.count}</td>
		<td>${book.bookName }</td>
		<td>${book.author }</td>
		<td>${book.price }</td>
		<fmt:formatDate pattern="yyyy-MM-dd" value="${book.publicationDate }" var="dateFmt"/>
		<td>${dateFmt }</td>
		<td><a href="${ctx }/BookAdmin?act=editForm&id=${book.id }">编辑</a></td>
		<td><a href="${ctx }/BookAdmin?act=delete&id=${book.id }">删除</a></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
<a href="${ctx }/BookAdmin?act=createForm">新增</a>

</body>
</html>