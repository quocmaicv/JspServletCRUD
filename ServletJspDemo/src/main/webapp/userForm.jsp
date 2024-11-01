<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Form</title>
</head>
<body>
	<h1>Input/Display Tiếng Việt OK</h1>
	<h2>
		<a href="./new">Add New User</a> &nbsp;&nbsp;&nbsp; 
		<a href="./list">List All User</a>

	</h2>
	</center>
	<div align="center">
		<c:if test="${book != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${book == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book != null}">
                        Edit User
                    </c:if>
					<c:if test="${book == null}">
                        New User
                    </c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="id" value="<c:out value='${book.id}' />" />
			</c:if>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${book.name}' />" />
				</td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="email" size="45"
					value="<c:out value='${book.email}' />" /></td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><input type="text" name="country" size="45"
					value="<c:out value='${book.country}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>