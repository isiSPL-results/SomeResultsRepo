package healthwatcher.view.command;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.InsertEntryException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.exceptions.CommunicationException;
import lib.exceptions.RepositoryException;
import lib.exceptions.FacadeUnavailableException;
public class InsertEmployee extends Command
  { 
public InsertEmployee(IFacade f)
    { 
super(f);
} 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
Employee employee;
try//1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 
String name = request.getInput("name");
String login = request.getInput("login");
String password = request.getInput("password");
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
throw new FacadeUnavailableException();
} 
catch(RepositoryException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
} 

 } 
