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
<u><i>Restaurant Details for ${restaurant.restaurantName}</i></u>
</h1>
<br/><br/>
<h2>
	Restaurant Id:${restaurant.restaurantId} 
	<br/><br/>
   	Restaurant Name:${restaurant.restaurantName}
   	<br/><br/> 
    Food Type:${restaurant.foodType}
    <br/><br/> 
   	

<u><i>Menu Details</i></u>
<table border="2">
  <tr>
    <th>Sl no</th>
    <th>Item Name</th>
    <th>Price</th>
  </tr>
    <c:forEach  items="${restaurant.menuList}" var="menuList">
      <tr>
      <td>${menuList.slno}</td>
      <td>${menuList.itemName}</td>
      <td>${menuList.price}</td>   
      </tr>
     </c:forEach>
  </table> 
    <br/><br/>
  <a href="/restaurants/restaurant">Return</a>
  </h2>
  </div>
</body>
</html>