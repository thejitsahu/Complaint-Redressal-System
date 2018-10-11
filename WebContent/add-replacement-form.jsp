<html>
<head>
<title>Add Replacement</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Add Replacement</h3>
 
 <form action="ReplacementControllerServlet" class="form-horizontal" method="POST">
 <input type="hidden" name = "command" value="ADD" />
 <div class="row">
 <div class="col-2">
 <label><b>Name</b></label>
 </div>
 <div class="col-5">
 <input type="text" class="form-control" name="name" />
 </div>
</div><br />
<div class="row">
<div class="col-2">
<label><b>Price</b></label>
</div>
<div class="col-5">
<input type="text" class="form-control" name="price" />
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