<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="handle-error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Implicit Objects</title>
</head>
<body>

<%
String responseCheck = request.getParameter("office");
if(responseCheck !=null){
	response.setStatus(response.SC_MOVED_PERMANENTLY);
	response.setHeader("Location","response-redirect.jsp?office="+responseCheck);
}

String errorCheck = request.getParameter("error");
if(errorCheck !=null) {
	int x=0;
	if(x==0){
		throw new RuntimeException("Exception has been raised");
	}
}
%>

<%
int serverPort = request.getServerPort();
out.println("The server is running on port: "+String.valueOf(serverPort)+"<br>");
out.println("The server name is: "+config.getServletName() +"<br>");
out.println("Servlet info: "+application.getServerInfo()+"<br>");

String pageName = page.toString();
out.println("The name of the page is "+pageName+"<br>");

pageContext.setAttribute("userid","John Doe");
out.println("User ID attribute from pageContext: "+pageContext.getAttribute("userid")+"<br>");
%>

<a href="index.jsp?office=head_office">Show usage of response object</a><br>
<a href="index.jsp?error=1">Show usage of error object</a>

<%
if(response.containsHeader("Office")){
	out.println("Current location is "+response.getHeader("Office"));
}
%>

</body>
</html>