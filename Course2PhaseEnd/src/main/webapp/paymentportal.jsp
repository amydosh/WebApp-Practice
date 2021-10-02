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
<title>Payment Portal</title>
</head>
<body>

<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	int iKey = Integer.parseInt(request.getParameter("pid"));
	Itinerary i = se.load(Itinerary.class, iKey);
	int numPassInt = Integer.parseInt(request.getParameter("numPass"));
	double totalPrice;
	//int numPassInt = Integer.parseInt(request.getParameter("numPass"));
	
	
%>

Please enter the following information to finish the booking process.<br>
<form method="post" action="confirmation.jsp?pid=<%=i.getItinKey()%>">
	First name: <input type="text" name="fname"><br>
	Last name: <input type="text" name="lname"><br>
	Billing Address: <input type="text" name="address"><br>
	Zip Code: <input type="text" name="zip"><br>
	State: <input type="text" name="state"><br><br>
	<% totalPrice = (double) (numPassInt)*(i.getAirline().getTicketPrice()); %>
	
	<b>Total Price: </b> $<%=totalPrice %><br>
	
	
	<input type="hidden" name="itinkey" value="<%i.getItinKey(); %>">
	<input type="hidden" name="airline" value="<%i.getAirline().getAirlineName(); %>">
	<input type="hidden" name="numPass" value="<%=numPassInt %>">
	<input type="hidden" name="totalprice" value="<%=totalPrice %>">
	
	Credit Card Number: <input type="password" name="ccnum"><br>
	
<button type="submit">Pay and Confirm</button>

</form>

</body>
</html>