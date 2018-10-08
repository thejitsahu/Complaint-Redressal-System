<html>
<head>
<title>Add Product</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <h3>Add Replacement</h3>
 <%@include file="navbar.jsp" %><br />
 <form action="ReplacementControllerServlet" method="POST">
 <input type="hidden" name = "command" value="ADD" />
 <table>
 <tbody>
  <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" /></td>
 </tr>
 <tr>
 <td><label>Price:</label></td>
 <td><input type="text" name="price" /></td>
 </tr>
 <tr>
 <td><label></label></td>
 <td><input type="submit" value="Save" /></td>
 </tr>
 </tbody>
 </table>
 </form>
 <p>
 <a href="ReplacementControllerServlet">Back to List</a>
 </p>
</body>
</html>