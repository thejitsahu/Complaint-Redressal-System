<html>
<head>
<title>Add Student</title>
</head>
<body>
 <h2>Complaint Tracker App</h2>
 <h3>Update User</h3>
 <form action="UserControllerServlet" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theUserId" value="${THE_USER.id }" />
 <table>
 <tbody>
 <tr>
 <td><label>Username:</label></td>
 <td><input type="text" name="username" value="${THE_USER.name}"/></td>
 </tr>
 <tr>
 <td><label>Email:</label></td>
 <td><input type="text" name="email" value="${THE_USER.email}"/></td>
 </tr>
 <tr>
 <td><label>Password:</label></td>
 <td><input type="password" name="password" value="${THE_USER.password}"/></td>
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