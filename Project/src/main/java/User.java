

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

	    PrintWriter out = response.getWriter();
	    
	    try {
			request.getRequestDispatcher("UserMain.html").include(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	    out.print("<h3>Welcome to the page USER!!!</h3>");
	}

}
