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

import com.flights.Itinerary;
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
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		// Retrieve user-entered search parameters
		String departDate = request.getParameter("departDate");
		String departLoc = request.getParameter("departLoc");
		String dest = request.getParameter("dest");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria crit = session.createCriteria(Itinerary.class);
		crit.add(Restrictions.eq("departDate", departDate));
		crit.add(Restrictions.eq("departLoc", departLoc));
		crit.add(Restrictions.eq("dest", dest));
			List<Itinerary> results = crit.list();
			if(results !=null) {
				out.println("Available flights are listed below:");
				for(Itinerary r:results) {
					out.println(r);
				}
			}else {
				out.println("Sorry, there are no available flights matching your search criteria.");
			}
				
			out.println("</body></html>");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
}

