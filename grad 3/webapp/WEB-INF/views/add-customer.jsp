<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<div class="jumbotron jumbotron-fluid bg-primary text-white">
  <div class="container">
    <h1 class="display-4">Customer Relationship Management</h1>
  </div>
</div>
		<hr>

	
  <form action="/CustomerRelationshipManagementApplication/customer/save" method="POST">
  	<input type="hidden" name="id" value="${Customer.id}" />
  <div class="form-group">
    <label for="FirstName">First Name</label>
    <input type="text" name="firstName" value="${Customer.firstName}"
     class="form-control" id="FirstName" placeholder="First Name">
  </div>
  <div class="form-group">
    <label for="LastName">Last Name</label>
    <input type="text"  name="lastName" value="${Customer.lastName}"
     class="form-control" id="LastName" placeholder="Last Name">
  </div>
  
   <div class="form-group">
    <label for="Email">Email</label>
    <input type="text"  name="email" value="${Customer.email}"
     class="form-control" id="Email" placeholder="Email">
  </div>
  <button type="submit" class="btn btn-success col-2">Save</button>

		</form>

		<hr>
		<a href="/CustomerRelationshipManagementApplication/customer/list">Back to Customer List</a>

	</div>
</body>

</html>










