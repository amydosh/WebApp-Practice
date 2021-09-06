package pack.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.servlet.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String userId = request.getParameter("userid");
        String pw = request.getParameter("pass");
        
        if(Validate.checkUser(userId, pw)) {
        	RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
        	rs.forward(request, response);
        } else {
        	out.println("User ID or Password Incorrect<br>");
        	out.println("Please try again.<br><br>");
        	RequestDispatcher rs = request.getRequestDispatcher("index.html");
        	rs.include(request, response);
        }
        out.println("</html></body>");		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
