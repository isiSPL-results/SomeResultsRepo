package healthwatcher.view.command;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import lib.exceptions.InsertEntryException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.exceptions.CommunicationException;
public class InsertEmployee extends Command
  { 
public void execute()
    { 
PrintWriter out = null;
Employee employee;
HttpSession session = request.getSession(false);
response.setContentType("text/html");
try//1
{ 
out = response.getWriter();
} 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 
try//2
{ 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 
String name = request.getParameter("name");
String login = request.getParameter("login");
String password = request.getParameter("password");
employee = new Employee(login, password, name);
facade.insert(employee);
out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee inserted"));
} 
catch (ObjectAlreadyInsertedException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
catch (ObjectNotValidException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
catch (InvalidSessionException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
catch (InsertEntryException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
catch (TransactionException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
catch (CommunicationException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
finally { 
out.close();
} 
} 
public InsertEmployee(IFacade f)
    { 
super(f);
} 

 } 
