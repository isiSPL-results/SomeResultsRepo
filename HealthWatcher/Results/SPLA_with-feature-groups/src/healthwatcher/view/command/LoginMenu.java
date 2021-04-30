
//#if -592981846 
// Compilation Unit of /LoginMenu.java 
 
package healthwatcher.view.command;

//#if -1224123608 
import healthwatcher.Constants;
//#endif 


//#if 1741440965 
import healthwatcher.view.IFacade;
//#endif 


//#if -1317504699 
import java.io.PrintWriter;
//#endif 


//#if -1203655452 
import javax.servlet.http.HttpSession;
//#endif 


//#if -152753026 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -905433970 
import lib.util.HTMLCode;
//#endif 


//#if -1354104811 
import lib.util.Library;
//#endif 

public class LoginMenu extends Command
  { 
private String[] keywords = { "##SYSTEM_ROOT##", "##SERVLET_SERVER_PATH##",
                                  "##CLOSE##", "##SYSTEM_ACTION##"
                                };
private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SERVLET_SERVER_PATH, HTMLCode.closeAdministrator(), Constants.SYSTEM_ACTION
                                };
public LoginMenu(IFacade f)
    { 
super(f);
} 


//#if 469210469 
public void execute()
    { 
PrintWriter out = null;

//#if 1775551603 
HttpSession session = request.getSession(false);
//#endif 


//#if -612609615 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if -543715160 
catch (Exception e) //1
{ 
e.printStackTrace();
} 

//#endif 


try //2
{ 

//#if -977362164 
if(session == null)//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
} 

//#endif 


//#if 383089493 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
} 

//#endif 

out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
} 

//#if -854741584 
catch (Exception e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 


//#if 1154274429 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
} 

out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
} 
catch (Exception e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

