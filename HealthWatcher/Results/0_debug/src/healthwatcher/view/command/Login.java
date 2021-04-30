
//#if -764827235 
// Compilation Unit of /Login.java 
 

//#if -1502083452 
package healthwatcher.view.command;
//#endif 


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


//#if 597450329 
public class Login extends 
//#if -1912952819 
Command
//#endif 

  { 

//#if -369099533 
private String[] keywords = { "##SYSTEM_ROOT##", "##SERVLET_SERVER_PATH##",
                                  "##CLOSE##", "##SYSTEM_ACTION##"
                                };
//#endif 


//#if 1117579753 
private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SERVLET_SERVER_PATH, HTMLCode.closeAdministrator(), Constants.SYSTEM_ACTION
                                };
//#endif 


//#if -730105588 
public static final String EMPLOYEE = "employee";
//#endif 


//#if 1550669371 
public void execute()
    { 

//#if 1117866045 
PrintWriter out = null;
//#endif 


//#if -1512137940 
HttpSession session = request.getSession(true);
//#endif 


//#if -452446617 
response.setContentType("text/html");
//#endif 


//#if 188103694 
try //1
{ 

//#if 667340183 
out = response.getWriter();
//#endif 

} 

//#if -716503751 
catch (Exception e) //1
{ 

//#if 1238339426 
e.printStackTrace();
//#endif 

} 

//#endif 


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


//#if -1135096861 
try //2
{ 

//#if 426064291 
Employee employee = facade.searchEmployee(login);
//#endif 


//#if 1702996187 
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


//#if -188432978 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
//#endif 

} 
else
{ 

//#if -566245407 
out.println(HTMLCode.errorPage("Invalid password! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
//#endif 

} 

//#endif 

} 

//#if -1285147506 
catch (ObjectNotFoundException e) //1
{ 

//#if -1342137596 
out.println(HTMLCode.errorPage("Invalid login! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
//#endif 

} 

//#endif 


//#if -1218114677 
catch (FileNotFoundException e) //1
{ 

//#if 1675814955 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#if -459424102 
catch (TransactionException e) //1
{ 

//#if -1021223070 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#if -1239422048 
catch (Exception e) //1
{ 

//#if -1945561181 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 

finally { 

//#if -1988384375 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1645120743 
public void execute() throws Exception
    { 

//#if -630345066 
PrintWriter out = response.getWriter();
//#endif 


//#if -1448248988 
String login = request.getInput("login");
//#endif 


//#if -1030781566 
String password = request.getInput("password");
//#endif 


//#if -1145487267 
try //1
{ 

//#if -1379614164 
Employee employee = facade.searchEmployee(login);
//#endif 


//#if 134536676 
if(employee.validatePassword(password))//1
{ 

//#if 723167385 
employee.addObserver(facade);
//#endif 


//#if -1907027186 
request.setAuthorized(true);
//#endif 


//#if 12470941 
request.put(Login.EMPLOYEE, employee);
//#endif 


//#if 399262818 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
//#endif 

} 
else
{ 

//#if 1472059862 
out.println(HTMLCode.errorPage("Invalid password! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
//#endif 

} 

//#endif 

} 

//#if -1564845049 
catch (ObjectNotFoundException e) //1
{ 

//#if -1578523531 
out.println(HTMLCode.errorPage("Invalid login! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
//#endif 

} 

//#endif 


//#if 2120138052 
catch (FileNotFoundException e) //1
{ 

//#if 1455790637 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#if -1321569855 
catch (TransactionException e) //1
{ 

//#if 1830773412 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#if -1958494343 
catch (CommunicationException e) //1
{ 

//#if 1044150215 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -1265390887 
catch (Exception e) //1
{ 

//#if -345333466 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 736164544 
public Login(IFacade f)
    { 

//#if 666701665 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

