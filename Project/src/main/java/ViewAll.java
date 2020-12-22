

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.common.collect.ImmutableList;

@WebServlet("/ViewAll")
public class ViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		    
		PrintWriter out = response.getWriter();
     
		 try {
				request.getRequestDispatcher("Main.html").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
      Query q = new Query("contactApp");
      
      PreparedQuery pq = Main.datastore.prepare(q);

      for (Entity result : pq.asIterable()) {
        String Name = (String) result.getProperty("Name");
        String Number = (String) result.getProperty("Number");
        String State = (String) result.getProperty("State");

        out.println("Name: "+ Name + "<br> Number: " + Number + "<br>State: " + State +"<br><br/>" );
      }	
	}
}