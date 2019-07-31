<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<!-- Jquery clentside validations -->
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<script type="text/javascript">
$(function() {
      $("#myForm").validate({
      rules: {
        userName: {
          required: true
        },
        password: {
          required: true
        }
      },
      messages: {
        userName: {
          required: "please enter UserName!!!"
        },
        password: {
          required: "Please enter Password!!!"
        }
          }
      });
});
</script>

<style type="text/css">
.error {
	color: red
}
</style>

</head>
<body>
<h1>${loginMessage}</h1>
<form:form  id="myForm" action="/validateLoginData" modelAttribute="loginModel" method="post">

UserName: <form:input path="userName"/> <br>
<form:errors path="userName" class="error"/>
Password: 	<form:input path="password" /> <br><br>
<form:errors path="password" class="error"/>

<input type="reset" value="Reset">
<input type="submit" value="Login Here">



</form:form>
<br>
<a href="forgetPassword"> Forget Password</a>


</body>
</html>