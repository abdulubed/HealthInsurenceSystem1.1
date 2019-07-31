<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan details</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet"
	href=https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>

<style type="text/css">
.a {
	text-decoration: none;
	color: #0325AC;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	align: center
}

.a:hover {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>


	<table border="1" id="example">

		<thead>
			<tr>
				<th>Plan Id</th>
				<th>Plan Name</th>
				<th>Plan Description</th>
				<th>Plan Start Date</th>
				<th>Plan End Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${planRecords}" var="planRecords">
			<tr>
				<td><c:out value="${planRecords.planId}" /></td>
				<td><c:out value="${planRecords.planName}" /></td>
				<td><c:out value="${planRecords.planDescription}" /></td>
				<td><c:out value="${planRecords.startDate}" /></td>
				<td><c:out value="${planRecords.endDate}" /></td>
				<td><c:out value="${planRecords.status}" /></td>
				
				<td><a href="<c:url value='/editPlan/${planRecords.planId}'  />" ><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="images/edit.jpg"></a>
				
				
				
				
				<c:if test="${planRecords.status == 'active' }">
				<a href="<c:url value='/planStatusInActive/${planRecords.planId}'  />" ><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="images/active.jpg"></a>
				</c:if>
				
					<c:if test="${planRecords.status == 'inActive' }">
				<a href="<c:url value='/planStatusActive/${planRecords.planId}' />" ><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="images/inActive.jpg"></a>
				</c:if>
				
 </td>
 			</tr>
		</c:forEach>
	</table>

	<a href="/displayPlanForm">Plan Registraion Page</a>
</body>
</html>