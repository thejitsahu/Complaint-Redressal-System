<html>
<head>
<title>Add Student</title>
</head>
<body>
 <h2>Complaint Tracker App</h2>
 <h3>Update Complaint</h3>
 <form action="ComplaintControllerServlet" method="GET">
 <input type="hidden" name = "command" value="UPDATE" />
 <input type="hidden" name = "theComplaintId" value="${THE_COMPLAINT.cId }" />
 <table>
 <tbody>
 <tr>
 <td><label>Details:</label></td>
 <td><input type="text" name="details" value="${THE_COMPLAINT.details}"/></td>
 </tr>
 <tr>
 <td><label>Status:</label></td>
 <td><input type="text" name="status" value="${THE_COMPLAINT.status}"/></td>
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