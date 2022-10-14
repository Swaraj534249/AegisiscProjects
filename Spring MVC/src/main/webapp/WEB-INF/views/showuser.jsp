<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Item Detail</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
	integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI="
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
	function surdel(ii) {

		var res = confirm("Are You Sure you want to delete this User");
		if (res == true) {
			window.location.href = "deleteuser.html?userid=" + ii;
			return true;
		} else if (res == false) {
			return false;
		}
	}
</script>

</head>
<body>
	<div><%@ include file="headerAdmin.jsp"%></div>
	<!-- <div class="container border rounded-3">
		<h2 align="center">User List</h2>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Role</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${userlist}" var="user">
						<tr>

							<td>${user.userid}</td>
							<td>${user.username}</td>
							<td>${user.useremail}</td>
							<td>${user.role.rolename}</td>
							<td><a href="javascript:" onclick="surdel('${user.userid}')"
								href="${user.userid}" data-bs-toggle="modal"
								data-bs-target="#exampleModal"><img alt=""
									src="icon/trash-solid.svg" width="30"></a></td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div> -->

	<div class="container">
	<h2 align="center">User List</h2>
		<div class="row row-cols-auto">
			<c:forEach items="${userlist}" var="user">
				<div class="col me-2 ms-2 p-0 user-card">
					<div class="border border-1 ">
						<img src="images/person.png" class="card-img-top" alt="...">
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<h4>${user.username}</h4>
								<h6 class="text-muted">${user.useremail}</h6>
								<h6 class="text-muted">${user.usercontactno}</h6>
							</div>
							<div class="p-2 bd-highlight">

								<h6 class="text-muted">${user.role.rolename}</h6>

							</div>
						</div>
						<p>Some quick example text to build on the card title and make
							up the bulk of the card's content.</p>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								
							</div>
							<div class="p-2 bd-highlight">
								<a href="javascript:" onclick="surdel('${user.userid}')"
									href="${user.userid}" data-bs-toggle="modal" class="mx-auto"
									data-bs-target="#exampleModal">Delete</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<div><%@ include file="footer.jsp"%></div>

</body>
</html>