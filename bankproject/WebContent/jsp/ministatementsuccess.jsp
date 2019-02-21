<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body style="background-color: turquoise;">
	<img align="middle" src="./images/sbm.jpg" height="200" width="200" />
	</div>
	<form action="./loginhome.do">
		<font color="deeppink" size="6"><center>
				<h1>
					<b>STATE BANK OF INDIA</b>
				</h1>
			</center></font>
		<table align="left" border="0" style="margin-left: 5cm">
			<col width="200">
			<col width="400">
			<tr>
				<td><font color="Navy" size="4"><b>Account No-------</b></font></td>
				<td align="left"><font color="Navy" size="4"><b>${requestScope.ACCNO}</b></font></td>
			</tr>

			<c:forEach var="minist" items="${MINISTLIST}">
				<tr>
					<td><font color="Navy" size="4">${minist.dateandtime}</font></td>
					</br>
					<td><font color="Navy" size="4">${minist.transactionamount}</font></td>
					</br>
				</tr>
			</c:forEach>
			<tr>
				<td><font color="Navy" size="4"><b>Available
							Balance-------</b></font></td>
				<td colspan="2" align="left"><b>${requestScope.REMBALANCE}</b></font></td>
				</br>
			</tr>

			<tr>
				<td colspan="2"><jsp:include page="gobackpage.jsp"></jsp:include></td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="logoutbackpage.jsp"></jsp:include></td>
			</tr>

		</table>
	</form>
</body>
</html>