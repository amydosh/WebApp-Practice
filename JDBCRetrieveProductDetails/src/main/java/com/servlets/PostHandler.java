package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
 * Servlet implementation class PostHandler
 */
@WebServlet("/PostHandler")
public class PostHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostHandler() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String prodID = request.getParameter("productID");
			
			System.out.println("You have selected Product ID: "+prodID);
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("You have selected Product ID: "+prodID+"<br>");
			
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			
			DBConnection conn = new DBConnection(props.getProperty("url"),props.getProperty("userid"),props.getProperty("password"));
			Statement stmt = conn.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from eproduct where ID="+Integer.parseInt(prodID));
			
			if(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				out.println("Product ID "+id+" name is "+name+"<br>");
				out.println("Product ID "+id+" price is $"+price+"<br>"); 
			}else {
				System.out.println("Product ID "+prodID+"has not been found.");
				out.println("Product ID "+prodID+" has not been found.<br>");
				response.sendRedirect("error.html");
			}
			
			stmt.close();
			
			conn.closeConnection();
			
			out.println("</body></html>");
			conn.closeConnection();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	}

