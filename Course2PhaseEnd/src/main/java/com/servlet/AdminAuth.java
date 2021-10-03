package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.common.Admin;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AdminAuth
 */
@WebServlet("/AdminAuth")
public class AdminAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("adminUN");
		String password = request.getParameter("adminPass");

		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<Admin> cr = cb.createQuery(Admin.class);

		Root<Admin> root = cr.from(Admin.class);

		Predicate predicateForUserName = cb.equal(root.get("adminUN"), userName);

		Predicate predicateForPassword = cb.equal(root.get("adminPW"), password);

		Predicate predicateForUsernameAndPassword = cb.and(predicateForUserName, predicateForPassword);

		cr.where(predicateForUsernameAndPassword);

		List<Admin> users = session.createQuery(cr).getResultList();

		if (users.size() == 1) {

			Admin tempAdmin = users.get(0);
			HttpSession loginSession = request.getSession();
			loginSession.setAttribute("logged", true);
			loginSession.setAttribute("username", tempAdmin.getAdminUN());
			response.sendRedirect("admin/dashboard.jsp");

			System.out.println(tempAdmin.getAdminUN());

		} else {
			response.sendRedirect("login.jsp?error=1");
		}
		System.out.println(users);
	}
}
