package com.servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flights.ConfirmedFlights;
import com.util.HibernateUtil;

/**
 * Servlet implementation class UpdateCreds
 */
@WebServlet("/UpdateBooked")
public class UpdateBooked extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBooked() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int confKey = Integer.parseInt(request.getParameter("pid"));

		// String itinID = request.getParameter("itinID");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String airline = request.getParameter("airlinename");
		String fnum = request.getParameter("flightnum");
		int numPass = Integer.parseInt(request.getParameter("numPass"));

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction trans = session.beginTransaction();

		ConfirmedFlights cf = session.load(ConfirmedFlights.class, confKey);

		cf.setAirlinename(airline);
		cf.setFlightnum(fnum);
		cf.setFname(fname);
		cf.setLname(lname);
		cf.setNumPass(numPass);

		session.save(cf);

		trans.commit();
		session.close();

		response.sendRedirect("admin/viewbooked.jsp");
	}

}
