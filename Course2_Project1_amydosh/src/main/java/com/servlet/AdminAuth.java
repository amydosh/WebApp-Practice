package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
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
import com.shop.Product;
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

			
			// Muting this code for now to see if I can hard code a user account
//			Admin admin = session.load(Admin.class, 1);
//			List<Admin> adminUsers = session.createQuery("from Admin").list();
			
			
			// Using the below code to verify that I can read and retrieve admin info from database
//			out.println("<b>Admin Accounts</b><br>");
//			for(Admin a:adminUsers) {
//				out.println("Admin ID: "+admin.getAdminId()+"<br>Admin Username: "+admin.getAdminUN()+"<br>Password: "+admin.getAdminPW()+"<br>");
//			}
			
		
			
			
			
			

			// Code from class assisted practice for reference....
//				Statement stmt = conn.getConnection().createStatement(
//						ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_READ_ONLY
//						);
//				
//				ResultSet rSet = stmt.executeQuery("select * from tbl_user where  username='"+userName+"' and password = '"+passWord+"'     ");
//	
//				if( rSet.next()  ) {
//					int uid = rSet.getInt("uid");
//					HttpSession session = request.getSession();
//					session.setAttribute("logged", true);
//					session.setAttribute("uid", uid);		
//				}else {
//					
//					response.sendRedirect("invalidlogin.html");
//				}		

			
			
			
			
			
			
			
			
			
			
			// NOTE: Reading from database doesn't require a transaction 
			
//			Product product = session.load(Product.class, 1);
//			System.out.println(product.getName());
//			System.out.println(product.getPrice());
//			
//			// The below is example of changing database table values
//			product.setName("MacBook Air");
//			product.setPrice(740.00);
//			
//			Transaction tr = session.getTransaction();
//
//			session.save(product);
//			
////			session.delete(product);
//			
//			// End your transaction & close session
//			tr.commit();
//			session.close();
//			
//			
//
//			out.println("Transaction complete!");
//			out.println("</body></html>");
//		} catch (ObjectNotFoundException e) {
//			System.out.println("No data found matching the given ID.");
//		}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			// Retrieve user-entered credentials
			String adminun = request.getParameter("adminUN");
			String adminpw = request.getParameter("adminPass");
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			// Search for the adminun
			
			Criteria crit = session.createCriteria(Admin.class);
			crit.add(Restrictions.eq("adminUN", adminun));
			try {
				List<Admin> results = crit.list();
				if(results !=null) {
					String checkPW = results.get(0).getAdminPW();
					if(checkPW.equals(adminpw)) {
						response.sendRedirect("AdminDashboard.html");
					} else {
						out.println("Password incorrect!");
					}
				} else {
					out.println("Username not found!");
				}
			} catch (IndexOutOfBoundsException e) {
				response.sendError(0, "Username not found! Please try again!");
			}


			
			// Close the session
			session.close();
			
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
