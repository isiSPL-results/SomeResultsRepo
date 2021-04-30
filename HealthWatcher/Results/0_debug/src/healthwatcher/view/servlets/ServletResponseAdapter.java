
//#if 1299956082 
// Compilation Unit of /ServletResponseAdapter.java 
 

//#if -218725369 
package healthwatcher.view.servlets;
//#endif 


//#if -294690345 
import healthwatcher.view.command.CommandResponse;
//#endif 


//#if -234936316 
import java.io.IOException;
//#endif 


//#if 385283917 
import java.io.PrintWriter;
//#endif 


//#if -1854021172 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if -1385844761 
public class ServletResponseAdapter implements 
//#if 1859881222 
CommandResponse
//#endif 

  { 

//#if 516004260 
protected HttpServletResponse response;
//#endif 


//#if 1994309187 
public PrintWriter getWriter() throws IOException
    { 

//#if 777816390 
return this.response.getWriter();
//#endif 

} 

//#endif 


//#if 1750629050 
public ServletResponseAdapter(HttpServletResponse response)
    { 

//#if 1457248322 
this.response = response;
//#endif 


//#if -1122439301 
this.response.setContentType("text/html");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

