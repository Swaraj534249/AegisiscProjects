

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("categoryname").value;
		if (n == "" || n == null) {
			document.getElementById("namereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("namereq").style.visibility = "hidden";
			return true;

		}
	}

	function pricevalid() {
		var n = document.getElementById("categorydesc").value;

		if (n == "" || n == null) {

			document.getElementById("pricereq").innerHTML = "Price can not be null*";
			document.getElementById("pricereq").style.visibility = "visible";
			return false;

		}

		else if (isNaN(n))

		{
			document.getElementById("pricereq").innerHTML = "Alphabatic character not allowed";

			document.getElementById("nopricereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("pricereq").style.visibility = "hidden";
			return true;

		}
	}

	function formvalid() {

		var nameresult = namevalid();
		var emailresult = pricevalid();

		if (nameresult == false || emailresult == false) {

			return false;
		} else {

			return true;
		}

	}
</script>


	<h2 align="center">Add Category</h2>
	<form method="post" action="insertcategory.html"
		onsubmit="return formvalid()" commandName="Category">
		<div class="row mb-3">
			<div class="col">
				<input type="text" name="categoryname" id="categoryname"
					onblur="namevalid()" class="form-control" placeholder="Category name"
					aria-label="Category name" required>
			</div>

			<div class="col">
				<input type="text" name="categorydesc" id="categorydesc"
					onblur="pricevalid()" class="form-control" placeholder="Category desc"
					aria-label="Category desc" required>
			</div>


			<div class="col-1 align-self-end">
				<input name="Submit" type="submit" value="submit"
					class="btn btn-primary" />
			</div>

		</div>


	</form>





