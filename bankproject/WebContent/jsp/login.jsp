<html>
<body bgcolor="skyblue">
	<h1>
		<center>Please Enter Your Login Details</center>
	</h1>
	<form action="./login.do" method="post">
		<table align="center">
			<tr>
				<td>Enter Your Name</td>
				<td><input type="text" name="nme" required="required"></td>
			</tr>
			<tr>
				<td>Enter Your Password</td>
				<td><input type="password" name="pwd" maxlength="8"></td>
			</tr>
			<tr>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>
</body>