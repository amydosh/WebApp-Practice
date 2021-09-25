<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response-Redirect</title>
</head>
<body>

<%
String office = request.getParameter("office");
if(office !=null){
	out.println("Value of Office obtained at: "+office+"<br>");
}else{
	out.println("No value of Office found<br>");
}
%>

</body>
</html>