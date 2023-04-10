<!-- Add Support for Spring MVC Form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<title>Save Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />


</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM -Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<h3>Save Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer"
				method="POST">

				<!-- need to associate this data with customer id -->
				<form:hidden path="id" />

				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName" placeholder="John"></form:input>
								<form:errors path="firstName" cssClass="error"/></td>
						</tr>

						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName" placeholder="Chen"></form:input>
								<form:errors path="lastName" cssClass="error"/></td>
						</tr>

						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email"  placeholder="johnchen1@gmail.com"></form:input>
								<form:errors path="email" cssClass="error"/></td>
						</tr>
		

						<tr>
							<td><label>Phone Number:</label></td>
							<td><form:input path="phoneNum" placeholder="xxx-xxx-xxxx"></form:input>
							<form:errors path="phoneNum" cssClass="error"/></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>

			<div>
				<p>
					<a href="${pageContext.request.contextPath}/customer/list">
						Back to List</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>