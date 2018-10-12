<html>
<head>
<title>Update User</title>
</head>
<body>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Update User</h3>
 <form action="UserControllerServlet" class="form-horizontal" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theUserId" value="${THE_USER.id }" />
 <div class="row">
 <div class="col-2">
 <label><b>Username</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="username" class="form-control" value="${THE_USER.username}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Email</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="email" class="form-control" value="${THE_USER.email}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Password</b></label>
 </div>
 <div class="col-5">
 <input type="password" name="password" class="form-control" value="${THE_USER.password}"/>
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