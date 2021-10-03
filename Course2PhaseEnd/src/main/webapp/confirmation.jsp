<%@page import="com.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>



<%@page import="com.flights.ConfirmedFlights"%>
<%@page import="com.flights.Itinerary"%>
<%@page import="com.flights.Airlines"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
</head>
<body>


	<b>Your flight has been booked!</b>
	<br>

	<%
Session sess = HibernateUtil.getSessionFactory().openSession();
int iKey = Integer.parseInt(request.getParameter("pid"));
Itinerary i = sess.load(Itinerary.class, iKey);
int numPassInt = Integer.parseInt(request.getParameter("numPass"));
double totalPrice;
%>


	<b>You have selected Flight <%=i.getItinID()%>.<br> <br>
		The details are listed below.
	</b>
	<br>
	<b>Flight Number: </b>
	<%=i.getSchedule().getFlightNum()%><br>
	<b>Airline: </b>
	<%=i.getAirline().getAirlineName()%><br>
	<b>Flight Departure Date:</b>
	<%=i.getDepartDate()%><br>
	<b>Flight Departure Location: </b><%=i.getDepartLoc()%><br>
	<b>Flight Destination: </b><%=i.getDestLoc()%><br>
	<b>Ticket Price per Person:</b> $<%=i.getAirline().getTicketPrice()%><br>
	<b>Number of Passengers in Party: </b><%=request.getParameter("numPass")%><br>
	<%
	totalPrice = (double) (numPassInt) * (i.getAirline().getTicketPrice());
	%>
	<b>Total Price: </b> $<%=totalPrice%><br>
	<br> To book an additional flight, please click
	<a href="search.jsp">here</a>.
	<br> If you are finished with booking, you may close this window.
	<br>
	<br>

	<%
	Transaction trans = sess.beginTransaction();

	String firstName = request.getParameter("fname");
	String lastName = request.getParameter("lname");
	String billingAddress = request.getParameter("address");
	String zipcode = request.getParameter("zip");
	String state = request.getParameter("state");
	String paymentMethod = request.getParameter("ccnum");
	String airlinename = i.getAirline().getAirlineName().toString();
	String flightNum = i.getSchedule().getFlightNum().toString();

	ConfirmedFlights confirmed = new ConfirmedFlights(firstName, lastName, billingAddress, state, zipcode, airlinename,
			flightNum, numPassInt);

	sess.save(confirmed);

	trans.commit();
	sess.close();
	%>


</body>
</html>