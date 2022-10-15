<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>




<div class="" style="background-color: #f4f4f4">
	<div class="row text-center pt-2 mb-2 ms-3 me-3">
	<h4>For Testing purpose you can</h4>
		<div class="col"></div>
		<div class="col">
			<a class="btn btn-primary btn-lg" href="customerregistrationsuccess.html">Login
				as customer</a>
		</div>

		<div class="col">
			<a class="btn btn-primary btn-lg" href="sellerregistrationsuccess.html">Login
				as seller</a>
		</div>
		<div class="col"></div>
	</div>
	<div class=" text-center pt-3 ms-5 me-5">
		<div class="row mb-3">
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Screws</h4>
				<div class="row row-cols-2">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw.png" class="card-img-top" alt="...">
						<div>Screw-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw (1).png" class="card-img-top" alt="...">
						<div>Screw-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw (2).png" class="card-img-top" alt="...">
						<div>Screw-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw (3).png" class="card-img-top" alt="...">
						<div>Screw-4</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Tyre</h4>
				<div class="row row-cols-2 ">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre.png" class="card-img-top" alt="...">
						<div>Tyre-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre (1).png" class="card-img-top" alt="...">
						<div>Tyre-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre (2).png" class="card-img-top" alt="...">
						<div>Tyre-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre (3).png" class="card-img-top" alt="...">
						<div>Tyre-3</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Headlights</h4>
				<div class="row row-cols-2">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight.png" class="card-img-top" alt="...">
						<div>Headlight-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight (1).png" class="card-img-top" alt="...">
						<div>Headlight-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight (2).png" class="card-img-top" alt="...">
						<div>Headlight-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight (3).png" class="card-img-top" alt="...">
						<div>Headlight-4</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Best deals</h4>
				<div class="row row-cols-1">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/window.png" class="card-img-top" alt="...">
						<div>Premium</div>
					</div>


				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
		</div>
		<div class="row">
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Todays Deal</h4>
				<div class="row row-cols-2">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight.png" class="card-img-top" alt="...">
						<div>Headlight-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight (1).png" class="card-img-top" alt="...">
						<div>Headlight-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight (2).png" class="card-img-top" alt="...">
						<div>Headlight-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/headlight (3).png" class="card-img-top" alt="...">
						<div>Headlight-4</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Best seller</h4>
				<div class="row row-cols-2 ">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw.png" class="card-img-top" alt="...">
						<div>Screw-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw (1).png" class="card-img-top" alt="...">
						<div>Screw-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw (2).png" class="card-img-top" alt="...">
						<div>Screw-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/screw (3).png" class="card-img-top" alt="...">
						<div>Screw-4</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Discounts</h4>
				<div class="row row-cols-2">
					<div class="col home-category-col" style="" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre.png" class="card-img-top" alt="...">
						<div>Tyre-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre (1).png" class="card-img-top" alt="...">
						<div>Tyre-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre (2).png" class="card-img-top" alt="...">
						<div>Tyre-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal"
						data-bs-target="#loginModal">
						<img src="images/tyre (3).png" class="card-img-top" alt="...">
						<div>Tyre-3</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse
					More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>SignIn to get more offers</h4>
				<div class="row row-cols-1"></div>
				<button class="btn btn-warning" data-bs-toggle="modal"
					data-bs-target="#signinModal">SignIn</button>


			</div>
		</div>
	</div>


	<br>

	<div class="container mt-4">
		<h2 align="center">About Us</h2>
		<div class="row align-items-center mt-3">
			<div class="col-8 ">
				<h2>One of three columns</h2>
				<p>Some great placeholder content for the first featurette here.
					Imagine some exciting prose here.</p>
			</div>
			<div class="col">
				<img src="images/about.png" class="d-block w-100" alt="...">
			</div>
		</div>
		<hr>

		<div class="row align-items-center">
			<div class="col">
				<img src="images/about (2).png" class="d-block w-100" alt="...">
			</div>
			<div class="col-8 ">
				<h2>One of three columns</h2>
				<p>Some great placeholder content for the first featurette here.
					Imagine some exciting prose here.</p>
			</div>

		</div>
		<hr>

		<div class="row align-items-center">
			<div class="col-8 ">
				<h2>One of three columns</h2>
				<p>Some great placeholder content for the first featurette here.
					Imagine some exciting prose here.</p>
			</div>
			<div class="col">
				<img src="images/about (1).png" class="d-block w-100" alt="...">
			</div>
		</div>

	</div>

	<br> <br>

	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/aegisisc" user="root" password="root" />

	<sql:query dataSource="${snapshot}" var="result">
         SELECT * from Item;
      </sql:query>

	<div class=" text-center pt-3 ms-5 me-5">
		<h2 align="center">Products List</h2>
		<p align="center">Login to see details</p>
		<div class="row row-cols-auto justify-content-between">
			<c:forEach var="row" items="${result.rows}">
				<div class="col me-2 ms-2 w-20 p-0 user-cardindex">
					<div class="border border-1 ">
						<img src="images/about (3).png" class="card-img-top" alt="...">
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<h4>${row.itemname}</h4>
								<h6 class="text-muted">${row.itemprice}</h6>
								<h6 class="text-muted">${row.date}</h6>

							</div>

						</div>


					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<br> <br>
</div>




