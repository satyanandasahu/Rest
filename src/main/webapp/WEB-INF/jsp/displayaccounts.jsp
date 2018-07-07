<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2">
	<thead>
		<tr>
			<td>Account Number</td>
			<td>Name</td>
			<td>City</td>
			<td>Country</td>
			<td>Balance</td>
		</tr>
		
		<c:forEach items="${accountList}" var="account">
			<tr>
				<td>${account.accountNumber}</td>
				<td>${account.name}</td>
				<td>${account.city}</td>
				<td>${account.country}</td>
				<td>${account.balance}</td>
			</tr>
		</c:forEach>
	</thead>

</table>

</body>
</html>