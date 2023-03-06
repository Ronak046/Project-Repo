<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="/users/login" var="login"/>
<div align="center">
<h1 style="color:blue"><u>Welcome to Great Indian Gourmet</u></h1>
<br/><br/>
<h3>
<form:form action="${login}">
Enter User Name:<input type="text" name="username"/>
<br/><br/>
Enter Password:<input type="password" name="password"/>
<br/><br/>
<input type="submit" value="Submit"/>
<br/><br/>
</form:form>
</h3>
<h2>
<a href="/users/customer-register"><u>New here? Register</u></a>
</h2>
</div>
</body>
</html>