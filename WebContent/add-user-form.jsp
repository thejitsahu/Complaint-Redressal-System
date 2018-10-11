<html>
<head>
<title>Add User</title>
</head>
<body>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Add User</h3>

 <form action="UserControllerServlet" method="POST">
 <input type="hidden" name="command" value="ADD" />
 <div class="row">
 <div class="col-2">
 <label><b>Name</b></label>
 </div>
 <div class="col-5">
 <input type="text"  class="form-control" name="name" />
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Email</b></label>
 </div>
 <div class="col-5">
 <input type="text"  class="form-control" name="email" />
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Password</b></label>
 </div>
 <div class="col-5">
 <input type="text"  class="form-control" name="passowrd1" />
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Confirm Passsword</b></label>
 </div>
 <div class="col-5">
 <input type="text"  class="form-control" name="password2" />
 </div>
 </div><br />
<div class="row">
 <div class="col-8 mx-auto">
 <input type="submit" class="btn btn-primary" value="Save" />
 </div>
 </div>
 </form>
 <p>
 <a href="UserControllerServlet">Back to List</a>
 </p>
 </div>
</body>
</html>