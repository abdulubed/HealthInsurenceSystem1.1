<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicaid Plan</title>

<!-- date picker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
					ignore: "",
					rules : {

						indivName : {
							required : true,
						},
						employmentIncome : {
							required : true,
						},
						propertiesCost : {
							required : true,
						},
						otherIncome : {
							required : true,
						}
					},

					messages : {
						indivName : "Please Enter indivName",
						employmentIncome : "Please select employmentIncome",
						propertiesCost : "Please Enter propertiesCost",
						otherIncome : "Please Enter otherIncome"
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
			<h2 style="color: #39BC09;">${succMsg}</h2>
			




			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/childPlanRegister" modelAttribute="medicaidModel" method="POST">

			<div class="panel panel-info">
				<div class="panel-heading">Snap Plan Data Collection Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">

									<div class="form-group">
										<label for="indivName" class="col-md-4">indivName *</label>
										<div class="col-md-6">
											<form:input path="indivName" class="form-control"
												placeholder="Enter indivName"/>
											<form:errors path="indivName" class="error" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="employmentIncome" class="col-md-4">Employment Income  *</label>
										<div class="col-md-6">
												<form:input path="employmentIncome" class="form-control"
												placeholder="Enter employmentIncome"/>
											<form:errors path="employmentIncome" class="error" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="propertiesCost" class="col-md-4">Properties Cost *</label>
										<div class="col-md-6">
											<form:input path="propertiesCost" class="form-control"
												placeholder="Enter propertiesCost" />
											<form:errors path="propertiesCost" class="error" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="otherIncome" class="col-md-4">OtherIncome *</label>
										<div class="col-md-6">
											<form:input path="otherIncome" class="form-control"
												placeholder="Enter otherIncome" />
											<form:errors path="otherIncome" class="error" />
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





					<button>
							<a href="getCitizensAccounts" class="a">view all records</a>&nbsp;&nbsp;
						</button>

		</div>
</div>

</body>
</html>