package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flights.Itinerary;
import com.util.HibernateUtil;

/**
 * Servlet implementation class DeleteItin
 */
@WebServlet("/DeleteItin")
public class DeleteItin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteItin() {
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

		Itinerary itin = session.load(Itinerary.class, Integer.parseInt(request.getParameter("pid")));

		session.delete(itin);

		trans.commit();
		session.close();

		response.sendRedirect("admin/list_flights.jsp");
	}

}
