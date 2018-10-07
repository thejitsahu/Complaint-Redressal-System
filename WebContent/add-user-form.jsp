<html>
<head>
<title>Add Product</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <h3>Add User</h3>
 <%@include file="navbar.html" %><br />
 <form action="UserControllerServlet" method="POST">
 <input type="hidden" name="command" value="ADD" />
 <table>
 <tbody>
 <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" /></td>
 </tr>
 <tr>
 <td><label>Email:</label></td>
 <td><input type="text" name="email" /></td>
 </tr>
 <tr>
 <td><label>Password:</label></td>
 <td><input type="password" name="password1" /></td>
 </tr>
 <tr>
 <td><label>Confirm Password:</label></td>
 <td><input type="password" name="password2" /></td>
 </tr>
 <tr>
 <td><label></label></td>
 <td><input type="submit" value="Save" /></td>
 </tr>
 </tbody>
 </table>
 </form>
 <p>
 <a href="UserControllerServlet">Back to List</a>
 </p>
</body>
</html>