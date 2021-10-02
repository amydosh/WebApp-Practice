package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			// Retrieve user-entered credentials
			String adminun = request.getParameter("adminUN");
			String adminpw = request.getParameter("adminPass");
			
			Session session = HibernateUtil.getSessionFactory().openSession();
//			Admin a = session.load(Admin.class, 1);
			Criteria crit = session.createCriteria(Admin.class);
			crit.add(Restrictions.eq("adminUN", adminun));
			crit.add(Restrictions.eq("adminPW", adminpw));
			List<Admin> results = crit.list();
//			CriteriaBuilder cb = session.getCriteriaBuilder();
//			CriteriaQuery<Admin> crit = cb.createQuery(Admin.class);
//			Root<Admin> root = crit.from(Admin.class);
//			crit.select(root.get("admin".as(Admin.class)));
//			cr.select(root).where(cb.ge(root.get("adminUN"),adminun));
			// cr.select(root).where(cb.ge(root.get("price"),(double) 200.00));
			
//			
//			Criteria crit = cr
//			org.hibernate.Query<Admin> query = session.createQuery(cr);
//			crit.add(Restrictions.eq("adminUN", adminun));
//			crit.add(Restrictions.eqOrIsNull("adminPW", adminpw));
//			List<Admin> admin = query.getResultList();
			
			// Search for the adminun
//			
//			Criteria crit = session.createCriteria(Admin.class);
//			crit.add(Restrictions.eq("adminUN", adminun));
//			crit.add(Restrictions.eqOrIsNull("adminPW", adminpw));
			try {
				if(results.isEmpty()) {
//					String checkPW = results.get(0).getAdminPW();
//					if(checkPW.equals(adminpw)) {
					out.println("Password incorrect!");
					response.sendRedirect("invalidlogin.html");
					} else {
						response.sendRedirect("dashboard.jsp");	
					}
//				} else {
//					out.println("Username not found!");
//				}

			// Close the session
			session.close();
			
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

		
		
		// --> Old
//		try {
//			PrintWriter out = response.getWriter();
//			out.println("<html><body>");
//			
//			// Retrieve user-entered credentials
//			String adminun = request.getParameter("adminUN");
//			String adminpw = request.getParameter("adminPass");
//			
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			
//			// Search for the adminun
//			
//			Criteria crit = session.createCriteria(Admin.class);
//			crit.add(Restrictions.eq("adminUN", adminun));
//			crit.add(Restrictions.eq("adminPW", adminpw));
//			List<Admin> results = crit.list();
//			if(results==null) {
//				out.println("Account not found!");
////				response.sendError(0, "Account not found! Please try again.");
//			} else {
//				response.sendRedirect("dashboard.jsp");
//			}
//			
//			
//			
////			
////			try {
////				List<Admin> results = crit.list();
////				if(results !=null) {
////					String checkPW = results.get(0).getAdminPW();
////					if(checkPW.equals(adminpw)) {
////						response.sendRedirect("dashboard.jsp");
////					} else {
////						out.println("Password incorrect!");
////					}
////				} else {
////					out.println("Username not found!");
////				}
////			} catch (IndexOutOfBoundsException e) {
////				response.sendError(0, "Username not found! Please try again!");
////			}
//
//
//			
//			// Close the session
//			session.close();
//			
//			out.println("</body></html>");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//}
