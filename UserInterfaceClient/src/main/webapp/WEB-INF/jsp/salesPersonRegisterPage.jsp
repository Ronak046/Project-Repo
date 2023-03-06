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
<div align="center">
<h3>
<form:form action="salesPerson-register" method="post" modelAttribute="userRecord">
Enter New User Name:<form:input  path="username"/>
<br/><br/>
Enter New Password:<form:input type="password" path="password"/>
<br/><br/>
Enter New Email-Id:<form:input path="emailId"/>
<br/><br/>
Enter UserType:<form:input path="userType" readonly="true" value="salesPerson"/>
<br/><br/>
<input type="submit" value="Submit"/>
</form:form>
</h3>
</div>
</body>
</html>