<html>
<head>
<title>Update Product</title>
</head>
<body>
 <%@include file="navbar.jsp" %><br />
 <div class="container">
 <h3>Update Product</h3>
 
 <form action="StudentControllerServlet" class="form-horizontal" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theProductId" value="${THE_PRODUCT.serialId }" />
 <div class="row">
 <div class="col-2">
 <label><b>CustomerID</b></label>
 </div>
 <div class="col-5">
 <input type="text" class="form-control" name="cId" value="${THE_PRODUCT.cId}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2">
 <label><b>Name</b></label>
 </div>
 <div class="col-5">
 <input type="text" class="form-control" name="name" value="${THE_PRODUCT.name}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2"> 
 <label><b>Type</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="type" class="form-control" value="${THE_PRODUCT.type}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2"> 
 <label><b>Company</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="company" class="form-control" value="${THE_PRODUCT.company}"/>
 </div>
 </div><br />
 <div class="row">
 <div class="col-2"> 
 <label><b>Type</b></label>
 </div>
 <div class="col-5">
 <input type="text" name="warantyDate" class="form-control" value="${THE_PRODUCT.warantyDate}"/>
 </div>
 </div><br />
 
 <div class="row">
 <div class="col-8 mx-auto">
 <input type="submit" class="btn btn-primary" value="Save" />
 </div>
 </div>
 </form>
 <p>
 <a href="StudentControllerServlet">Back to List</a>
 </p>
 </div>
</body>
</html>