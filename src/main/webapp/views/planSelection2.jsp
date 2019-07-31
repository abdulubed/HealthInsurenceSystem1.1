<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan Selection</title>


<!-- Latest compiled and minified BootStarp CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



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
			<h2 style="color: #39BC09;">${message}&nbsp;
				${applicationNumber}</h2>
				


			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/childDisplayForm" modelAttribute="planModel" method="POST">

				<div class="panel panel-info">
					<div class="panel-heading">Account Registration Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">
								
								
									<div class="form-group">
										<label for=caseId class="col-md-4">Case Id </label>
										<div class="col-md-6">
											${caseData.caseId}
											<input hidden="caseId" name="caseId" value="${caseData.caseId}">
										</div>
									</div>
									
									<div class="form-group">
										<label for=caseId class="col-md-4">FirstName </label>
										<div class="col-md-6">
											${caseData.firstName}
											<input hidden="firstName" name="firstName" value="${caseData.firstName}">
										</div>
									</div>
								
								<div class="form-group">
										<label for=caseId class="col-md-4">LastName </label>
										<div class="col-md-6">
											${caseData.lastName}
											<input hidden="lastName" name="lastName" value="${caseData.lastName}">
										</div>
									</div>
								
								
								
				.					<div class="form-group">
										<label for=role class="col-md-4">Select a Plan </label>
										<div class="col-md-6">
											<form:select path="planName" items="${planRecords}" />
											<form:errors path="planName" class="error" />
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
							value="Submit" />&nbsp;&nbsp; &nbsp;&nbsp;

					</div>
				</div>





			</form:form>


		</div>
	</div>




</body>
</html>