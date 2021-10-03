<%@page import="com.util.HibernateUtil" %>
<%@page import="java.io.PrintWriter" %>
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
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="com.common.Admin" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin Credentials</title>
</head>
<body>

	<%

	String adminun = request.getParameter("adminUN");
	String currentPW = request.getParameter("currentPass");
	String adminpw1 = request.getParameter("newPass1");
	String adminpw2 = request.getParameter("newPass2");
	PrintWriter pwout = response.getWriter();
	pwout.println("<html><body>");

	if(adminpw1.equals(adminpw2)){
		Session sess = HibernateUtil.getSessionFactory().openSession();
		// int pid = Integer.parseInt(request.getParameter("pid"));
		Admin a = sess.load(Admin.class, 1);
		Transaction trans = sess.beginTransaction();

		Criteria crit = sess.createCriteria(Admin.class);
		crit.add(Restrictions.eq("adminUN", adminun));
		crit.add(Restrictions.eq("adminPW", currentPW));

		List<Admin> verify = crit.list();
		
		if(verify.isEmpty()){
			pwout.println("Sorry, unable to update credentials. Please verify you have entered your credentials correctly.");
			%> Click <a href="updateadmincred.jsp">here</a> to try again.<br> <%
		} else{ 
			a.setAdminPW(adminpw2);
			sess.save(a);
			
			trans.commit();
			sess.close();
			
			response.sendRedirect("Success.html");
				
		}
		
	} else {
		pwout.println("The new passwords you have entered do not match. Please try again.");
		response.sendRedirect("updateadmincred.jsp");
	}
	%>


</body>
</html>