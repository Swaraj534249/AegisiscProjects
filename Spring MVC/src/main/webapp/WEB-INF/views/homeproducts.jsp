<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="" style="background-color: #EAEDED">
<div class=" text-center pt-3 ms-5 me-5">
		<div class="row mb-3">
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Screws </h4>
				<div class="row row-cols-2">
					<div class="col home-category-col" style=""  data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/screw.png" class="card-img-top" alt="...">
						<div>Screw-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/screw (1).png" class="card-img-top" alt="...">
						<div>Screw-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/screw (2).png" class="card-img-top" alt="...">
						<div>Screw-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/screw (3).png" class="card-img-top" alt="...">
						<div>Screw-4</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Tyre</h4>
				<div class="row row-cols-2 ">
					<div class="col home-category-col" style="" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/tyre.png" class="card-img-top" alt="...">
						<div>Tyre-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/tyre (1).png" class="card-img-top" alt="...">
						<div>Tyre-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/tyre (2).png" class="card-img-top" alt="...">
						<div>Tyre-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/tyre (3).png" class="card-img-top" alt="...">
						<div>Tyre-3</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Headlights</h4>
				<div class="row row-cols-2">
					<div class="col home-category-col" style="" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/headlight.png" class="card-img-top" alt="...">
						<div>Headlight-1</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/headlight (1).png" class="card-img-top" alt="...">
						<div>Headlight-2</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/headlight (2).png" class="card-img-top" alt="...">
						<div>Headlight-3</div>
					</div>
					<div class="col home-category-col" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/headlight (3).png" class="card-img-top" alt="...">
						<div>Headlight-4</div>
					</div>
				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse More</a>

			</div>
			<div
				class="col border border-2 ms-2 me-2 text-start p-3 home-category-card bg-white">
				<h4>Best deals</h4>
				<div class="row row-cols-1">
					<div class="col home-category-col" style="" data-bs-toggle="modal" data-bs-target="#loginModal">
						<img src="images/window.png" class="card-img-top" alt="...">
						<div>Premium</div>
					</div>


				</div>

				<a data-bs-toggle="modal" data-bs-target="#loginModal">Browse More</a>

			</div>
		</div>
	</div>
 
<section class="" >
  <div class=" shadow-sm bg-body p-4 ms-5 me-5 bg-white">
      <div class="carouselcard owl-carousel">
      <c:forEach items="${itemlist}" var="item">
          <div class="card">
              <div class="box p-2">
              <img src="images/about (3).png" class="card-img-top" alt="...">
                  <div class="head">
                    <h5 class="card-title">${item.itemname}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Category</h6>
                  </div>
                  <div class="box-content">
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                   <h6 class="card-subtitle mb-2">${item.itemprice}</h6>
                  </div>
                  <a class="buy" href="insertcart.html?itemId=${item.itemid}&username=${user.username}">Add to cart</a>
                  
              </div>
          </div>
          </c:forEach>
          
        
      </div>
  </div>
  </section>
  <br><br>
  
  
  
  </div>
  