<html>
<body bgcolor="wheat">
	<h1>
		<center>WELCOME TO STATE BANK OF INDIA</center>
	</h1>
	<h2>
		<center>UserName : ${sessionScope.USERNAME}</center>
	</h2>


	<form action="./balance.do" method="post">
		<div align="left">
			<input type="submit" value="BALANCE ENQUIRY" />
		</div>
	</form>

	<form action="./jsp/deposit.jsp" method="post">
		<div align="right">
			<input type="submit" value="DEPOSIT" />
		</div>
	</form>
	<form action="./jsp/transfer.jsp" method="post">
		<div align="left">
			<input type="submit" value="TRANSFER" />
		</div>
	</form>
	<form action="./jsp/withdraw.jsp" method="post">
		<div align="right">
			<input type="submit" value="WITHDRAW" />
		</div>
	</form>
	<form action="./ministatement.do" method="post">
		<div align="left">
			<input type="submit" value="MINI STATEMENT" />
		</div>
	</form>
	<form action="./jsp/delete.jsp" method="post">
		<div align="right">
			<input type="submit" value="DELETE" />
		</div>
	</form>
</body>
</html>