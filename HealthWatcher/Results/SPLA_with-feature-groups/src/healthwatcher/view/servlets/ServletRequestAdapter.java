
//#if 1139173920 
// Compilation Unit of /ServletRequestAdapter.java 
 
package healthwatcher.view.servlets;

//#if -898310674 
import healthwatcher.view.command.CommandRequest;
//#endif 


//#if -1886141735 
import javax.servlet.http.HttpServletRequest;
//#endif 

public class ServletRequestAdapter implements CommandRequest
  { 
protected HttpServletRequest request;
public String getInput(String key)
    { 
return request.getParameter(key);
} 

public void put(String key, Object value)
    { 
if(this.isAuthorized())//1
{ 
request.getSession(true).putValue(key, value);
} 

} 

public Object get(String key)
    { 
if(this.isAuthorized())//1
{ 
return request.getSession(false).getValue(key);
} 

return null;
} 

public ServletRequestAdapter(HttpServletRequest request)
    { 
this.request = request;
} 

public void reset()
    { 
request.getSession(true).invalidate();
} 

public void setAuthorized(boolean authorized)
    { 
if(authorized)//1
{ 
request.getSession(true);
} 
else
{ 
reset();
} 

} 

public boolean isAuthorized()
    { 
return request.getSession(false) != null;
} 

 } 


//#endif 

