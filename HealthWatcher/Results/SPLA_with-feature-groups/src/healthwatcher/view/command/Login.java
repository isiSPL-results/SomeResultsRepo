
//#if -764827235 
// Compilation Unit of /Login.java 
 
package healthwatcher.view.command;

//#if 1302760574 
import healthwatcher.Constants;
//#endif 


//#if -1196047644 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -2038657361 
import healthwatcher.view.IFacade;
//#endif 


//#if -1072761577 
import java.io.FileNotFoundException;
//#endif 


//#if -1612724837 
import java.io.PrintWriter;
//#endif 


//#if -431984946 
import javax.servlet.http.HttpSession;
//#endif 


//#if -1867972137 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 399377357 
import lib.exceptions.TransactionException;
//#endif 


//#if 627218020 
import lib.util.HTMLCode;
//#endif 


//#if -2135948417 
import lib.util.Library;
//#endif 


//#if 2079725061 
import lib.exceptions.CommunicationException;
//#endif 


//#if -8087547 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class Login extends Command
  { 
private String[] keywords = { "##SYSTEM_ROOT##", "##SERVLET_SERVER_PATH##",
                                  "##CLOSE##", "##SYSTEM_ACTION##"
                                };
private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SERVLET_SERVER_PATH, HTMLCode.closeAdministrator(), Constants.SYSTEM_ACTION
                                };
public static final String EMPLOYEE = "employee";

//#if 1550669371 
public void execute()
    { 
PrintWriter out = null;

//#if -1512137940 
HttpSession session = request.getSession(true);
//#endif 


//#if -452446617 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if -716503751 
catch (Exception e) //1
{ 
e.printStackTrace();
} 

//#endif 



//#if 1501056820 
String login = request.getParameter("login");
//#endif 


//#if 382385140 
String password = request.getParameter("password");
//#endif 


//#if -1868074731 
String login = request.getInput("login");
//#endif 


//#if -2128399245 
String password = request.getInput("password");
//#endif 

try //2
{ 
Employee employee = facade.searchEmployee(login);
if(employee.validatePassword(password))//1
{ 

//#if 2000906981 
employee.addObserver(facade);
//#endif 


//#if 1605009507 
session.putValue(Login.EMPLOYEE, employee);
//#endif 


//#if -64694462 
request.setAuthorized(true);
//#endif 


//#if -2057961239 
request.put(Login.EMPLOYEE, employee);
//#endif 

out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
} 
else
{ 
out.println(HTMLCode.errorPage("Invalid password! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
} 

} 

//#if -1285147506 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode.errorPage("Invalid login! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
} 

//#endif 


//#if -1218114677 
catch (FileNotFoundException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 

//#endif 


//#if -459424102 
catch (TransactionException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 

//#endif 


//#if -1239422048 
catch (Exception e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 


//#if 1645120743 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
String login = request.getInput("login");
String password = request.getInput("password");
try //1
{ 
Employee employee = facade.searchEmployee(login);
if(employee.validatePassword(password))//1
{ 
employee.addObserver(facade);
request.setAuthorized(true);
request.put(Login.EMPLOYEE, employee);
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
} 
else
{ 
out.println(HTMLCode.errorPage("Invalid password! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
} 

} 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode.errorPage("Invalid login! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
} 

catch (FileNotFoundException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 

catch (TransactionException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 

catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch (Exception e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 


} 

//#endif 

public Login(IFacade f)
    { 
super(f);
} 

 } 


//#endif 

