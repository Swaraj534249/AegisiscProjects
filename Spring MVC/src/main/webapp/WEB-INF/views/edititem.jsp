
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Item Detail</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
	integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI="
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<script type="text/javascript">
		function updatesuccess() {
			alert("Data has been successfully Updated");
		}
	</script>

	<%@ include file="headerAdmin.jsp"%>
	&nbsp;&nbsp;

	

	<div class="row justify-content-center">
		<div class="col-4 ">
			<form:form method="post" action="editcurrentitem.html"
			onsubmit="updatesuccess()" commandName="Item">
				<div class="mb-3">
					<label for="itemname" class="form-label">Item Name </label> <input
						name="itemname" id="itemname" type="text" class="form-control" value="${item.itemname}" readonly>

				</div>
				<div class="mb-3">
					<label for="itemprice" class="form-label">Item Price</label> <input
						name="itemprice" id="itemprice" type="text" class="form-control"
						value="${item.itemprice}">
						
				</div>
				<div class="mb-3">
					<label for="costprice" class="form-label">Cost Price</label> <input
						name="costprice" id="costprice" type="text" class="form-control"
						value="${item.costprice}">
						
				</div>
				<div class="mb-3">
					
					 <input name="itemid" type="hidden" class="form-control" value="${item.itemid}" />
						
				</div>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
			
			<form:form method="post" action="editcurrentitem.html"
		onsubmit="updatesuccess()" commandName="Item">
		<div class="row mb-3">
			<div class="col">
				<input type="text" name="itemname" id="itemname"
					onblur="namevalid()" class="form-control" placeholder="Item name"
					aria-label="Item name" value="${item.itemname}" readonly>
			</div>

			<div class="col">
				<input type="text" name="itemprice" id="itemprice"
					onblur="pricevalid()" class="form-control" placeholder="Item price"
					aria-label="Item price" value="${item.itemprice}">
			</div>
			
			<div class="col">
				<input type="text" name="costprice" id="costprice"
					onblur="pricevalid()" class="form-control" placeholder="Cost price"
					aria-label="Cost price" value="${item.costprice}">
			</div>


			<div class="col ">
				<input class="form-control" type="file" id="image" name="image" >
			</div>

		</div>

		<div class="row">

			<div class="col-11 ">
				<textarea name="itemdesc" id="itemdesc" onblur="pricevalid()"
					class="form-control" placeholder="Desc" aria-label="message" value="${item.itemdesc}"></textarea>
			</div>

			<div class="col-1 align-self-end">
				<input name="Submit" type="submit" value="submit"
					class="btn btn-primary" />
			</div>
		</div>

	</form:form>
		</div>
	</div>


</body>
</html>

