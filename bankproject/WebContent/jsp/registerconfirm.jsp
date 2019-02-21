<html>
<body style="background-color: mediumorchid;">
	<div
		style="display: table-cell; vertical-align: middle; text-align: center">
		<img align="middle" src="./images/sbm.jpg" height="200" width="200" />
	</div>
	<font color="deeppink"><h1>
			<marquee>
				<b>STATE BANK OF INDIA</b>
			</marquee>
		</h1></font>

	<form action="./newuserregistration.do">

		<font color="Navy" size="5" style="margin: 3cm;"><u><b>Confirm
					Details:</b></u></font>
		<table align="left" border="0" style="margin-left: 3cm">
			<col width="800">
			<col width="1300">
			<tr>
				<td><font size="5" color="mediumblue">FirstName:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.FIRSTNAME}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">LastName:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.LASTNAME}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">UserName:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.USERNAME}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Age:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.AGE}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Date of Birth:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.DOB}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Gender:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.GENDER}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Address:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.ADDRESS}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">City:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.CITY}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">State:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.STATE}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Pincode:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.PINCODE}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Phone no:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.PHONE}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Alternative phone
						no:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.APHONE}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Email:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.EMAIL}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Favourite Teacher:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.FAVTEACHER}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">Favourite Pet:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.FAVPET}</font></td>
			</tr>
			<tr>
				<td><font size="5" color="mediumblue">First School Name:</font></td>
				<td><font size="5" color="mediumblue">${sessionScope.FIRSTSCHOOL}</font></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="CONFIRM" /></td>
			</tr>
		</table>
	</form>
</body>
</html>