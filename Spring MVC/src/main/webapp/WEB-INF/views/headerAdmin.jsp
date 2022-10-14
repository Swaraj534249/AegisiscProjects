
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<script type="text/javascript">
	function headlogo() {

		var logo = document.getElementById("tenantid").value;
		var rolid = document.getElementById("roleid").value;

		//alert(logo);

		//headerlogo

		{
			document.getElementById("headerlogo").src = "images/${tenant.tenantid}.jpg";

		}

		if (rolid == 3) {
			document.getElementById("edittanent").style.visibility = "hidden";
			document.getElementById("uploadclient").style.visibility = "hidden";
			document.getElementById("manageuser").style.visibility = "hidden";

		}
	}
</script>

</head>

<body onload="headlogo()">



	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="/index.html">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="homeAdmin.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="itemlist.html">Products</a>
					</li>
					<!-- <li class="nav-item"><a class="nav-link" href="categorylist.html">Categories</a> -->
					</li>
					<li class="nav-item "><a class="nav-link " href="userlist.html">Users</a>
					</li>

				</ul>
				<ul class="navbar-nav me-0 mb-2 mb-lg-0">
					<li class="nav-item">
						<p class="nav-link">Welcome:${user.username}</p>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout.html">Logout</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>

	<div id="lavalamp"></div>