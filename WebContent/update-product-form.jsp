<html>
<head>
<title>Add Student</title>
</head>
<body>
 <h2>FooBar University</h2>
 <h3>Update Student</h3>
 <form action="StudentControllerServlet" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theProductId" value="${THE_PRODUCT.serialId }" />
 <table>
 <tbody>
 <tr>
 <td><label>Name:</label></td>
 <td><input type="text" name="name" value="${THE_PRODUCT.name}"/></td>
 </tr>
 <tr>
 <td><label>Type:</label></td>
 <td><input type="text" name="type" value="${THE_PRODUCT.type}"/></td>
 </tr>
 <tr>
 <td><label>Company:</label></td>
 <td><input type="text" name="company" value="${THE_PRODUCT.company}"/></td>
 </tr>
 <tr>
 <td><label>Waranty Date:</label></td>
 <td><input type="text" name="warantyDate" value="${THE_PRODUCT.warantyDate}"/></td>
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