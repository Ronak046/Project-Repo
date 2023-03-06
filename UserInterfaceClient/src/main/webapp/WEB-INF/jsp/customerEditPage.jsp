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
<form:form method="post" action="edit-customer" modelAttribute="customerRecord">
<h1 style="color:red">
<u><i>Customer Status updation</i></u>
</h1>
<br/><br/>
<h2>
Customer Id:<form:input type="text" path="customerId" readonly="true"/>
<br/><br/>
Customer Name:<form:input type="text" path="name" readonly="true"/>
<br/><br/>
Customer Address:<form:input type="text" path="address" readonly="true"/>
<br/><br/>
Contact Number:<form:input type="text" path="contactNo" readonly="true"/>
<br/><br/>
E-Mail Address:<form:input type="text" path="email" readonly="true"/>
<br/><br/>
Enter new Status:<form:input type="text" path="status"/>
<br/><br/>
<input type="submit" value="Submit"/>
</h2>
</form:form>
</div>
</body>
</html>