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
<input type="button" class="btn btn-primary" value="Add Replacement" onclick="window.location.href='add-replacement-form.jsp'; return false;" /><br /><br />
<table class="table table-striped table-hover">
	<tr>
		<th>ID</th>
		<th>ComplaintID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Action</th>
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
		<td>${temp.cId }</td>
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
</div>
</body>
</html>