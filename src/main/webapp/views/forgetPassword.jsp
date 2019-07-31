<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
</head>
<body>

<h1>Forget Password</h1>

<form action="/passwordSendToEmail" method="post">

Email:<input type="text" name="email"/><br><br><br>
<input type="reset" value="Reset"> &nbsp;&nbsp;&nbsp;
<input type="submit" value="Recover Password">

</form>


</body>
</html>