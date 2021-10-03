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
<title>Update Existing Itinerary</title>
</head>
<body>

<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	int iKey = Integer.parseInt(request.getParameter("pid"));
	Itinerary i = se.load(Itinerary.class, iKey);

%>


<b>Update the Itinerary Details Below:</b><br>
<form method="post" action="../update?pid=<%=i.getItinKey() %>">
Itinerary ID: <input type="text" name="itinID" value="<%=i.getItinID() %>">
<br>
Departure Date: <input type="text" name="deptDate" value="<%=i.getDepartDate() %>">
<br>
Departure Location: <input type="text" name="deptLoc" value="<%=i.getDepartLoc() %>">
<br>
Destination: <input type="text" name="dest" value="<%=i.getDestLoc() %>">
<br><br>


<b>Update the Flight Details Below:</b><br>
Flight Number: <input type="text" name="flightnum" value="<%=i.getSchedule().getFlightNum() %>">
<br>
Airline Name: <input type="text" name="airlineName" value="<%=i.getAirline().getAirlineName() %>">
<br>
Departure Time (XX:XXam/pm): <input type="text" name="departTime" value="<%=i.getSchedule().getDepartTime() %>">
<br>
Arrival Time (XX:XXam/pm): <input type="text" name="arriveTime" value="<%=i.getSchedule().getArriveTime() %>">
<br>
Flight Capacity: <input type="text" name="flightCap" value="<%=i.getAirline().getFlightCapacity() %>">
<br>
Ticket Price: <input type="text" name="ticketPrice" value="<%=i.getAirline().getTicketPrice() %>">
<br>

<button type="submit">Save</button>





</form>

<% 	se.close(); %>


</body>
</html>