
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<script type="text/javascript">
	function updatesuccess() {
		alert("Data has been successfully Updated");
	}
</script>

</head>
<body>
	<%@ include file="headerAdmin.jsp"%>
	&nbsp;&nbsp;

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<form:form method="post" action="editcurrentuser.html"
		onsubmit="updatesuccess()" commandName="user2">



		<table align="center"
			style="font-family: sans-serif; font-size: medium;" cellpadding="6"
			cellspacing="6">
			<tr>
				<td>User Name</td>
				<td><input name="username" type="text" value="${user.username}" />
				</td>
			</tr>
			<tr>
				<td>User Email</td>
				<td><input name="useremail" type="text"
					value="${user.useremail}" /></td>
			</tr>

			<tr>

				<td><input name="userid" type="hidden" value="${user.userid}" />
				</td>
			</tr>

			

			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="Submit" /></td>
			</tr>


		</table>
	</form:form>
	
	
</body>
</html>