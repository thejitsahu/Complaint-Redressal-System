<html>
<head>
<title>Update Engineer</title>
</head>
<body>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Update Engineer</h3>
 <form action="EngineerControllerServlet" class="form-horizontal" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theEngineerId" value="${THE_ENGINEER.eId }" />
 <div class="row">
 <div class="col-2">
 <label><b>CustomerID</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="cId" class="form-control" value="${THE_ENGINEER.cId}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Name</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="name" class="form-control" value="${THE_ENGINEER.name}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-8 mx-auto">
 <input type="submit" class="btn btn-primary" value="Save" />
 </div>
 </div>
 </form>
 <p>
 <a href="EngineerControllerServlet">Back to List</a>
 </p>
 </div>
</body>
</html>