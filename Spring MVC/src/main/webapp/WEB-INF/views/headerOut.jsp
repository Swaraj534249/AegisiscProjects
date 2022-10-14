
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="/index.html">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.html">Home</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="#">Shop</a></li>
				<li class="nav-item"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#contactModal">Contact</a></li>
			</ul>
			<ul class="navbar-nav me-0 mb-2 mb-lg-0">

				<!--  <li class="nav-item"><a class="nav-link" href="login.html">Login</a>
				</li>  
				<li class="nav-item"><a class="nav-link" href="newUser.html">Signin</a>
				</li> -->
				<li><a  class="btn btn-primary position-relative me-3"
						data-bs-toggle="modal" data-bs-target="#loginModal">
						Login<span class="position-absolute top-0 start-100 translate-middle badge border border-light rounded-circle bg-danger p-2"><span class="visually-hidden">unread messages</span></span></a></li>
				<li><a  class="btn border border-1 rounded-pill"
						data-bs-toggle="modal" data-bs-target="#signinModal">
						Signin</a></li>
			</ul>
		</div>
	</div>
</nav>


<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1"
	aria-labelledby="loginModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="loginModalLabel">Login Form</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div><%@ include file="login.jsp"%></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#signinModal">Register</button>
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="signinModal" tabindex="-1"
	aria-labelledby="signinModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="signinModalLabel">Signin Form</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div><%@ include file="signin.jsp"%></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="contactModal" tabindex="-1"
	aria-labelledby="contactModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="contactModalLabel">Contact Form</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div><%@ include file="contact.jsp"%></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>



<div id="lavalamp"></div>