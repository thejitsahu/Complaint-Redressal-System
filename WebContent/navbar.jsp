<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/dist/css/bootstrap-theme.min.css">
<script src="jquery-3.3.1.min.js"></script>
<script src="popper.min.js"></script>
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
    

</head>
<body>
<div class="container">
<c:set var="VIMAL" value="vimal" />
<c:set var="USER" value="${sessionScope.name}" />
<c:set var="UID" value="${sessionScope.uid}" />
<c:if test="${not empty USER}">
<h2>Complaint Management</h2>
<hr />
</c:if>
<c:choose>
<c:when test="${VIMAL eq USER}">
<a href="/complaint/HomeControllerServlet">Home</a>
<a href="/complaint/StudentControllerServlet">Products</a>
<a href="/complaint/ComplaintControllerServlet">Complaints</a>
<a href="/complaint/EngineerControllerServlet">Engineers</a>
<a href="/complaint/UserControllerServlet">Users</a>
<a href="/complaint/ReplacementControllerServlet">Replacements</a>
<a href="/complaint/LogoutServlet">Logout</a>
</c:when>
<c:when test="${empty USER}">
</c:when>
<c:otherwise>
<a href="/complaint/HomeControllerServlet">Home</a>
<a href="/complaint/StudentControllerServlet">Products</a>
<a href="/complaint/ComplaintControllerServlet">Complaints</a>
<c:url var="tempLink" value="UserControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="userId" value="${sessionScope.uid}" />
					</c:url>
<a href="${tempLink}">Update</a>	
<a href="/complaint/LogoutServlet">Logout</a>
</c:otherwise>
</c:choose>
</div>
</body>
</html>