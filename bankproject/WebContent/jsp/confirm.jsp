<html>
<body bgcolor="yellow">
	<h1>
		<center>Please Verify</center>
	</h1>
	<form action="./confirmhome.do">
		<table border="2" align="center">
			<tr>
				<td>UserName</td>
				<td>${sessionScope.USERNAME}</td>
			</tr>

			<tr>
				<td>Destination Account</td>
				<td>${param.dacc}</td>
			</tr>

			<tr>
				<td>Amount to be transfered</td>
				<td>${param.amt}</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="CONFIRM" /></td>
			</tr>
		</table>
	</form>

	<form action="./jsp/transfer.jsp">
		<center>
			<input type="submit" value="GO BACK" />
		</center>
	</form>
</body>
</html>