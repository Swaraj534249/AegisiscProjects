<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>

	<div><%@ include file="headerUser.jsp"%></div>




	<div class="row ms-3 me-3 mt-4">
		<div class="col-2 border-end">
		<h2>Categories</h2>
		
		</div>
		<div class="col">
			<!-- <div id="table_sort" class="autoscroll">
				<table class="table table-sortable list files">
					<thead>
						<tr>
							<th scope="sort">Name</th>
							<th scope="sort">Date</th>
							<th scope="sort">Price</th>
							<th>Preview</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach items="${itemlist}" var="item">
								<tr>

									<td><a href="edititem.html?itemId=${item.itemid}">${item.itemname}</a></td>
									<td>${item.date}</td>
									<td>${item.itemprice}</td>
									<td></td>
									<td class="listAction"><a href="javascript:"
										onclick="surdel('${item.itemid}')" href="${item.itemid}"
										data-bs-toggle="modal" data-bs-target="#exampleModal"><img
											alt="" src="icon/trash-solid.svg" width="30"></a></td>
								</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div> -->


			<div class=" user-card-shop-row">
				<c:forEach items="${itemlist}" var="item">
				
					<div class="col p-0 user-card-shop">
					<a href="viewitem.html?itemId=${item.itemid}" >
						<div class="border border-1 ">
							<img src="images/about (3).png" class="card-img-top" alt="...">

							<div class="p-2 bd-highlight">
								<h4>${item.itemname}</h4>
								<h6 class="text-muted">${item.itemprice}</h6>

							</div>
							<div class="text-end">
								<a class="buy"
									href="insertcartshop.html?itemId=${item.itemid}&username=${user.username}">Add
									to cart</a>
							</div>



						</div>
						</a>
					</div>
					
				</c:forEach>

			</div>

		</div>
	</div>
	<div><%@ include file="footer.jsp"%></div>
</body>
</html>