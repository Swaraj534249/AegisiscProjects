<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" 
	integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>

<script type="text/javascript">
	function surdel(ii) {

		var res = confirm("Are You Sure you want to delete this item");
		if (res == true) {
			window.location.href = "deletecart.html?cartId=" + ii;
			return true;
		} else if (res == false) {
			return false;
		}
	}
</script>

</head>
<body>

<div><%@ include file="headerUser.jsp"%></div>
	<div class="container border rounded-3 mt-4">
		



		<h2 align="center">Cart List</h2>
		<div id="table_sort" class="autoscroll">
			<table class="table table-sortable list files">
				<thead>
					<tr>
						<th scope="sort">Name</th>
						<th scope="sort">Quantity</th>
						
						<th>Price</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${cartlist}" var="cart">
						<c:set var="total"
				value="${total + cart.item.itemprice * cart.quantity }"></c:set>
							<tr>

								<td><a href="edititem.html?itemId=${cart.cartid}">${cart.item.itemname}</a></td>
								<td><a href="decrease.html?cartId=${cart.cartid}">sub</a>${cart.quantity}<a href="increase.html?cartId=${cart.cartid}">add</a></td>
								<td>${cart.amount}</td>
								
								<td class=""><a href="javascript:"
									onclick="surdel('${cart.cartid}')" href="${cart.cartid}"
									><img
										alt="" src="icon/trash-solid.svg" width="30"></a></td>
							</tr>
						</c:forEach>
						<td></td>
						
						<td></td>
						<td>${total }</td>
						<td><a data-bs-toggle="modal" data-bs-target="#buyModal">Buy</a></td>
					</tr>
					
					
				</tbody>
			</table>
			
					<div class="text-end me-5">
					<span>Your remaining balance :  </span>${user.balance - total}
					</div>
					
					
		</div>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="buyModal" tabindex="-1"
	aria-labelledby="buyModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="buyModalLabel">Contact Form</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div><%@ include file="buy.jsp"%></div>
			</div>
			<div class="modal-footer">
				
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>

<div><%@ include file="footer.jsp"%></div>
</body>
</html>