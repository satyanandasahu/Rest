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
			<td>Transaction ID</td>
			<td>Transaction Date</td>
			<td>Amount</td>
			<td>Transaction Type</td>
		</tr>
		
		<c:forEach items="${transactiondetails}" var="transactiondetail">
			<tr>
				<td>${transactiondetail.transactionId}</td>
				<td>${transactiondetail.transactionDate}</td>
				<td>${transactiondetail.amount}</td>
				<td>${transactiondetail.txType}</td>
			</tr>
		</c:forEach>
	</thead>

</table>

</body>
</html>