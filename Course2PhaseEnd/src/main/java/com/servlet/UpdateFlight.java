package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flights.Airlines;
import com.flights.Itinerary;
import com.flights.Schedule;
import com.util.HibernateUtil;

/**
 * Servlet implementation class UpdatePackage
 */
@WebServlet("/UpdatePackage")
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itinID = request.getParameter("itinID");
		String deptDate = request.getParameter("deptDate");
		String deptLoc = request.getParameter("deptLoc");
		String dest = request.getParameter("dest");
		int iKey = Integer.parseInt(request.getParameter("pid"));
		String flightNum = request.getParameter("flightnum");
		String airlineName = request.getParameter("airlineName");
		String departTime = request.getParameter("departTime");
		String arriveTime = request.getParameter("arriveTime");
		int flightCapacity = Integer.parseInt(request.getParameter("flightCap"));
		double ticketPrice = Double.parseDouble(request.getParameter("ticketPrice"));

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction trans = session.beginTransaction();

		Airlines airline = new Airlines(airlineName, ticketPrice, flightCapacity);
		airline.setAirlineName(airlineName);
		airline.setFlightCapacity(flightCapacity);
		airline.setTicketPrice(ticketPrice);

		Schedule sch = new Schedule(flightNum, departTime, arriveTime);
		sch.setArriveTime(arriveTime);
		sch.setDepartTime(departTime);
		sch.setFlightNum(flightNum);

		Itinerary i = session.load(Itinerary.class, iKey);

		i.setItinID(itinID);
		i.setDepartDate(deptDate);
		i.setDepartLoc(deptLoc);
		i.setDestLoc(dest);
		i.setSchedule(sch);
		i.setAirline(airline);
		session.save(i);

		trans.commit();
		session.close();

		response.sendRedirect("admin/list_flights.jsp");
	}

}
