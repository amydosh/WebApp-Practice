package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

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
import com.flights.Itinerary;
import com.shop.Product;
import com.util.HibernateUtil;
import com.flights.Itinerary;

/**
 * Servlet implementation class SearchFlights
 */
@WebServlet("/SearchFlights")
public class SearchFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
//			PrintWriter out = response.getWriter();
//			out.println("<html><body>");
//			String deptloc = request.getParameter("deptLoc");
//			String destloc = request.getParameter("destLoc");
////			Date deptDate = request.getParameter("deptDate");
////			Itinerary itin = new Itinerary(deptDate,deptloc,destloc);
//			
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			// Need to create code to list out the available flights from the database
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			// NOTE: Reading from database doesn't require a transaction 
//			
////			Itinerary itinClass = session.load(Itinerary.class, 1);
////			System.out.println(product.getName());
////			System.out.println(product.getPrice());
////			
////			// The below is example of changing database table values
////			product.setName("MacBook Air");
////			product.setPrice(740.00);
//			
////			Transaction tr = session.getTransaction();
//
////			session.save(product);
//			
////			session.delete(product);
//			
//			// End your transaction & close session
////			tr.commit();
//			session.close();
//			
//			
//			
//			
//			out.println("Transaction complete!");
//			out.println("</body></html>");
//		} catch (ObjectNotFoundException e) {
//			System.out.println("No data found matching the given ID.");
//		}
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			// Retrieve user-entered search parameters
			String deptDate = request.getParameter("deptDate");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date deptdate = sdf.parse(deptDate);
			String deptLoc = request.getParameter("deptLoc");
			String destLoc = request.getParameter("destLoc");
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Criteria crit = session.createCriteria(Itinerary.class);
			crit.add(Restrictions.eq("departDate", deptDate));
			crit.add(Restrictions.eq("deptLoc", deptLoc));
			crit.add(Restrictions.eq("destLoc", destLoc));
			try {
				List<Itinerary> results = crit.list();
				if(results !=null) {
					for(Itinerary r:results) {
						
					}
				}
					
					
					//--> Update this code to list the search results
					

					String checkFlights = results.get(0).getAdminPW();
					if(checkPW.equals(adminpw)) {
						response.sendRedirect("AdminDashboard.html");
					} else {
						out.println("Password incorrect!");
					}
				} else {
					out.println("Username not found!");
				}
			} catch (IndexOutOfBoundsException e) {
				response.sendError(0, "No matching flights found. Please update search parameters and try again.");
			}

			session.close();
			
			
			
			// --> Update this to display a list of the matching flights
			out.println("");
			out.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
		}
