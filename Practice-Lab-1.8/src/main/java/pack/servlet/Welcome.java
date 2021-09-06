package pack.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("You are working in the Welcome Servlet.");
		RequestDispatcher rs = request.getRequestDispatcher("welcome.html");
		out.println("</html></body>");

//		PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//
//        String userId = request.getParameter("userid");
//        String pw = request.getParameter("pass");
//        
//        if(Validate.checkUser(userId, pw)) {
//        	out.println("Welcome! You have successfully logged in!");
//            out.println("You have successfully logged in!<br>");
//            out.println("Welcome "+userId+"!");
//            out.println("<br>");
//        	RequestDispatcher rs = request.getRequestDispatcher("Welcome");
//        	rs.forward(request, response);
//        } else {
//        	out.println("User ID or Password Incorrect<br>");
//        	out.println("Please try again.");
//        	RequestDispatcher rs = request.getRequestDispatcher("index.html");
//        	rs.include(request, response);
//        }
        

//        out.println(pw);
//        out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Welcome! You have successfully logged in!");
	}

}
