<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<%
if(request.getParameter("error")!= null){
	out.println("<b>You must be logged in to view the Admin pages.</b><br>");
}
%>

<br>
<b> To create a new admin user account, please click 
<a href="admin/CreateAdmin.html">here. </a></b><br><br>
	
<form method="post" action="adminAuth">
<br>
	Please enter admin username: <br>
	<input type="text" name="adminUN">
	<br>
	
	Please enter the admin password: <br>
	<input type="password" name="adminPass">
	<br>

	<button type="submit"> Send </button>
</form>






</body>
</html>