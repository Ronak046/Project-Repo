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
<a href="restaurant-entry">Restaurant Entry</a>
</h3>

<hr size="4" color="cyan"/>
<h1 style="color:red">
<u><i>All Restaurant</i></u>
</h1>
<h4>
<table border="2">
  <tr>
    <th>Restaurant ID</th>
    <th>Restaurant Name</th>
    <th>Restaurant type</th>
    <th>Action</th> 
  </tr>
  
    <c:forEach  items="${restaurantList}" var="restaurant">
      <tr>
      <td>${restaurant.restaurantId}</td>
      <td>${restaurant.restaurantName}</td>
      <td>${restaurant.foodType}</td>   
        <td><a href="delete-restaurant/${restaurant.restaurantId}">Delete</a>
        &nbsp;&nbsp;<a href="display-restaurant/${restaurant.restaurantId}">Display</a>
        </td>  
      </tr>
     </c:forEach>
  </table>
  </h4>
     <td><a href="/users/index">Return</a>
</div>
</body>
</html>