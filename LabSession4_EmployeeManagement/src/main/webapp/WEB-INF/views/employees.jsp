<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="#">Employee Management System</a>

		<!-- Toggler/collapsibe Button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>

	<div class="container">
		<div class="row">
			<h1>List Employees</h1>
		</div>

		<div class="container">			
					<!-- Add a search form -->
		
		 <form action="employees/search" class="form-inline">
			
			<div class="row">
			<!-- Add a button -->
			
				<a href="/employees" class="btn btn-primary btn-sm mb-3 mx-auto">
					Add Employee</a>
					
					<!-- Add a search input -->
					<input
					type="search" name="firstName" placeholder="firstName"
					class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
					name="lastName" placeholder="lastName"
					class="form-control-sm mr-2 mb-3" />
					
					<button type="submit" class="btn btn-primary btn-sm mb-3">Search</button>
					
				
				
				<!-- Add a Order Button -->
					
				<a href="/employees/order"
						class="btn btn-primary btn-sm mb-3">Order</a>	
					
					
				<!-- Add a LogOut Button -->
				<a href="/EmployeeManagement/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a>
					
			</div>
		</div>
		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th>Employee First Name</th>
					<th>Employee Last Name</th>
					<th>Employee Email</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<tr th:each="employee: ${employees}">
					<td th:text="${employee.firstName}"></td>
					<td th:text="${employee.lastName}"></td>
					<td th:text="${employee.email}"></td>
					<td><a th:href="@{/employees/edit/{id}(id=${employee.id})}"
						class="btn btn-primary">Update</a> <a
						th:href="@{/employees/{id}(id=${employee.id})}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</tbody>

		</table>

	</div>
</body>
</html>