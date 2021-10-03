package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flights.ConfirmedFlights;
import com.flights.Itinerary;
import com.util.HibernateUtil;

/**
 * Servlet implementation class DeleteBooked
 */
@WebServlet("/DeleteBooked")
public class DeleteBooked extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBooked() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();

		ConfirmedFlights cf = session.load(ConfirmedFlights.class, Integer.parseInt(request.getParameter("pid")));

		session.delete(cf);

		trans.commit();
		session.close();

		response.sendRedirect("admin/viewbooked.jsp");
	}

}
