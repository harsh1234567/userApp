<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<h1>User Registration:</h1>
	<form method="post" action="addServlet">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input name="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td />
				<td><input type="submit" value="Add" /></td>
		</table>
		
		<a href="showUser.html" >show users</a>
	</form>
</body>
</html>