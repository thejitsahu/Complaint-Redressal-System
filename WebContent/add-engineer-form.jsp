<html>
<head>
<title>Add Engineer</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <h3>Add Engineer</h3>
 <form action="EngineerControllerServlet" method="POST">
 <input type="hidden" name = "command" value="ADD" />
 <table>
 <tbody>
 <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" /></td>
 </tr>
 <tr>
 <td><label></label></td>
 <td><input type="submit" value="Save" /></td>
 </tr>
 </tbody>
 </table>
 </form>
 <p>
 <a href="EngineerControllerServlet">Back to List</a>
 </p>
</body>
</html>