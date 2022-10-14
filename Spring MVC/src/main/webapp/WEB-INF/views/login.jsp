
		<div class="row justify-content-center">
			

				<form method="post" action="userlogin.html"
					onsubmit="return formvalid()" commandName="user">
					<div class="form-floating mb-3">
						<input type="text" name="useremail" id="useremail"
							onblur="validname()" class="form-control" required> <label
							for="username">Email</label>

					</div>
					<div class="form-floating mb-3">
						<input type="password" name="password" id="password"
							onblur="validemail()" class="form-control" required> <label
							for="password">Password</label>

					</div>
					
					<input name="Submit" type="submit" value="submit" class="btn btn-primary" />
					
					
				</form>

			
		</div>

