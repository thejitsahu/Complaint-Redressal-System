<html>
<head>
<title>Update Replacement</title>
</head>
<body>
 <h2>Complaint Management</h2>
 <h3>Update Replacement</h3>
 <%@include file="navbar.html" %><br />
 <form action="ReplacementControllerServlet" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theReplacementId" value="${THE_REPLACEMENT.id}" />
 <table>
 <tbody>
 <tr>
 <td><label>CustomerID:</label></td>
 <td><input type="text" name="theComplaintId" value="${THE_REPLACEMENT.cId}"/></td>
 </tr>
 <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" value="${THE_REPLACEMENT.name}"/></td>
 </tr>
 <tr>
 <td><label>Price:</label></td>
 <td><input type="text" name="price" value="${THE_REPLACEMENT.price}"/></td>
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