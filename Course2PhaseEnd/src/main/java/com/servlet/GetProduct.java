package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shop.Product;
import com.util.HibernateUtil;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			// NOTE: Reading from database doesn't require a transaction 
			
			Product product = session.load(Product.class, 1);
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			
			// The below is example of changing database table values
			product.setName("MacBook Air");
			product.setPrice(740.00);
			
			Transaction tr = session.getTransaction();

			session.save(product);
			
//			session.delete(product);
			
			// End your transaction & close session
			tr.commit();
			session.close();
			
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Transaction complete!");
			out.println("</body></html>");
		} catch (ObjectNotFoundException e) {
			System.out.println("No data found matching the given ID.");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
