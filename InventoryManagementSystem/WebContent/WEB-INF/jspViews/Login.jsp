<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<f:form action="validateLogin.html" method="post" modelAttribute="userBean">
<table>
<tr>
<td>User Name</td>
<td><f:input type="text" path="userName"/></td>
</tr>
<tr>
<td>Password</td>
<td><f:input type="password" path="password"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Login"/></td>
</tr>
</table>
</f:form>

</body>
</html>