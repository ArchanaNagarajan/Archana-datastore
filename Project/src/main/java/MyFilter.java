

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{  
	  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
          
    PrintWriter out=resp.getWriter();  
     
    String name = req.getParameter("name");
    String password=req.getParameter("pwd");  
    if(name.equals("Archana")&&(password.equals("archana"))){  
    chain.doFilter(req, resp);  
    }  
    else{  
    out.print("username or password incorrect!");  
    RequestDispatcher rd=req.getRequestDispatcher("index.html");  
    rd.include(req, resp);  
    }  
          
}  
    public void destroy() {
    	
    }
	}  
   