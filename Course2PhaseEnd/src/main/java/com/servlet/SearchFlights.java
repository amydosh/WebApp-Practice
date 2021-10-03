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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			// Retrieve user-entered search parameters
			String dDate = request.getParameter("departDate");
			String dLoc = request.getParameter("departLoc");
			String destination = request.getParameter("dest");

			Session session = HibernateUtil.getSessionFactory().openSession();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Itinerary> cr = cb.createQuery(Itinerary.class);
			Root<Itinerary> root = cr.from(Itinerary.class);
			cr.select(root);
			cr.where(cb.in(root.get("departLoc")).value(dLoc));

			TypedQuery<Itinerary> q = session.createQuery(cr);
			List<Itinerary> results = q.getResultList();

			if (results.isEmpty()) {
				out.println("Sorry, there are no available flights matching your search criteria.");
			} else {
				out.println("<b>Available flights are listed below:</b><br>");
				for (Itinerary r : results) {

					// --> Having issues printing out. The first line above prints, but it won't
					// return flight details...
					out.println("Testing");
					out.println("<b>Flight Number: </b>" + r.getSchedule().getFlightNum() + "<br>");
					out.println("<b>Airline: </b>" + r.getAirline().getAirlineName());
					out.println("<b>Ticket Price: </b>" + r.getAirline().getTicketPrice());
					out.println("<b>Departure Date: </b>" + r.getDepartDate());
					out.println("<b>Destination: </b>" + r.getDestLoc());
					out.println("<b>Departure Time: </b>" + r.getSchedule().getDepartTime());
					out.println("<b>Arrival Time: </b>" + r.getSchedule().getArriveTime());
					out.println("End of List.");
					System.out.println(r.getSchedule().getFlightNum());
					System.out.println(r.getAirline().getAirlineName());
				}

				out.println("</body></html>");
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
