<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Handle Error</title>
</head>
<body>

<% exception.printStackTrace(response.getWriter()); %>
<hr>
An exception was generated. Details are above.<br>
<a href="index.jsp?office=andie"> Office</a><br>
<a href="index.jsp?error=1">Error</a>

</body>
</html>