<html>
<body bgcolor = "yellow">
<form action="./jsp/deletesuccess1.jsp">
<h1><font color="red"><center>WARNING!!!!!!!!!!!!</center></font></h1></br>
<h2><center>Hello Mr/Ms.${param.nme}
Balance in Your Account is Rs.${requestScope.REMBALANCE}</center></h2>
<h2><center><font color="red">ALERT!!!!! 
If you Click on proceed your balance amount will not be refunded</font></center></h2>
<h1><center><input type="submit" value="DO YOU WANT TO PROCEED"/></center></h1>
</form>
</body>
</html>