<html>
<head>
<title>Update Replacement</title>
</head>
<body>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Update Replacement</h3>

 <form action="ReplacementControllerServlet" class="form-horizontal" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theReplacementId" value="${THE_REPLACEMENT.id}" />
<div class="row">
<div class="col-2">	
<label><b>CustomerID</b></label>
</div>
<div class="col-5">
 <input type="text" name="theComplaintId" class="form-control" value="${THE_REPLACEMENT.cId}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Name</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="name" class="form-control" value="${THE_REPLACEMENT.name}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Price</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="price" class="form-control" value="${THE_REPLACEMENT.price}"/>
 </div>
 </div><br />
<div class="row">
 <div class="col-8 mx-auto">
 <input type="submit" class="btn btn-primary" value="Save" />
 </div>
 </div>
 </form>
 <p>
 <a href="ReplacementControllerServlet">Back to List</a>
 </p>
 </div>
</body>
</html>