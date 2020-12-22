

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	     
		 try {
				request.getRequestDispatcher("Main.html").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		 String name=request.getParameter("name");
		 String number=request.getParameter("number");
		 String state=request.getParameter("state");
     
		 Entity ent = new Entity("contactApp");
		 ent.setProperty("Name", name);
		 ent.setProperty("Number", number);
		 ent.setProperty("State" , state);
		 Main.datastore.put(ent);
		 
         out.println("Name: "+ name + "<br> Number: " + number + "<br>State: " + state +"<br><br/>" );
   
	}

}
