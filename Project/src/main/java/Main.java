

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.common.collect.ImmutableList;

@WebServlet("/Main")
public class Main extends HttpServlet {
 
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	public static void Data() {
		
		//PrintWriter out = response.getWriter();

      Entity e1 = new Entity("contactApp",1);
      e1.setProperty("Name", "Archana");
      e1.setProperty("Number", "9790955930");
      e1.setProperty("State", "Tamilnadu");
      Entity e2 = new Entity("contactApp",2);
      e2.setProperty("Name", "Arav");
      e2.setProperty("Number", "9790955932");
      e2.setProperty("State", "Tamilnadu");
      Entity e3 = new Entity("contactApp",3);
      e3.setProperty("Name", "Kalai");
      e3.setProperty("Number", "8122204320");
      e3.setProperty("State", "AndhraPradesh");
      Entity e4 = new Entity("contactApp",4);
      e4.setProperty("Name", "Janani");
      e4.setProperty("Number", "7358682689");
      e4.setProperty("State", "Kerala");
      Entity e5 = new Entity("contactApp",5);
      e5.setProperty("Name", "Deepiha");
      e5.setProperty("Number", "9876509871");
      e5.setProperty("State", "Nagaland");
      datastore.put(ImmutableList.<Entity>of(e1,e2,e3,e4,e5));
       
	}   
}