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
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">

function surdel(ii) {

	var res = confirm("Are You Sure you want to delete this item");
	if (res == true) {
		window.location.href = "deletecategory.html?categoryId=" + ii;
		return true;
	} else if (res == false) {
		return false;
	}
}
</script>




<style type="text/css">
.contextual {
	float: right;
	white-space: nowrap;
	line-height: 1.4em;
	margin: 5px 0px;
	padding-left: 10px;
	font-size: 0.9em;
}
.listAction{
display: flex;
    gap: 20px;
    /* justify-content: center; */
}
</style>
<script type="text/javascript">
function myFunction() {
	  alert("id is "+${category.categoryId});
	}

</script>

</head>
<body onload="myFunction()">

	<div><%@ include file="headerAdmin.jsp"%></div>
	<div class="container border rounded-3">
		<div class="contextual">
			<button class="icon icon-add" onclick="myFunction()"
				name="icon-up">New file</button>
		</div>

		<div style="display:none" id="uploadHolder">
			<div><%@ include file="addcategory.jsp"%></div>
		</div>

		<h2 align="center">Category List</h2>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Desc</th>
					<th scope="col">Count</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${categorylist}" var="category">
						<tr>

							<td>${category.categoryId}</td>
							<td><button onclick="alert('id is '${category.categoryId})">alert</button></td>
							<td>${category.categoryname}</td>
							<td></td>
							<td class="listAction"><a href="editcategory.html?categoryId=${category.categoryId}"><img
									alt="" src="icon/pen-to-square-regular.svg" width="30"></a>
									<a	href="javascript:" onclick="surdel('${category.categoryId}')"
								href="${category.categoryId}" data-bs-toggle="modal"
								data-bs-target="#exampleModal"><img alt=""
									src="icon/trash-solid.svg" width="30"></a></td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>

	</div>
	<script type="text/javascript">
			<!--
				var pager = new Pager('results',10);
				pager.init();
				pager.showPageNav('pager', 'pageNavPosition');
				pager.showPage(1);
			//-->
			</script>
			
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