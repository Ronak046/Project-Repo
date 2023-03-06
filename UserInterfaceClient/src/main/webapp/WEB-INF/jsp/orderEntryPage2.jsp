<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<u><i>New Item Entry</i></u>
</h1>
<br/><br/>
<form:form method="post" action="item-entry" modelAttribute="itemRecord">
<h2>
Enter Restaurant Id:<form:input type="text" path="restaurantId"/>
<form:input type="hidden" path="itemNo" value="00"/>
<br/><br/>
Enter Item Name:<form:input type="text" path="itemName"/>
<br/><br/>
Enter Quantity:<form:input type="text" path="quantity"/>
<br/><br/>
Enter Order Status:<form:input type="text" path="orderStatus" readonly="true"/>
<br/><br/>
Enter Pay Status:<form:input type="text" path="payStatus" readonly="true"/>
<br/><br/>
<input type="submit" name="Next" value="Next"/>
<input type="submit" name="Finish" value="Finish"/>
<br/><br/>
</h2>
</form:form>
<!--<a href="/client/item-entry"><button class="btn btn-primary btn-lg">Add Items</button></a>
&nbsp;&nbsp;-->
<a href="/restaurants/show-menu"><button class="btn btn-primary btn-lg">Display Menu</button></a>
&nbsp;&nbsp;
</div>
</body>
</html>