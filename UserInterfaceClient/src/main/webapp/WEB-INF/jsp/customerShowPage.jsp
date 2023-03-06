<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:red">
<u><i>Customer Details for ${customer.customerId}</i></u>
</h1>
<br/><br/>
<h2>
	Customer Id:${customer.customerId} 
	<br/><br/>
   	Customer Name:${customer.name}
   	<br/><br/> 
    Customer Address:${customer.address}
    <br/><br/> 
    Customer ContactNo:${customer.contactNo}
    <br/><br/> 
    Customer Email:${customer.email} 
    <br/><br/>
     Customer Status:${customer.status} 
    <br/><br/>
  <a href="/customers/customer">Return</a>
  </h2>
  </div>
</body>
</html>