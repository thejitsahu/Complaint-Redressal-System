<html>
<head>
<title>Add Product</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <h3>Add Product</h3>
 <%@include file="navbar.html" %><br />
 <form action="StudentControllerServlet" method="POST">
 <input type="hidden" name = "command" value="ADD" />
 <table>
 <tbody>
 <tr>
 <td><label>SerialID:</label></td>
 <td><input type="text" name="serialId" /></td>
 </tr>
 <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" /></td>
 </tr>
 <tr>
 <td><label>Type</label></td>
 <td><input type="text" name="type" /></td>
 </tr>
 <tr>
 <td><label>Company:</label></td>
 <td><input type="text" name="company" /></td>
 </tr>
 <tr>
 <td><label>Waranty Date:</label></td>
 <td><input type="text" name="warantyDate" /></td>
 </tr>
 <tr>
 <td><label></label></td>
 <td><input type="submit" value="Save" /></td>
 </tr>
 </tbody>
 </table>
 </form>
 <p>
 <a href="StudentControllerServlet">Back to List</a>
 </p>
</body>
</html>