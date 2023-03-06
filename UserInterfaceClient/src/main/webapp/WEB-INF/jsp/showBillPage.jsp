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
<u><i>Customer Bill</i></u>
</h1>
<h4>
<table border="2">
  <tr>
 	<th>Order Id</th>
    <th>Item Name</th>
    <th>Quantity</th>
    <th>Amount</th>
    <th>Order Date</th>
  </tr>
    <c:forEach  items="${itemList}" var="item">
      <tr>
      <td>${item.orderId}</td>
      <td>${item.itemName}</td>
      <td>${item.quantity}</td>
      <td>${item.amount}</td>
      <td>${item.orderDate}</td>
      </tr>
      </c:forEach>
  </table>
  <br/><br/>
  <form action="/client/payment" method="post">
  Total Amount:"${total}"
  <br/><br/>
  Discounted Amount:"${dAmt}"
  <br/><br/>
  Grand Total(GST+Service charges applied):"${totalAmt}"
  <br/><br/>
  Credit/Debit Card<input type="radio" name="myradio" value="credit"/>
  &nbsp;&nbsp;<input type="text"/>
  <br/><br/>
  NetBanking<input type="radio" name="myradio" value="net"/>
  &nbsp;&nbsp;<input type="text"/>
  <br/><br/>
  Cash<input type="radio" name="myradio" value="cash"/>
  <br/><br/>
  Pay Later<input type="radio" name="myradio" value="payLater"/>
  <br/><br/>
  <input type="submit" value="submit"/>
    </form>
   </h4>
</div>
</body>
</html>