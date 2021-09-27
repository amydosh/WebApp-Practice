<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>

<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Available Flights</title>
</head>
<body>

<%
	Session se = HibernateUtil.getSessionFactory().openSession();

%>


<b>Search for Available Flights:</b><br>
<form method="post" action="searchFlights">
	Departure Location: <input list="departLoc">
		<datalist id="departLoc">
		    <option value="Raleigh">
		    <option value="Charlotte">
		    <option value="Detroit">
		    <option value="Miami">
		    <option value="New York">
		    <option value="Denver">
  		</datalist>
  		<br>
 	Destination: <input list="dest">
 		<datalist id="dest">
 			<option value="Raleigh">
		    <option value="Charlotte">
		    <option value="Detroit">
		    <option value="Miami">
		    <option value="New York">
		    <option value="Denver">
 		</datalist><br>
 	Desired Departure Date (MM-DD-YYYY): <input type="text" name="departDate"><br>

<button type="submit">Search</button>





</form>

</body>
</html>