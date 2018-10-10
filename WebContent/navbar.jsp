<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<%
session = request.getSession();
String a = (String)session.getAttribute("name");
%> 
<c:set var="VIMAL" value="vimal" />
<c:set var="USER" value="${sessionScope.name}" />
<c:set var="UID" value="${sessionScope.uid}" />
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
</body>
</html>