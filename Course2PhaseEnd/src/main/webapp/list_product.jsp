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

<%@page import="com.flights.Itinerary" %>
<%@page import="java.util.List" %>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Flight Itineraries</title>
</head>
<body>

<table border="1" width="100%">
<tr>
	<td>Itinerary ID</td>
	<td>Departure Date</td>
	<td>Departure Location</td>
	<td>Destination</td>
	<td>Schedule</td>
	<td>Airline</td>
	<td>Action</td>

</tr>


<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	CriteriaBuilder cb = se.getCriteriaBuilder();
	CriteriaQuery<Itinerary> cr = cb.createQuery(Itinerary.class);
	Root<Itinerary> root = cr.from(Itinerary.class);
	org.hibernate.Query<Itinerary> query = se.createQuery(cr);
	List<Itinerary> itins = query.getResultList();
	
	%>
	<a href="add.jsp">Add New Itinerary</a><br><br>
	
	<h1><b>List of Current Itineraries</b></h1>
	
	<%
	for(Itinerary i:itins){
		%>
		<tr>
		<td><%=i.getItinID()%></td>
		<td><%=i.getDepartDate() %></td>
		<td><%=i.getDepartLoc()%></td>
		<td><%=i.getDestLoc()%></td>
		<td>
			<b>Flight Number:</b> <%=i.getSchedule().getFlightNum() %><br>
			<b>Departure Time: </b><%=i.getSchedule().getDepartTime() %><br>
			<b>Arrival Time: </b><%=i.getSchedule().getArriveTime() %><br>
		</td>

		<td>
			<b>Airline:</b> <%=i.getAirline().getAirlineName() %><br>
			<b>Ticket Price:</b> $<%=i.getAirline().getTicketPrice() %><br>
			<b>Flight Capacity:</b> <%=i.getAirline().getFlightCapacity() %><br>	
		</td>
		
		<td>
			<a href="delete?pid=<%=i.getItinKey() %>">Delete</a>
			<a href="update.jsp?pid=<%=i.getItinKey() %>">Update</a>
			
		
		</td>
		</tr>
		
		<% 	
		

	}

	
	se.close();

%>

</table>

</body>
</html>