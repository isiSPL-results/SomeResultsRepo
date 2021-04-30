
//#if 1139173920 
// Compilation Unit of /ServletRequestAdapter.java 
 

//#if -869056024 
package healthwatcher.view.servlets;
//#endif 


//#if -898310674 
import healthwatcher.view.command.CommandRequest;
//#endif 


//#if -1886141735 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -661060538 
public class ServletRequestAdapter implements 
//#if 1689069368 
CommandRequest
//#endif 

  { 

//#if -243228360 
protected HttpServletRequest request;
//#endif 


//#if -1942880511 
public String getInput(String key)
    { 

//#if 166736066 
return request.getParameter(key);
//#endif 

} 

//#endif 


//#if -912372705 
public void put(String key, Object value)
    { 

//#if -1277104858 
if(this.isAuthorized())//1
{ 

//#if -651767386 
request.getSession(true).putValue(key, value);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2107585481 
public Object get(String key)
    { 

//#if 1656322434 
if(this.isAuthorized())//1
{ 

//#if -1371448633 
return request.getSession(false).getValue(key);
//#endif 

} 

//#endif 


//#if -845596235 
return null;
//#endif 

} 

//#endif 


//#if -529894580 
public ServletRequestAdapter(HttpServletRequest request)
    { 

//#if -49270295 
this.request = request;
//#endif 

} 

//#endif 


//#if 986313119 
public void reset()
    { 

//#if 825095752 
request.getSession(true).invalidate();
//#endif 

} 

//#endif 


//#if -1185782782 
public void setAuthorized(boolean authorized)
    { 

//#if 991600254 
if(authorized)//1
{ 

//#if 1834087594 
request.getSession(true);
//#endif 

} 
else
{ 

//#if 589756213 
reset();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1103630257 
public boolean isAuthorized()
    { 

//#if -2115028002 
return request.getSession(false) != null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

