

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
		 //Key key = KeyFactory.createKey("contactApp", "name");
		Query q =new Query("contactApp").addFilter("Name",FilterOperator.EQUAL, name);
		 PreparedQuery pq = Main.datastore.prepare(q);

		   for (Entity result : pq.asIterable()) {
		    	 
		      Key key = result.getKey();
		      Main.datastore.delete(key);
		      }	
					        
    response.sendRedirect("ViewAll");
	}

}
