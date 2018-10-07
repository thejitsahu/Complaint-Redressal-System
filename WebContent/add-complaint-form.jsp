<html>
<head>
<title>Add Complaint</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <h3>Add Complaint</h3>
 <%@include file="navbar.html" %><br />
 <form action="ComplaintControllerServlet" method="POST">
 <input type="hidden" name = "command" value="ADD" />
 <table>
 <tbody>
 <tr>
 <td><label>Details:</label></td>
 <td><input type="text" name="details" /></td>
 </tr>
 <tr>
 <td><label></label></td>
 <td><input type="submit" value="Save" /></td>
 </tr>
 </tbody>
 </table>
 </form>
 <p>
 <a href="ComplaintControllerServlet">Back to List</a>
 </p>
</body>
</html>