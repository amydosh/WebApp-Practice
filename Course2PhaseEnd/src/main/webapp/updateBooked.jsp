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
<%@page import="com.flights.ConfirmedFlights" %>
<%@page import="java.util.List" %>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Existing Itinerary</title>
</head>
<body>

<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	int confKey = Integer.parseInt(request.getParameter("pid"));
	ConfirmedFlights cf= se.load(ConfirmedFlights.class, confKey);

%>


<b>Update the Booking Details Below:</b><br>
<form method="post" action="updateBooked?pid=<%=cf.getConfKey() %>">
Flight Number: <input type="text" name="flightnum" value="<%=cf.getFlightnum() %>">
<br>
Airline Name: <input type="text" name="airlinename" value="<%=cf.getAirlinename() %>">
<br>
Passenger First Name:: <input type="text" name="fname" value="<%=cf.getFname() %>">
<br>
Passenger Last Name: <input type="text" name="lname" value="<%=cf.getLname() %>">
<br>
Number of Passengers in Party: <input type="text" name="numPass" value="<%=cf.getNumPass() %>">
<br><br>

<button type="submit">Save</button>





</form>

<% 	se.close(); %>


</body>
</html>