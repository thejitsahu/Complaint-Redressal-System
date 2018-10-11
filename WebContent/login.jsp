<html>
<head>
<title>Login</title>
</head>
<body>
<%@include file="navbar.jsp" %><br />
<div class="container">
<h2><p class="text-center text-success">Complaint Management System</p></h2>
<hr />

<div class="col-6 mx-auto my-auto">
<div class="card card-block">
 <div class="card-header text-center bg-info"><b>Login</b></div>
 <p class="card-body">
 <form  action="LoginServlet" class="form-horizontal" method="GET">
<div class="row">
<div class="col-1 mx-auto">
<label><b>Username</b></label>
</div>
<div class="col-5 mx-auto">
<input type="text" class="form-control" autofocus name="username" />
</div>
</div><br />
<div class="row">
<div class="col-1 mx-auto">
<label><b>Password</b></label>
</div>
<div class="col-5 mx-auto">
<input type="password" class="form-control" name="password" />
</div>
</div><br />
<div class="row">
<div class="col-2 mx-auto">
<input type="submit" class="btn btn-primary" value="Login" />
</div>
</div>
</form>
<p class="text-center"><a href="/complaint/add-user-form.jsp">Register</a></p>
 </p>
 </div>
 </div>
 </div>
</body>
</html>

