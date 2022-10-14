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

		var res = confirm("Are You Sure you want to delete this item");
		if (res == true) {
			window.location.href = "deleteitem.html?itemId=" + ii;
			return true;
		} else if (res == false) {
			return false;
		}
	}
</script>


</head>
<body>
	<div><%@ include file="headerAdmin.jsp"%></div>
	


	<div class="container">
	<div class="contextual">
			<button class="icon icon-add" onclick="myFunction()" name="icon-up">New
				file</button>
		</div>
	<div style="display: none" id="uploadHolder">
			<div><%@ include file="additem.jsp"%></div>
		</div>
		<h2 align="center">Item List</h2>
		<div class="row row-cols-auto">
			<c:forEach items="${itemlist}" var="item">
				<div class="col me-2 ms-2 p-0 item-card">
					<div class="border border-1 ">
						<img src="images/about (3).png" class="card-img-top" alt="...">
						<div class="d-flex justify-content-between">
						
							<div class="p-2 bd-highlight">
								<a href="edititem.html?itemId=${item.itemid}" >${item.itemname}</a>
								<h6 class="text-muted">Category</h6>
								<h6 class="text-muted">Something else</h6>
							</div>
							<div class="p-2 bd-highlight">

								<h6 class="text-muted">${item.itemprice}</h6>

							</div>
						</div>
						<p>Some quick example text to build on the card title and make
							up the bulk of the card's content.</p>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<h6>${item.date}</h4>
							</div>
							<div class="p-2 bd-highlight">
								<a href="javascript:"
									onclick="surdel('${item.itemid}')" href="${item.itemid}"
									>Delete</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<div><%@ include file="footer.jsp"%></div>

	<script type="text/javascript">
		function myFunction() {
			var x = document.getElementById("uploadHolder");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
	</script>
</body>
</html>