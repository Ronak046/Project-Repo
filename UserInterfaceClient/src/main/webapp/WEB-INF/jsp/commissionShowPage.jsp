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
<h1 style="color:red">
<u><i>Commission</i></u>
</h1>
  <br/><br/>
  <h2>
	Commission Amount Collected:"${Commission}"
  </h2>
  <br/><br/>
 <a href="/users/index">Return</a>
</div>
</body>
</html>