<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Management</title>
</head>
<body>
<h2>Complaint Management</h2>
<%@include file="navbar.jsp" %><br />
<div class="container">

<table class="table table-striped table-hover">
	<tr>
		<th>ComplaintID</th>
		<th>Details</th>
		<th>Status</th>
		<th>SerialId</th>
		<th>Name</th>
		<th>Type</th>
		<th>Company</th>
		<th>WarantyDate</th>
		<th>Replacement</th>
		<th>Price</th>
		<th>Engineer</th>
	</tr>
	<c:forEach var="temp" items="${HOME_LIST}">
	<tr>
		<td>${temp.cid}</td>
		<td>${temp.details}</td>
		<td>${temp.status}</td>
		<td>${temp.serialId}</td>
		<td>${temp.name}</td>
		<td>${temp.type}</td>
		<td>${temp.company}</td>
		<td>${temp.warantyDate}</td>
		<td>${temp.rname}</td>
		<td>${temp.price}</td>
		<td>${temp.ename}</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>