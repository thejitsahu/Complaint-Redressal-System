<html>
<head>
<title>Update Complaint</title>
</head>
<body>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Update Complaint</h3>
 <form action="ComplaintControllerServlet" class="form-horizontal" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theComplaintId" value="${THE_COMPLAINT.cId }" />
 <div class="row">
 <div class="col-2">
 <label><b>Details</b></label>
 </div>
 <div class="col-5">
 <input type="text" class="form-control" name="details" value="${THE_COMPLAINT.details}"/></td>
 </div>
 </div><br />
<c:set var="VIMAL" value="vimal" />
<c:set var="USER" value="${sessionScope.name}" />
<c:choose>
<c:when test="${VIMAL eq USER}">
<div class="row">
<div class="col-2">
<label><b>Status</b></label>
</div>
<div class="col-5">
 <input type="text" name="status" class="form-control" value="${THE_COMPLAINT.status}"/>
 </div>
 </div><br />
 </c:when>
 </c:choose>
 <div class="row">
 <div class="col-8 mx-auto">
 <input type="submit" class="btn btn-primary" value="Save" />
 </div>
 </div>
 </form>
 <p>
 <a href="ComplaintControllerServlet">Back to List</a>
 </p>
 </div>
</body>
</html>
