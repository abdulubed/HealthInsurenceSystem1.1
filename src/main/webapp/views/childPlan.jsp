<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Child Care Plan</title>

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

<script>
$(document).ready(function(){
	
	 $("#email").blur(function(){
	 var enterEmail=$("#email").val();
	 $.ajax({
	 url :"arEmail",
	 data : {
	 email : enterEmail
	 },
	  success : function(result){
		 
	  if(result=='duplicate'){
		 
	   $("#email").empty;  
	  $("#emailError").html("**** Email is alrady avilable ****");
	  $("#email").focus();
	  }
	  else{
	  $("#emailError").html("");
	  }
	    }
	   })
	   })
	   });

</script> 




<!-- Date of birth picker -->
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'mm/dd/yy',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
			maxDate : '-0d'
		});
	});
</script>

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
						childName : {
							required : true,
						},
						childName : {
							required : true,
						},
						childGender : {
							required : true,
						},

						childDob : {
							required : true,
						},
						childSSN : {
							required : true,
							number : true,
						}

					},

					messages : {
						indivName : "Please Enter indivName",
						childName : "Please Enter childName",
						childGender : "Please select gender",
						childDob : "Please Enter dateofbirth",
						childSSN : "Please Enter ssnNumber"
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


<!-- ssn number field splitting -->
<script>
function function1() {
	var len = $("#ssnNumber1").val().length;
	if(len>=2){
		$("#ssnNumber2").focus();
	}
}
function function2() {
	var len = $("#ssnNumber2").val().length;
	if(len>=1){
		$("#ssnNumber3").focus();
	}
}
function function3(){
	var len=$("#ssnNumber3").val().length;
	var ssnNumber=$("#ssnNumber1").val()+$("#ssnNumber2").val()+$("#ssnNumber3").val();
	$("#ssnNumber4").val(ssnNumber);
	if(len>=4){
	$("#phone").focus();
	}
}
</script>

</head>


<body>
	<div id="page-wrapper">
		<div class="container">
			<h2 style="color: #39BC09;">${succMsg}</h2>
			




			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/childPlanRegister" modelAttribute="childModel" method="POST">

			<div class="panel panel-info">
				<div class="panel-heading">Child Data Collection Page</div>
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
										<label for="childName" class="col-md-4">Child Name *</label>
										<div class="col-md-6">
											<form:input path="childName" class="form-control"
												placeholder="Enter childName" />
											<form:errors path="childName" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="childGender" class="col-md-4">Child Gender </label>
										<div class="col-md-6">
											<form:radiobuttons items="${gendersList}" path="childGender" />
											<form:errors path="childGender" class="error" />
										</div>
									</div>

									

									<div class="form-group  ">
										<label for="childDob" class="col-md-4">Date Of
											Birth</label>
										<div class="col-md-6">
											<form:input path="childDob" id="datepicker"
												autocomplete="off" placeholder="Enter  dateOfBirth"
												class="form-control" />
											<form:errors path="childDob" class="error" />
										</div>
									</div>

									 <div class="form-group">
										<label for="ssnNumber" class="col-md-4">Child SsnNumber *</label>
										<div class="col-md-6">
									<input type="text"  id="ssnNumber1"  size="3" maxlength="3" onkeypress="function1()"/> 
									<input type="text"  id="ssnNumber2"  size="2" maxlength="2" onkeypress="function2()"/> 
									<input type="text"  id="ssnNumber3" size="4" maxlength="4"  onkeyup="function3()"  />
											<form:hidden path="ssnNumber" class="form-control" id="ssnNumber4"/>
											<form:errors path="ssnNumber" class="error"  />
											<div style="color:red" id="ssnNumberError">
										</div>
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