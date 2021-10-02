package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;

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
		String itinID = request.getParameter("newItinId");
		String deptdate = request.getParameter("newItinDeptDate");
		String deptloc = request.getParameter("newItinDeptLoc");
		String dest = request.getParameter("newItinDest");
		String flightNum = request.getParameter("flightnum");
		String airlineName = request.getParameter("newItinAirline");
		String departTime = request.getParameter("departTime");
		String arriveTime = request.getParameter("arriveTime");
		int flightCapacity = Integer.parseInt(request.getParameter("newItinPlaneCap"));
		double ticketPrice = Double.parseDouble(request.getParameter("newItinPrice"));
//		int flightCapacity = 180;
//		double ticketPrice = 256.57;
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction trans = session.beginTransaction();
		
		Airlines airline = new Airlines(airlineName, ticketPrice, flightCapacity);
		
		Schedule sch = new Schedule(flightNum, departTime, arriveTime);
		
		Itinerary itin = new Itinerary(itinID,deptdate,deptloc,dest,sch,airline);
		
		
		// --> How to add the embedded tables in for Flight # (Airline, Ticket Price, Flight Capacity) & Flight # (booked itins)
//		ProductImage img1 = new ProductImage(imgURL, product);
		
//		img1.addImageMeta(new ProductImageMeta("height",imgH,img1));
//		img1.addImageMeta(new ProductImageMeta("width",imgW,img1));
//		
//		product.addImage(img1);
		
		session.save(itin);

		
		trans.commit();
		session.close();
		
		response.sendRedirect("list_flights.jsp");
	}


}
