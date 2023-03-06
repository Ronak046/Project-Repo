<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<div align="center">

<hr size="4" color="cyan"/>
<h1 style="color:red">
<u><i>All Orders</i></u>
</h1>
<h4>
<table border="2">
  <tr>
    <th>Order ID</th>
    <th>Item Name</th>
    <th>Client ID</th>
    <th>Restaurant ID</th>
    <th>Quantity</th>
    <th>Amount</th>
    <th>Order Date</th>
    <th>Order Status</th>
    <th>Pay Status</th> 
  </tr>
    <c:forEach  items="${orderList}" var="order">
      <c:forEach items="${order.itemList}" var="item">
      <tr>
      <td>${order.orderId}</td>
      <td>${item.itemName}</td>
      <td>${order.clientId}</td>
      <td>${item.restaurantId}</td>
      <td>${item.quantity}</td>
      <td>${item.amount}</td>
      <td>${item.orderDate}</td>
      <td>${item.orderStatus}</td>
      <td>${item.payStatus}</td>
      <td><a href="delete-item/${item.itemNo}">Delete</a></td>  
      </tr>
      </c:forEach>
     </c:forEach>
  </table>
  </h4>

 <a href="/client/resume-order"><button class="btn btn-primary btn-lg">Resume order</button></a>
&nbsp;&nbsp;

<a href="/users/index">Return</a>
</div>
</body>
</html>













