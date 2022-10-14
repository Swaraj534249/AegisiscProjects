<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>



	<form method="post" action="visitercontact.html">

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
			<label for="visitermessage" class="form-label">Message</label>
			<textarea class="form-control" name="visitermessage" id="visitermessage" rows="2"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>