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
	out.println("<b>Your session has expired or is invalid.</b><br>");
}
%>

<form action="login.jsp" method="post">
	Name<input type="text" name="name" id="name" maxlength=40><br>
	Password<input type="password" name="pwd" id="pwd" maxlength=10><br>
	<button type="submit">Submit</button>
</form>

<% 
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	if(name == null || name.equals("") || pwd == null || pwd.equals("")){
		response.sendRedirect("index.jsp?error=1");
	} else{
		session.setAttribute("name",name);
		response.sendRedirect("dashboard.jsp");
	}

%>

</body>
</html>