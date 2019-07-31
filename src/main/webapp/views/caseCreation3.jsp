<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>case creation</title>


<!-- Latest compiled and minified BootStarp CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<!-- Jquery client side validations -->
<style>
.userform {
	width: 400px;
}

.userform p {
	width: 50%;
}

.userform label {
	width: 120px;
	color: #333;
	float: left;
}

input.error {
	border: 1px dotted red;
}

label.error {
	width: 100%;
	color: red;
	font-style: italic;
	margin-left: 120px;
	margin-bottom: 5px;
}

.userform input.submit {
	margin-left: 120px;
}
</style>


<script type="text/javascript">
	(function($, W, D) {
		var JQUERY4U = {};
		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#myForm").validate({
					rules : {

						applicationNumber : {
							required : true,
						}
				},

					messages : {
						applicationNumber : "Please Enter applicationNumber",
					},
					submitHandler : function(form) {
						form.submit();
					}
				});
			}
		}
		//when the dom has loaded setup form validation rules
		$(D).ready(function($) {
			JQUERY4U.UTIL.setupFormValidation();
		});
	})(jQuery, window, document);
</script>

<style type="text/css">
.error {
	color: red
}

.a {
	color: #0325AC;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
}

.a:hover {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>



</head>


<body>
	<div id="page-wrapper">
		<div class="container">


 			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/citizenSerarch" modelAttribute="arModel" method="POST">

				<div class="panel panel-info">
					<div class="panel-heading">Citizen Searching</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">

									<div class="form-group">
										<label for=role class="col-md-4">Application Registration Number </label>
										<div class="col-md-6">
											<form:input path="applicationNumber"/>
											<form:errors path="applicationNumber" class="error" />
										</div>
									</div>

									<!-- end divs -->
					</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 col-md-offset-4" style="margin-bottom: 50px;">
					<div align="center">
						<input type="reset" class="btn btn-primary" value="reset" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-primary" id="createAccBtn"
							value="Search" />&nbsp;&nbsp; &nbsp;&nbsp;
						
					</div>
				</div>

			</form:form>
 	
<%-- <form action="/citizenSerarch" name="myForm" class="form-horizontal" id="myForm" method="POST">
				<div class="panel panel-info">
					<div class="panel-heading">Citizen Searching</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">

									<div class="form-group">
										<label for=role class="col-md-4">Application Registration Number </label>
										<div class="col-md-6">
										<input type="text" value="${applicationNumber}" name="applicationNumber">
										</div>
									</div>

									<!-- end divs -->
					</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 col-md-offset-4" style="margin-bottom: 50px;">
					<div align="center">
						<input type="reset" class="btn btn-primary" value="reset" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-primary" id="createAccBtn"
							value="Search" />&nbsp;&nbsp; &nbsp;&nbsp;
						
					</div>
				</div>

</form>
 --%>
  		<br>
   <h2 style="color: red">${errMessage}</h2>
</div>
</div>


	<div>			
	<div id="page-wrapper">
		<div class="container">

			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/getPlansDetails" modelAttribute="arModel" method="POST">

				<div class="panel panel-info">
					<div class="panel-heading">Application Registration Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">
								
								<div class="form-group">
										<label for="applicationNumber" class="col-md-4">Application Number *</label>
										<div class="col-md-6">
											<form:input path="applicationNumber" class="form-control"
												placeholder="Enter applicationNumber"/>
											<form:errors path="applicationNumber" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="firstName" class="col-md-4">First Name *</label>
										<div class="col-md-6">
											<form:input path="firstName" class="form-control"
												placeholder="Enter firstName"/>
											<form:errors path="firstName" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="lastName" class="col-md-4">Last Name *</label>
										<div class="col-md-6">
											<form:input path="lastName" class="form-control"
												placeholder="Enter lastName" />
											<form:errors path="lastName" class="error" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="gender" class="col-md-4">Gender
										</label>
										<div class="col-md-6">
											<form:input path="gender"
												placeholder="Enter gender" class="form-control" id="gender"/>
											<form:errors path="gender" class="error" />
										</div>
									</div>

								

									<div class="form-group">
										<label for="email" class="col-md-4">Email *</label>
										<div class="col-md-6">
											<form:input path="email" class="form-control"
												placeholder="Enter email" id="email" />
											<form:errors path="email" class="error" /> &nbsp;
											<div style="color:red" id="emailError"  name="emailError">
										</div>
									</div>

									

									<div class="form-group  ">
										<label for="dateOfBirth" class="col-md-4">Date Of
											Birth</label>
										<div class="col-md-6">
											<form:input path="dateOfBirth" id="datepicker"
												autocomplete="off" placeholder="Enter  dateOfBirth"
												class="form-control" />
											<form:errors path="dateOfBirth" class="error" />
										</div>
									</div>

									<%--  <div class="form-group">
										<label for="ssnNumber" class="col-md-4">Ssn Number *</label>
										<div class="col-md-6">
									<input type="text"  id="ssnNumber1"  size="3" maxlength="3" onkeypress="function1()"/> 
									<input type="text"  id="ssnNumber2"  size="2" maxlength="2" onkeypress="function2()"/> 
									<input type="text"  id="ssnNumber3" size="4" maxlength="4"  onkeyup="function3()"  />
											<form:hidden path="ssnNumber" class="form-control" id="ssnNumber4"/>
											<form:errors path="ssnNumber" class="error"  />
											<div style="color:red" id="ssnNumberError"  name="ssnNumberError">
										</div>
										</div>
									</div>  --%>
					
									<div class="form-group">
										<label for="ssnNumber" class="col-md-4">ssnNumber *</label>
										<div class="col-md-6">
											<form:input path="ssnNumber" class="form-control"
												placeholder="Enter ssnNumber" id="ssnNumber" />
											<form:errors path="ssnNumber" class="ssnNumber" /> &nbsp;
										</div>
									</div>
								



									<div class="form-group">
										<label for="phoneNumber" class="col-md-4">Phone Number
										</label>
										<div class="col-md-6">
											<form:input path="phoneNumber"
												placeholder="Enter phoneNumber" class="form-control" id="phone"/>
											<form:errors path="phoneNumber" class="error" />
										</div>
									</div>
									

									<!-- end divs -->
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				

				<div class="col-md-4 col-md-offset-4" style="margin-bottom: 50px;">
					<div align="center">
						<input type="reset" class="btn btn-primary" value="reset" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-primary" id="createAccBtn"
							value="Submit" />&nbsp;&nbsp; &nbsp;&nbsp;
						
					</div>
				</div>





			</form:form>

		</div>
	</div>
	


</body>
</html>