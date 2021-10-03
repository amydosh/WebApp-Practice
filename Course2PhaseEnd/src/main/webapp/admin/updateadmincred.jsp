<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin Credentials</title>
</head>
<body>

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
<%@page import="org.hibernate.Transaction" %>
<%@page import="com.common.Admin" %>
<%@page import="java.util.List" %>

<%
	Session sess = HibernateUtil.getSessionFactory().openSession();
//	int pid = Integer.parseInt(request.getParameter("pid"));
//	Admin a = sess.load(Admin.class, pid);

%>



<form method="post" action="updateadmincreds.jsp">

	Username: <input type="text" name="adminUN">
	<br>
	Current Password: <input type="password" name="currentPass">
	<br>
	New Password: <input type="password" name="newPass1">
	<br>
	Please Confirm Your New Password: <input type="password" name="newPass2">
	<button type="submit">Save</button>

</form>

<% 	sess.close(); %>



<a href="dashboard.jsp">Return to Admin Dashboard</a>

</body>
</html>