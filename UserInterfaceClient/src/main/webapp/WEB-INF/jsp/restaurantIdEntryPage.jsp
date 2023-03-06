<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Entry</title>
</head>
<body>
<div align="center">
<h1 style="color:red">
<u><i>Restaurant Id</i></u>
</h1>
<br/><br/>
<form:form method="post" action="restaurantId-entry" modelAttribute="itemRecord" >
<h2>
Enter Restaurant Id:<form:input type="text" path="restaurantId"/>
<br/><br/>
<input type="submit" value="Submit"/>
</h2>
</form:form>
</div>
</body>
</html>