<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.Criteria"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder"%>
<%@page import="javax.persistence.criteria.CriteriaQuery"%>
<%@page import="javax.persistence.criteria.Root"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>

<%@page import="com.flights.ConfirmedFlights" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Booked Itineraries</title>
</head>
<body>

<b>All Confirmed and Booked Itineraries are Shown Below: </b>

<table border="1" width="100%">
<tr>
	<td>Flight Number</td>
	<td>Airline Name</td>
	<td>Passenger First Name</td>
	<td>Passenger Last Name</td>
	<td>Number of Passengers in Party</td>
	<td>Action</td>

</tr>


<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	CriteriaBuilder cb = se.getCriteriaBuilder();
	CriteriaQuery<ConfirmedFlights> cr = cb.createQuery(ConfirmedFlights.class);
	Root<ConfirmedFlights> root = cr.from(ConfirmedFlights.class);
	org.hibernate.Query<ConfirmedFlights> query = se.createQuery(cr);
	List<ConfirmedFlights> conf = query.getResultList();
	
	%>
	
	<%
	for(ConfirmedFlights i:conf){
		%>
		<tr>
		<td><%=i.getFlightnum() %></td>
		<td><%=i.getAirlinename() %></td>
		<td><%=i.getFname() %></td>
		<td><%=i.getLname() %></td>
		<td><%=i.getNumPass() %></td>
		<td> <a href="deleteBooked?pid=<%=i.getConfKey() %>">Delete Booking</a><br>
			 <a href="updateBooked.jsp?pid=<%=i.getConfKey() %>">Modify Booking</a>
		</td>
		
		</tr>
		<br>

		
		<% 	
		

	}

	
	se.close();

%>

</table>

		To return back to the Admin Dashboard, click <a href="dashboard">here</a>.


</body>
</html>