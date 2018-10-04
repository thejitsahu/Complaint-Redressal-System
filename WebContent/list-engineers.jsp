<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Tracker App</title>
</head>
<body>
<h2>Complaint Management</h2>
<input type="button" value="Add Engineer" onclick="window.location.href='add-engineer-form.jsp'; return false;" />
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
	</tr>
	<c:forEach var="temp" items="${ENGINEER_LIST}">
	<c:url var="tempLink" value="EngineerControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="engineerId" value="${temp.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="EngineerControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="engineerId" value="${temp.id}" />
					</c:url>
	<tr>
		<td> ${temp.id} </td>
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
</body>
</html>