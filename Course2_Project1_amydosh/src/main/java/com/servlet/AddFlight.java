package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			
			// Retrieve user-entered credentials
			String deptDate = request.getParameter("deptDate");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date deptdate = sdf.parse(deptDate);
			String deptLoc = request.getParameter("deptLoc");
			String destLoc = request.getParameter("destLoc");
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			Transaction trans = session.beginTransaction();
			
			Itinerary itin = new Itinerary(deptDate,deptLoc,destLoc);

			session.save(itin);
			
			// End your transaction & close session
			trans.commit();
			session.close();
			
			out.println("Flight itinerary successfully added!");
			

			out.println("</body></html>");
		} catch (Exception e) {
			response.sendRedirect("AdmingDashboard.html");
		}
		
		
	}

}
