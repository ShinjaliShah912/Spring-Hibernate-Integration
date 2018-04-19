<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Books</title>
</head>
<body bgcolor="lightblue">
<center>
<h1>List Books</h1>
<h3><a href="add.html">Add More Book</a></h3>

<c:if test="${!empty books}">
	<table align="center" border="1">
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Book Edition</th>
			<th>Book Price</th>
			<th>Book Author</th>
		</tr>

		<c:forEach items="${books}" var="book">
			<tr>
				<td><c:out value="${book.id}"/></td>
				<td><c:out value="${book.name}"/></td>
				<td><c:out value="${book.edition}"/></td>
				<td><c:out value="${book.price}"/></td>
				<td><c:out value="${book.author}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</center>
</body>
</html>