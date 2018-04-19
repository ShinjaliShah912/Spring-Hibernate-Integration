<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body bgcolor="orange">
		<center>
		<h2>Add Books Data</h2> 
		<form:form method="POST" action="save.html">
	   		<table>
			    <%-- <tr>
			        <td><form:label path="id">Book ID:</form:label></td>
			        <td><form:input path="id" value="${book.id}" readonly="true" /></td>
			    </tr> --%>
			    <tr>
			        <td><form:label path="name">Book Name:</form:label></td>
			        <td><form:input path="name" value="${book.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="edition">Book Edition:</form:label></td>
			        <td><form:input path="edition" value="${book.edition}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="price">Book Price:</form:label></td>
			        <td><form:input path="price" value="${book.price}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="author">Book Author:</form:label></td>
                    <td><form:input path="author" value="${book.author}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty books}">
		<h2>List Books</h2>
	<table align="center" border="1">
		<tr>
			 <th>Book ID</th> 
			<th>Book Name</th>
			<th>Book Edition</th>
			<th>Book Price</th>
			<th>Book Author</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${books}" var="book">
			<tr>
				<td><c:out value="${book.id}"/></td> 
				<td><c:out value="${book.name}"/></td>
				<td><c:out value="${book.edition}"/></td>
				<td><c:out value="${book.price}"/></td>
				<td><c:out value="${book.author}"/></td>
				<td align="center"><a href="edit.html?id=${book.id}">Edit</a> | <a href="delete.html?id=${book.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</center>
	</body>
</html>