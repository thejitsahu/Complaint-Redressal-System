<html>
<head>
<title>Add Product</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Add Product</h3>
 
 <form action="StudentControllerServlet" class="form-horizontal" method="POST">
 <input type="hidden" name = "command" value="ADD" />
 <div class="row">
 <div class="col-2">
 <label><b>SerialID</b></label>
 </div>
 <div class="col-6">
 <input type="text" class="form-control" name="serialId" />
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
  <label><b>Name</b></label>
  </div>
  <div class="col-6">
 <input type="text" class="form-control" name="name" />
 </div>
 </div><br />
  <div class="row">
 <div class="col-2">
  <label><b>Type</b></label>
  </div>
  <div class="col-6">
 <input type="text" class="form-control" name="type" />
 </div>
 </div><br />
  <div class="row">
 <div class="col-2">
  <label><b>Company</b></label>
  </div>
  <div class="col-6">
 <input type="text" class="form-control" name="company" />
 </div>
 </div><br />
  <div class="row">
 <div class="col-2">
  <label><b>WarantyDate</b></label>
  </div>
  <div class="col-6">
 <input type="text" class="form-control" name="warantyDate" />
 </div>
 </div><br />
<div class="row">
 <div class="col-8 mx-auto">
 <input type="submit" class="btn btn-primary" value="Save" />
 </div>
 </div><br />
 </form>
 <p>
 <a href="StudentControllerServlet">Back to List</a>
 </p>
 </div>
</body>
</html>