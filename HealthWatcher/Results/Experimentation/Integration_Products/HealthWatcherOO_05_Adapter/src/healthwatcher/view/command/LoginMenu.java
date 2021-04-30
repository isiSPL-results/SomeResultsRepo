package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
import lib.util.Library;
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
public void execute()
    { 
PrintWriter out = null;
HttpSession session = request.getSession(false);
response.setContentType("text/html");
try//1
{ 
out = response.getWriter();
} 
catch (Exception e) //1
{ 
e.printStackTrace();
} 
try//2
{ 
if(session == null)//1
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

 } 
