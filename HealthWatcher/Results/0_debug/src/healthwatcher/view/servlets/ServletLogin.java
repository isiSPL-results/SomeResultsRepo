
//#if -1638276135 
// Compilation Unit of /ServletLogin.java 
 

//#if 1667373503 
package healthwatcher.view.servlets;
//#endif 


//#if 1370836088 
import healthwatcher.Constants;
//#endif 


//#if 13632862 
import healthwatcher.model.employee.Employee;
//#endif 


//#if 1890079121 
import java.io.FileNotFoundException;
//#endif 


//#if -1493580980 
import java.io.IOException;
//#endif 


//#if -873360747 
import java.io.PrintWriter;
//#endif 


//#if -279400814 
import javax.servlet.ServletException;
//#endif 


//#if 64277730 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -661409404 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 1221763476 
import javax.servlet.http.HttpSession;
//#endif 


//#if 542011694 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 1272385181 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 615161031 
import lib.exceptions.TransactionException;
//#endif 


//#if 194468318 
import lib.util.HTMLCode;
//#endif 


//#if -210245435 
import lib.util.Library;
//#endif 


//#if 1482987642 
public class ServletLogin extends 
//#if 368107133 
HWServlet
//#endif 

  { 

//#if -1698747748 
private String[] keywords = {"##SYSTEM_ROOT##",
                                 "##SERVLET_SERVER_PATH##",
                                 "##CLOSE##"
                                };
//#endif 


//#if 1458211977 
private String[] newWords = {Constants.SYSTEM_ROOT,
                                 Constants.SERVLET_SERVER_PATH,
                                 HTMLCode.closeAdministrator()
                                };
//#endif 


//#if -1583629391 
public static final String EMPLOYEE = "employee";
//#endif 


//#if -1145388832 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -354688690 
PrintWriter out;
//#endif 


//#if 2026063106 
HttpSession session = request.getSession(false);
//#endif 


//#if 2015351104 
response.setContentType("text/html");
//#endif 


//#if 1941476496 
out = response.getWriter();
//#endif 


//#if -710092715 
try //1
{ 

//#if 1385688543 
if(session == null)//1
{ 

//#if 152668295 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif 

} 

//#endif 


//#if -1224323775 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
//#endif 

} 

//#if 1438211686 
catch (Exception e) //1
{ 

//#if -9596204 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 

} 

//#endif 

finally { 

//#if 542521575 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1800831116 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 1445995449 
PrintWriter out;
//#endif 


//#if -816086104 
HttpSession session = request.getSession(true);
//#endif 


//#if -1196318357 
response.setContentType("text/html");
//#endif 


//#if -138867397 
out = response.getWriter();
//#endif 


//#if 80553648 
String login = request.getParameter("login");
//#endif 


//#if -295238032 
String password = request.getParameter("password");
//#endif 


//#if 487530890 
try //1
{ 

//#if 2022093623 
Employee employee = facade.searchEmployee(login);
//#endif 


//#if 65473647 
if(employee.validatePassword(password))//1
{ 

//#if -2020018561 
session.putValue(ServletLogin.EMPLOYEE, employee);
//#endif 


//#if 2143010595 
out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
//#endif 

} 
else
{ 

//#if -1219204303 
out.println(HTMLCode.errorPage("Invalid password! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
//#endif 

} 

//#endif 

} 

//#if -815289591 
catch (ObjectNotFoundException e) //1
{ 

//#if -917294583 
out.println(HTMLCode.errorPage("Invalid login! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
//#endif 

} 

//#endif 


//#if -591928122 
catch (FileNotFoundException e) //1
{ 

//#if -1033750736 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#if -1824697857 
catch (TransactionException e) //1
{ 

//#if -523921275 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 


//#if 433751387 
catch (Exception e) //1
{ 

//#if -1194932645 
out.println(HTMLCode.errorPage(e.getMessage()));
//#endif 

} 

//#endif 

finally { 

//#if 55953437 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

