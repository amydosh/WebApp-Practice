<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="javax.persistence.criteria.CriteriaBuilder"%>
<%@page import="javax.persistence.criteria.CriteriaQuery"%>
<%@page import="javax.persistence.criteria.Root"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>


<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="com.flights.Itinerary" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New Itinerary</title>
</head>
<body>

<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	Itinerary i = se.load(Itinerary.class,1);

%>



<form method="get" action="addFlight">

Itinerary ID: <input type="text" name="newItinId">
<br>
Departure Date: <input type="text" name="newItinDeptDate">
<br>
Departure Location: <input type="text" name="newItinDeptLoc">
<br>
Destination: <input type="text" name="newItinDest">
<br>
Airline: <input type="text" name="newItinAirline">
<br>
Ticket Price: <input type="text" name="newItinPrice">
<br>
Plane Capacity: <input type="text" name="newItinPlaneCap">
<br>
Flight Number: <input type="text" name="flightnum">
<br>
Departure Time: <input type="text" name=departTime>
<br>
Arrival Time: <input type="text" name="arriveTime">
<br>



<button type="submit">Save</button>





</form>

<% 	se.close(); %>



</body>
</html>