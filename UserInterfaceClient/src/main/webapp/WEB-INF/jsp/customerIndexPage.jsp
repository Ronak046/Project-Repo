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
<h3>
<a href="/customers/customer-entry">Customer Entry</a>
</h3>

<hr size="4" color="cyan"/>
<h1 style="color:red">
<u><i>All Customer</i></u>
</h1>
<h4>
<table border="2">
  <tr>
    <th>Customer ID</th>
    <th>Customer Name</th>
    <th>Customer Address</th>
    <th>ContactNumber</th>
    <th>E-mail Address</th>
    <th>Status</th>
    <th>Action</th> 
  </tr>
    <c:forEach  items="${customerList}" var="customer">
      <tr>
      <td>${customer.customerId}</td>
      <td>${customer.name}</td>
      <td>${customer.address}</td>
      <td>${customer.contactNo}</td>
      <td>${customer.email}</td>
      <td>${customer.status}</td>
        <td><a href="delete-customer/${customer.customerId}">Delete</a>&nbsp;&nbsp;
         <a href="show-customer/${customer.customerId}">show</a>&nbsp;&nbsp;
      </tr>
     </c:forEach>
  </table>
  </h4>
  <td><a href="/users/index">Return</a>
</div>
</body>
</html>