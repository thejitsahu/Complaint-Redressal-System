<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Management</title>
</head>
<body>
<%@include file="navbar.jsp" %><br />
<div class="container">
<input type="button" class="btn btn-primary" value="Add Engineer" onclick="window.location.href='add-engineer-form.jsp'; return false;" /><br /><br />
<table class="table table-striped table-hover">
	<tr>
		<th>EngineerID</th>
		<th>ComplaintID</th>
		<th>Name</th>
		<th>Action</th>
	</tr>
	<c:forEach var="temp" items="${ENGINEER_LIST}">
	<c:url var="tempLink" value="EngineerControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="engineerId" value="${temp.eId}" />
					</c:url>
					
					<c:url var="deleteLink" value="EngineerControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="engineerId" value="${temp.eId}" />
					</c:url>
	<tr>
		<td> ${temp.eId} </td>
		<td> ${temp.cId} </td>
		<td> ${temp.name} </td>
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