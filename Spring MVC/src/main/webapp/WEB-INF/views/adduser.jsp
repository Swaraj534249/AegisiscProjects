

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("itemname").value;
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
		var n = document.getElementById("itemprice").value;

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


	<h2 align="center">Add Item</h2>
	<form method="post" action="insertitem.html"
		onsubmit="return formvalid()" commandName="Item">
		<div class="row mb-3">
			<div class="col">
				<input type="text" name="itemname" id="itemname"
					onblur="namevalid()" class="form-control" placeholder="Item name"
					aria-label="Item name" required>
			</div>

			<div class="col">
				<input type="text" name="itemprice" id="itemprice"
					onblur="pricevalid()" class="form-control" placeholder="Item price"
					aria-label="Item price" required>
			</div>


			<div class="col ">
				<input class="form-control" type="file" id="formFile">
			</div>

		</div>

		<div class="row">

			<div class="col-11 ">
				<textarea name="itemdesc" id="itemdesc" onblur="pricevalid()"
					class="form-control" placeholder="message" aria-label="message"></textarea>
			</div>

			<div class="col-1 align-self-end">
				<input name="Submit" type="submit" value="submit"
					class="btn btn-primary" />
			</div>
		</div>

	</form>





