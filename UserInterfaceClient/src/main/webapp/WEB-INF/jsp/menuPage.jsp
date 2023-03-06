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
<hr size="4" color="cyan"/>
<h1 style="color:red">
<u><i>All Menu</i></u>
</h1>
<h4>
<table border="2">
  <tr>
    <th>Serial Number</th>
    <th>Restaurant ID</th>
    <th>Item Name</th>
    <th>Price</th>
  </tr>
    <c:forEach  items="${restaurantList}" var="restaurant">
      <c:forEach items="${restaurant.menuList}" var="menu">
      <tr>
      <td>${menu.slno}</td>
      <td>${restaurant.restaurantId}</td>
      <td>${menu.itemName}</td>
      <td>${menu.price}</td>
      </tr>
      </c:forEach>
     </c:forEach>
  </table>
  </h4>
  <a href="/client/order-entry">Back</a>
</div>
</body>
</html>