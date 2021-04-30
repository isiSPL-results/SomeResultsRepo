
//#if 1407538640 
// Compilation Unit of /ServletInsertEmployee.java 
 

//#if 483349878 
package healthwatcher.view.servlets;
//#endif 


//#if 529860487 
import healthwatcher.model.employee.Employee;
//#endif 


//#if 379792821 
import java.io.IOException;
//#endif 


//#if 1000013054 
import java.io.PrintWriter;
//#endif 


//#if 40229001 
import javax.servlet.ServletException;
//#endif 


//#if 580505355 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -1838222213 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 1541393291 
import javax.servlet.http.HttpSession;
//#endif 


//#if 1215720907 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -634801115 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -1821427869 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -1070302834 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -1913907920 
import lib.exceptions.TransactionException;
//#endif 


//#if 406473351 
import lib.util.HTMLCode;
//#endif 


//#if -235899329 
public class ServletInsertEmployee extends 
//#if 968099181 
HWServlet
//#endif 

  { 

//#if 1105552996 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 798958275 
PrintWriter out;
//#endif 


//#if -1299170955 
Employee employee;
//#endif 


//#if -276673609 
HttpSession session = request.getSession(false);
//#endif 


//#if -113812235 
response.setContentType("text/html");
//#endif 


//#if -22788155 
out = response.getWriter();
//#endif 


//#if 425013056 
try //1
{ 

//#if 1531575494 
if(session == null)//1
{ 

//#if 502727352 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1218120600 
String name = request.getParameter("name");
//#endif 


//#if -463654232 
String login = request.getParameter("login");
//#endif 


//#if 93075560 
String password = request.getParameter("password");
//#endif 


//#if 358765326 
employee = new Employee(login, password, name);
//#endif 


//#if -1066508889 
facade.insert(employee);
//#endif 


//#if -811620547 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Employee inserted"));
//#endif 

} 

//#if 1395009644 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -1677476000 
out.println(lib.util.HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -616498285 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1071310153 
catch (ObjectNotValidException e) //1
{ 

//#if -499213236 
out.println(lib.util.HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 740602919 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1863123872 
catch (InvalidSessionException e) //1
{ 

//#if 1703240738 
out.println(lib.util.HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1211882735 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1690174572 
catch(InsertEntryException e) //1
{ 

//#if -489029723 
out.println(lib.util.HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -784005650 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1427859577 
catch(TransactionException e) //1
{ 

//#if 144494257 
out.println(lib.util.HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1996599198 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 771563214 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

