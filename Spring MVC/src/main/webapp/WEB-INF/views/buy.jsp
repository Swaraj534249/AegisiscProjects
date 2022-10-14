<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

<form method="post" action="contactbuy.html">

		<div class="row">
			<div class="col">
				<label for="visitername" class="form-label">Name</label> <input type="text"
					class="form-control" name="visitername" id="visitername" placeholder="First name"
					aria-label="First name">
			</div>
			<div class="col">
				<label for="visiteremail" class="form-label">Email address</label> <input
					type="email" class="form-control" name="visiteremail" id="visiteremail" placeholder="Email"
					aria-label="email">
			</div>
		</div>
		<div class="mb-3">
			<label for="visitermessage" class="form-label">Address</label>
			<textarea class="form-control" name="visitermessage" id="visitermessage" rows="2"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>