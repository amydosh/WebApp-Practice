<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %> 
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.criterion.Criterion" %>
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
<%@page import="java.util.Arrays" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="org.hibernate.FetchMode" %>
<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.criterion.Order" %>
<%@page import="org.hibernate.criterion.ProjectionList" %>
<%@page import="org.hibernate.criterion.Projections" %>
<%@page import="org.hibernate.criterion.Restrictions" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Matching Flight Itineraries</title>
</head>
<body>


<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	String dLoc = request.getParameter("departloc");
	String dDate = request.getParameter("departdate");
	String destination = request.getParameter("destinationloc");
	PrintWriter pwout = response.getWriter();
	pwout.println("<html><body>");
	
	
	Criteria crit = se.createCriteria(Itinerary.class);
	crit.add(Restrictions.eq("destLoc", destination));
	crit.add(Restrictions.eq("departLoc",dLoc));
	crit.add(Restrictions.eq("departDate",dDate));

	
	List<Itinerary> itins = crit.list();
	
	if(itins.isEmpty()){
		pwout.println("Sorry, there are no matching itineraries.<br> Please try modifying your search parameters.");
				%>
				<br>
				<a href="search.jsp">Return to Search</a>
				<%
	} else{ %>
	
		<h1><b>List of Matching Itineraries</b></h1>
			<table border="1" width="100%">
			<tr>
				<th>Itinerary ID</th>
				<th>Departure Date</th>
				<th>Departure Location</th>
				<th>Destination</th>
				<th>Schedule</th>
				<th>Airline</th>
				<th>Action</th>
			</tr>
			<%	
	}

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
			<a href="bookflight.jsp?pid=<%=i.getItinKey() %>">Book this Flight</a>
			
		
		</td>
		</tr>
		
		
		
	
		
	<% 	
	}

	
	se.close();

%>

</table>


</body>
</html>