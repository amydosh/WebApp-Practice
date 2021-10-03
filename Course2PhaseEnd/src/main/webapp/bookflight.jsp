<%@page import="com.util.HibernateUtil" %>
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
<title>Book Your Flight</title>
</head>
<body>

<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	int iKey = Integer.parseInt(request.getParameter("pid"));
	Itinerary i = se.load(Itinerary.class, iKey);

%>

<b>You have selected Flight <%=i.getItinID() %>.<br>
The details are listed below.</b><br><br>

<b>Flight Departure Date:</b> <%=i.getDepartDate() %><br>
<b>Flight Departure Location: </b><%=i.getDepartLoc() %><br>
<b>Flight Destination: </b><%=i.getDestLoc() %><br>
<b>Ticket Price:</b> $<%=i.getAirline().getTicketPrice() %><br>
</b><br>

<form method="post" action="paymentportal.jsp?pid=<%=i.getItinKey()%>">
	Please Confirm Number of Tickets: <input type="text" name="numPass"><br>
<button type="submit">Click here to continue to the payment portal</button><br><br>
</form>

To return to the search page, please click <a href="search.jsp">here</a>.
</body>
</html>