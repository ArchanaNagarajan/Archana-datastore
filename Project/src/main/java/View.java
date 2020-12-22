

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@WebServlet("/View")
public class View extends HttpServlet {
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
		 
		// String name = request.setAttribute("name", name);;
		//Key key = KeyFactory.createKey("contactApp", "name");
		// System.out.println("Key is "+ key);
		Query q =new Query("contactApp").addFilter("Name",FilterOperator.EQUAL, name);
		 PreparedQuery pq = Main.datastore.prepare(q);

	      for (Entity result : pq.asIterable()) {
	        String Name = (String) result.getProperty("Name");
	        String Number = (String) result.getProperty("Number");
	        String State = (String) result.getProperty("State");

	        out.println("Name: "+ Name + "<br> Number: " + Number + "<br>State: " + State +"<br><br/>" );
	      }	
				        

				
	}

}
