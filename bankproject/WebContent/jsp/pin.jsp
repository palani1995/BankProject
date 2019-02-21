<html>
<body bgcolor="blue">
	<h1>
		<center>Welcome ${param.nme}to SBI</center>
	</h1>
	<form action="./pin.do" method="post">
		<table align="center">
			<tr>
				<td>Enter PIN <input type="password" name="pin" maxlength="4"></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="SUBMIT"></td>

			</tr>
		</table>
	</form>
</body>
</html>