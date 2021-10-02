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
<%@page import="com.common.Admin" %>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>

<%
	Session sess = HibernateUtil.getSessionFactory().openSession();
//	int pid = Integer.parseInt(request.getParameter("pid"));
//	Admin a = sess.load(Admin.class, pid);

%>


<b>Welcome Admin User!</b><br>
Please select from the following options:<br>
<a href="list_flights.jsp"> Click here to view/modify flight itineraries</a><br>
<a href="listlocations.jsp"> Click here to view all of the sources and destinations</a><br>
<a href="listairlines.jsp">Click here to view all of the airlines</a><br>
<a href="add.jsp">Add a new flight itinerary</a><br>
<a href="viewbooked.jsp">View all booked itineraries</a><br>
<a href="updateadmincred.jsp">Update Admin Credentials</a><br>
<a href="logout.jsp"> Logout</a>



</body>
</html>