<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Complaint Tracker App</title>
</head>
<body>
<h2>Complaint Management</h2>
<%@include file="navbar.jsp" %><br />
<div class="container">
<input type="button" class="btn btn-primary text-right" value="Add Product" onclick="window.location.href='add-product-form.jsp'; return false;" /><br /><br />
<table class="table table-striped table-hover">
	<tr>
		<th>SerialID</th>
		<th>ComplaintID</th>
		<th>Name</th>
		<th>Type</th>
		<th>Company</th>
		<th>Waranty Date</th>
		<th>Action</th>
	</tr>
	<c:forEach var="temp" items="${PRODUCT_LIST}">
	<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="productId" value="${temp.serialId}" />
					</c:url>
					
					<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="productId" value="${temp.serialId}" />
					</c:url>
	<tr>
		<td> ${temp.serialId} </td>
		<td> ${temp.cId} </td>
		<td> ${temp.name} </td>
		<td> ${temp.type} </td>
		<td> ${temp.company} </td>
		<td> ${temp.warantyDate} </td>
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