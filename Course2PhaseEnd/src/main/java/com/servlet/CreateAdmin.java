package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.common.Admin;
import com.util.HibernateUtil;

/**
 * Servlet implementation class CreateAdmin
 */
@WebServlet("/CreateAdmin")
public class CreateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			// Retrieve user-entered credentials
			String adminkey = request.getParameter("adminKey");
			String adminun = request.getParameter("createAdminUN");
			String adminpw = request.getParameter("createAdminPass");

			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = session.beginTransaction();

			// Verify the correct admin key was entered
			if (adminkey.equals("adminkey123")) {

				Criteria crit = session.createCriteria(Admin.class);
				crit.add(Restrictions.eq("adminUN", adminun));
				crit.add(Restrictions.eq("adminPW", adminpw));

				List<Admin> checkUN = crit.list();

				if (checkUN.isEmpty()) {
					Admin admin1 = new Admin(adminun, adminpw);
					out.println("New admin user account successfully created.");
					session.save(admin1);
					trans.commit();
					session.close();
					response.sendRedirect("admin/dashboard.jsp");
				} else {
					response.sendRedirect("admin/UNexists.html");
					out.println("Sorry! The username entered already exists. Please select a new username.");
				}
			} else {
				response.sendRedirect("admin/InvalidKey.html");
				out.println("An invalid key was entered. Please try again.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
