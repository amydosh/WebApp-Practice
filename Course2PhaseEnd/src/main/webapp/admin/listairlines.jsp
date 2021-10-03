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
<title>List of All Airlines</title>
</head>
<body>


<table border="1" width="100%">
<tr>

	<td>Airline</td>


</tr>


<%
	Session se = HibernateUtil.getSessionFactory().openSession();
	CriteriaBuilder cb = se.getCriteriaBuilder();
	CriteriaQuery<Itinerary> cr = cb.createQuery(Itinerary.class);
	Root<Itinerary> root = cr.from(Itinerary.class);
	org.hibernate.Query<Itinerary> query = se.createQuery(cr);
	List<Itinerary> itins = query.getResultList();
	
	%>

	
	<h1><b>List of Airlines</b></h1>
	
	<%
	for(Itinerary i:itins){
		%>
		<tr>
		<td>
			<b>Airline:</b> <%=i.getAirline().getAirlineName() %><br>
		</td>
		</tr>	
	<% 	
	}

	
	se.close();

%>

</table>
<br><br>
<a href="dashboard.jsp">Return to Admin Dashboard</a>

</body>
</html>