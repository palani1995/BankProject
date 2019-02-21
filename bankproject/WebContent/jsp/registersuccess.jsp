<html>
<body style="background-color: turquoise;">
	<img align="middle" src="./images/sbm.jpg" height="200" width="200" />
	</div>
	<form action="./loginhome.do">

		<font color="deeppink" size="6"><marquee>
				WELCOME TO STATE BANK OF INDIA</b>
			</marquee></font> <font color="Navy" size="5" style="margin: 3cm;"><u><b>
					Hai ${sessionScope.FIRSTNAME} ${sessionScope.LASTNAME} Account
					Details:</b></u></font> </br> </br>
		<table align="left" border="0" style="margin-left: 3cm">
			<col width="800">
			<col width="1300">
			<tr>
				<td><font color="Navy" size="4">ACCOUNT NUMBER</font></td>
				<td><font color="Navy" size="4">${requestScope.ACCNO}</font></td>
			</tr>

			<tr>
				<td><font color="Navy" size="4">PIN NUMBER</font></td>
				<td><font color="Navy" size="4">${requestScope.PIN}</font></td>
			</tr>

			<tr>
				<td><font color="Navy" size="4">AMOUNT</font></td>
				<td><font color="Navy" size="4">${requestScope.REMBALANCE}</font></td>
			</tr>

			<tr>
				<td><input type="submit" value="SIGN IN "></td>
			</tr>


		</table>
	</form>
</body>
</html>