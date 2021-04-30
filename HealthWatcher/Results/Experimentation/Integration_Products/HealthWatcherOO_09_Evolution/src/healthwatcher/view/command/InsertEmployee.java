package healthwatcher.view.command;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import lib.exceptions.InsertEntryException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.exceptions.CommunicationException;
import lib.exceptions.RepositoryException;
public class InsertEmployee extends Command
  { 
public void execute()
    { 
PrintWriter out = null;
Employee employee;
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
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 
catch(RepositoryException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
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
