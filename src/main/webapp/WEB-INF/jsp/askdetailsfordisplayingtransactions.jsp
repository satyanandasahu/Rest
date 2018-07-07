<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>

<title>Enter Details</title>
</head>
<body>
	<img alt="Logo" src="images/Logo.png">
	<form action="displaytransactions">
		Account Number <input type="text" name="accountNumber" /> <br/>
		From Date <input type="text" name="fromDate" /> <br/>
		<input type="submit" value="GET Transactions" />
	</form>

</body>
</html>