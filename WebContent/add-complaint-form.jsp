<html>
<head>
<title>Add Complaint</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Add Complaint</h3>
 <form action="ComplaintControllerServlet" class="form-horizontal" method="POST">
 <input type="hidden" name = "command" value="ADD" />
<div class="row">
<div class="col-2">
<label for="det"><b></>Details</b>  </label>  
</div>
<div class="col-5">
<input type="text" id="det" class="form-control" placeholder="details" name="details" /> 
</div>
</div><br />
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