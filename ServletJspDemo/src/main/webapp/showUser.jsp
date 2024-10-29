<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>List User</title>
</head>
<body>
	<div align="center">
		<h1>Input/Display Tiếng Việt OK</h1>
		<a href="./new">Add New User</a> <br /> 
		<a href="./list">List All User</a>
	</div>
	<div align="center">
		<table border="1" cellpadding="5">
			<h2>List all user</h2>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listAllUser}">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.email}" /></td>
					<td><c:out value="${book.country}" /></td>
					<td><a href="./edit?id=<c:out value='${book.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="./delete?id=<c:out value='${book.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>