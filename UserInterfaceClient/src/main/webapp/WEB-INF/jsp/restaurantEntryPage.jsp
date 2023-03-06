<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:red">
<u><i>New Restaurant Entry</i></u>
</h1>
<br/><br/>
<form:form method="post" action="restaurant-entry" modelAttribute="restaurantRecord">
<h2>
<form:input type="hidden" path="restaurantId" value="00"/>
<br/><br/>
Enter Restaurant Name:<form:input type="text" path="restaurantName"/>
<br/><br/>
Enter Food Type :<form:input type="text" path="foodType"/>
<br/><br/>
<input type="submit" value="Submit"/>
</h2>
</form:form>
</div>
</body>
</html>