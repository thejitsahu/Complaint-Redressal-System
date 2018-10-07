<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Tracker App</title>
</head>
<body>
<h2>Complaint Management</h2>
<%@include file="navbar.html" %><br />
<input type="button" value="Add Complaint" onclick="window.location.href='add-complaint-form.jsp'; return false;" />
<table>
	<tr>
		<th>ComplaintID</th>
		<th>Details</th>
		<th>Status</th>
	</tr>
	<c:forEach var="temp" items="${COMPLAINT_LIST}">
	<c:url var="tempLink" value="ComplaintControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="complaintId" value="${temp.cId}" />
					</c:url>
					
					<c:url var="deleteLink" value="ComplaintControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="complaintId" value="${temp.cId}" />
					</c:url>
	<tr>
		<td> ${temp.cId} </td>
		<td> ${temp.details} </td>
		<td> ${temp.status} </td>
		<td> 
							<a href="${tempLink}">Update</a> 
							|
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
						</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>