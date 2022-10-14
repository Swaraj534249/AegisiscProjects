
<script type="text/javascript">
	function validname() {
		var a = document.getElementById("username").value;
		if (a == "" || a == null) {
			document.getElementById("namerequired").style.visibility = "visible";
			return false;
		}

		document.getElementById("namerequired").style.visibility = "hidden";
		return true;
	}

	function validemail() {
		var a = document.getElementById("useremail").value;
		if (a == "" || a == null) {
			document.getElementById("emailrequired").style.visibility = "visible";
			return false;
		}

		document.getElementById("emailrequired").style.visibility = "hidden";
		return true;
	}

	function formvalid() {
		var a = document.getElementById("username").value;
		if (a == "" || a == null) {
			document.getElementById("namerequired").style.visibility = "visible";

		}
		var b = document.getElementById("useremail").value;
		if (b == "" || b == null) {
			document.getElementById("emailrequired").style.visibility = "visible";

			return false;
		}

	}
</script>


		<div class="row justify-content-center">

				<form method="post" action="userregistrationsuccess.html"
					onsubmit="return formvalid()" commandName="user">
					<div class="form-floating mb-3">
						<input type="text" name="username" id="username"
							onblur="validname()" class="form-control" required> <label
							for="username">First Name</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="text" name="userlastname" id="userlastname"
							onblur="validname()" class="form-control" required> <label
							for="userlastname">Last Name</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="text" name="dob" id="dob"
							 class="form-control" required> <label
							for="dob">DOB</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="email" name="useremail" id="useremail"
							onblur="validemail()" class="form-control" required> <label
							for="useremail">Email address</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="text" name="usercontactno" id="usercontactno"
							 class="form-control" required> <label
							for="usercontactno">Number</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="text" name="useraddress" id="useraddress"
							 class="form-control" required> <label
							for="useraddress">Address</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="text" name="balance" id="balance"
							 class="form-control" required> <label
							for="balance">Budget</label>

					</div>
					
					<div class="form-floating mb-3">
						<input type="password" name="password" id="password"
							onblur="validemail()" class="form-control" required> <label
							for="password">Password</label>

					</div>

					<input name="Submit" type="submit" value="submit" class="btn btn-primary" />
					<input name="reset" type="reset" value="reset" class="btn btn-secondary" />

				</form>

		</div>


