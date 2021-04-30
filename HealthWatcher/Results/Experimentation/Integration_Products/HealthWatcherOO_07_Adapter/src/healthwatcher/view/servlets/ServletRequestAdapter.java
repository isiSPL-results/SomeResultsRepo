package healthwatcher.view.servlets;
import healthwatcher.view.command.CommandRequest;
import javax.servlet.http.HttpServletRequest;
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
