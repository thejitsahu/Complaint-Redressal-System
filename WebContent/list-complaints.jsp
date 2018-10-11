<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Management</title>
</head>
<body>
<%@include file="navbar.jsp" %><br />
<div class="container">
<input type="button" class="btn btn-primary" value="Add Complaint" onclick="window.location.href='add-complaint-form.jsp'; return false;" /><br /><br />
<table class="table table-striped table-hover">
	<tr>
		<th>ComplaintID</th>
		<th>Details</th>
		<th>Status</th>
		<th>Action</th>
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
</div>
</body>
</html>