<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Tracker App</title>
</head>
<body>
<h2>Complaint Management</h2>
<input type="button" value="Add Replacement" onclick="window.location.href='add-replacement-form.jsp'; return false;" />
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		
	</tr>
	<c:forEach var="temp" items="${REPLACEMENT_LIST}">
	<c:url var="tempLink" value="ReplacementControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="replacementId" value="${temp.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="ReplacementControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="replacementId" value="${temp.id}" />
					</c:url>
	<tr>
		<td> ${temp.id} </td>
		<td> ${temp.name} </td>
		<td> ${temp.price} </td>
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