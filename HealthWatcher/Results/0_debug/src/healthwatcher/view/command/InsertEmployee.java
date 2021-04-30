
//#if -1666715820 
// Compilation Unit of /InsertEmployee.java 
 

//#if 823828594 
package healthwatcher.view.command;
//#endif 


//#if -62174382 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -716701951 
import healthwatcher.view.IFacade;
//#endif 


//#if -1623040448 
import java.io.IOException;
//#endif 


//#if -1002820215 
import java.io.PrintWriter;
//#endif 


//#if -1475805172 
import java.rmi.RemoteException;
//#endif 


//#if 106391072 
import javax.servlet.http.HttpSession;
//#endif 


//#if 1492199510 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -1808012870 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -713654226 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 2051452707 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -1637429317 
import lib.exceptions.TransactionException;
//#endif 


//#if -1888345646 
import lib.util.HTMLCode;
//#endif 


//#if -1081368973 
import lib.exceptions.CommunicationException;
//#endif 


//#if -882072027 
import lib.exceptions.RepositoryException;
//#endif 


//#if -215729805 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if -1465809431 
public class InsertEmployee extends 
//#if -228206869 
Command
//#endif 

  { 

//#if -652007399 
public void execute()
    { 

//#if 1283219113 
PrintWriter out = null;
//#endif 


//#if -1958141701 
Employee employee;
//#endif 


//#if -1153675715 
HttpSession session = request.getSession(false);
//#endif 


//#if -477674117 
response.setContentType("text/html");
//#endif 


//#if -866009222 
try //1
{ 

//#if -62366182 
out = response.getWriter();
//#endif 

} 

//#if -779048244 
catch (IOException e1) //1
{ 

//#if -495512984 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 587890935 
try //2
{ 

//#if -1770699776 
if(session == null)//1
{ 

//#if -556571581 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -171025758 
String name = request.getParameter("name");
//#endif 


//#if 772141666 
String login = request.getParameter("login");
//#endif 


//#if -1498364766 
String password = request.getParameter("password");
//#endif 


//#if -708936887 
if(! request.isAuthorized())//1
{ 

//#if 101733628 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1678431839 
String name = request.getInput("name");
//#endif 


//#if 1106369347 
String login = request.getInput("login");
//#endif 


//#if 1758774305 
String password = request.getInput("password");
//#endif 


//#if 1594561224 
employee = new Employee(login, password, name);
//#endif 


//#if 1506768865 
facade.insert(employee);
//#endif 


//#if -361488777 
out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee inserted"));
//#endif 

} 

//#if 1706141570 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -757199625 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1014331100 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1454730509 
catch (ObjectNotValidException e) //1
{ 

//#if -511497885 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1819680784 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -94197238 
catch (InvalidSessionException e) //1
{ 

//#if -817998972 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1047892975 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 402079274 
catch (InsertEntryException e) //1
{ 

//#if -1901344915 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1258780890 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -774853873 
catch (TransactionException e) //1
{ 

//#if -875125708 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if 61159743 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 182631025 
catch (RemoteException e) //1
{ 

//#if -148754104 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -550445753 
catch (CommunicationException e) //1
{ 

//#if 1964424700 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1686677623 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1893349365 
catch(RepositoryException e) //1
{ 

//#if 575003829 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1548866851 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1973927928 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1325034898 
public InsertEmployee(IFacade f)
    { 

//#if 368334339 
super(f);
//#endif 

} 

//#endif 


//#if -145030327 
public void execute() throws Exception
    { 

//#if 436323292 
PrintWriter out = response.getWriter();
//#endif 


//#if 1682726066 
Employee employee;
//#endif 


//#if -1691439069 
try //1
{ 

//#if 1902468884 
if(! request.isAuthorized())//1
{ 

//#if 1952978207 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 2083965228 
String name = request.getInput("name");
//#endif 


//#if 407487502 
String login = request.getInput("login");
//#endif 


//#if 2049943724 
String password = request.getInput("password");
//#endif 


//#if 39558675 
employee = new Employee(login, password, name);
//#endif 


//#if 1714671596 
facade.insert(employee);
//#endif 


//#if 454188034 
out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee inserted"));
//#endif 

} 

//#if 752044351 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 1458804361 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if 2146595722 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1750514646 
catch (ObjectNotValidException e) //1
{ 

//#if -1606225016 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if -686924693 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1183919379 
catch (InvalidSessionException e) //1
{ 

//#if 70822824 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1966413749 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 826767399 
catch (InsertEntryException e) //1
{ 

//#if -16266163 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1569971782 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -350165748 
catch (TransactionException e) //1
{ 

//#if -1124798085 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1420195112 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -447050748 
catch (CommunicationException e) //1
{ 

//#if -1170013909 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -171161000 
catch(RepositoryException e) //1
{ 

//#if 615143411 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1533964575 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

