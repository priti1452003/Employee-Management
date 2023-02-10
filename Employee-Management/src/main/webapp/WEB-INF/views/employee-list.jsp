
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Employee List</title>
<style type="text/css">
.tfont {
	font-size: 20px;
}
</style>
</head>
<body>
	<div class="container p-1 my-3 bg-warning text-white">
		<!-- <h1 style="text-align: center;">!   !</h1> -->
	</div>
	<div class="container p-1 my-3 bg-primary text-white">
		

		<nav class="d-flex justify-content-around navbar navbar-expand-sm bg-primary navbar-dark">
			<h1 class="navbar-tex" style="text-align: center;">Great Learning Employee Management</h1>
			<!-- Add Logout Button -->
			<form:form class="form-inline" action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input class="btn btn-outline-warning btn-lg " type="submit"
					value="logout">
			</form:form>
		</nav>

		<hr style="height: 5px; background-color: white;">
		<a class="btn btn-outline-warning btn-lg" href="showEmployeeForm">Add
			Employee</a>

		<table class="table table-hover tfont">
			<thead>
				<tr>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					
					<th>EmailId</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="employee" items="${employees}" varStatus="c">
				<tbody class="text-white">

					<tr>
						<td>${c.count}</td>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.emailid}</td>
						


						<td>
							<!-- Add "update" button/link --> <a class="btn btn-info btn-sm"
							href="update?id=${employee.id}">Update</a> <!-- Add "delete" button/link -->
							<a class="btn btn-danger btn-sm" href="delete?id=${employee.id}"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>


</body>

</html>