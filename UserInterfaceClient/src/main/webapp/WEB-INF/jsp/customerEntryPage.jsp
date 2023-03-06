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
<u><i>New Customer Entry</i></u>
</h1>
<br/><br/>
<form:form method="post" action="customer-entry" modelAttribute="customerRecord">
<h2>
<form:input type="hidden" path="customerId" value="00"/>
<br/><br/>
Enter Customer Name:<form:input type="text" path="name"/>
<br/><br/>
Enter Customer Address:<form:input type="text" path="address"/>
<br/><br/>
Enter Contact Number:<form:input type="text" path="contactNo"/>
<br/><br/>
Enter E-Mail Address:<form:input type="text" path="email"/>
<br/><br/>
<form:input type="hidden" path="status" value="00"/>
<br/><br/>
<input type="submit" value="Submit"/>
</h2>
</form:form>
</div>
</body>
</html>