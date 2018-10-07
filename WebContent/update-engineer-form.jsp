<html>
<head>
<title>Add Student</title>
</head>
<body>
 <h2>FooBar University</h2>
 <h3>Update Student</h3>
 <%@include file="navbar.html" %><br />
 <form action="EngineerControllerServlet" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theEngineerId" value="${THE_ENGINEER.eId }" />
 <table>
 <tbody>
 <tr>
 <td><label>CustomerID:</label></td>
 <td><input type="text" name="cId" value="${THE_ENGINEER.cId}"/></td>
 </tr>

 <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" value="${THE_ENGINEER.name}"/></td>
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