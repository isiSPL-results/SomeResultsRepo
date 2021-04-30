
//#if 1637668325 
// Compilation Unit of /UpdateEmployeeData.java 
 
package healthwatcher.view.command;

//#if -442438580 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -2014497209 
import healthwatcher.view.IFacade;
//#endif 


//#if 597830074 
import java.io.IOException;
//#endif 


//#if 1218050307 
import java.io.PrintWriter;
//#endif 


//#if -379352474 
import javax.servlet.http.HttpSession;
//#endif 


//#if -711301120 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 241337292 
import lib.util.HTMLCode;
//#endif 

public class UpdateEmployeeData extends Command
  { 
public UpdateEmployeeData(IFacade f)
    { 
super(f);
} 


//#if -1936010764 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
String name = request.getInput("name");
String newPassword = request.getInput("newPassword");
Employee employee = null;
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

employee = (Employee) request.get(Login.EMPLOYEE);
employee.setName(name);
if(!newPassword.equals(""))//1
{ 
employee.setPassword(newPassword);
} 

out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee updated"));
} 
catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
e.printStackTrace(out);
} 


} 

//#endif 


//#if -974964530 
public void execute()
    { 
PrintWriter out = null;

//#if -21314698 
HttpSession session = request.getSession(false);
//#endif 


//#if -492120185 
String name = request.getParameter("name");
//#endif 


//#if -1668679645 
String newPassword = request.getParameter("newPassword");
//#endif 


//#if -1334451962 
String name = request.getInput("name");
//#endif 


//#if 2143585732 
String newPassword = request.getInput("newPassword");
//#endif 

Employee employee = null;

//#if -1469643852 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if -1589698151 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 


try //2
{ 

//#if -1592264410 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if -869333372 
employee = (Employee) session.getValue(Login.EMPLOYEE);
//#endif 


//#if 1245018351 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if 1783691660 
employee = (Employee) request.get(Login.EMPLOYEE);
//#endif 

employee.setName(name);
if(!newPassword.equals(""))//1
{ 
employee.setPassword(newPassword);
} 

out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee updated"));

//#if 164164457 
facade.updateEmployee(employee);
//#endif 

} 

//#if 1668667898 
catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

