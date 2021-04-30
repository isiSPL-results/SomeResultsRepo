
//#if 1404691419 
// Compilation Unit of /InsertHealthUnit.java 
 
package healthwatcher.view.command;

//#if -1960660256 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 1781468889 
import healthwatcher.view.IFacade;
//#endif 


//#if 2093937000 
import java.io.IOException;
//#endif 


//#if -1580810063 
import java.io.PrintWriter;
//#endif 


//#if -891766885 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1014862978 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -225315438 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 491516246 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -660817157 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -1517134339 
import lib.exceptions.RepositoryException;
//#endif 


//#if 150475491 
import lib.exceptions.TransactionException;
//#endif 


//#if 1775853306 
import lib.util.HTMLCode;
//#endif 


//#if -227508581 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class InsertHealthUnit extends Command
  { 
public InsertHealthUnit(IFacade f)
    { 
super(f);
} 


//#if -1191387806 
public void execute()
    { 
PrintWriter out=null;
HealthUnit hu = null;
try //1
{ 
try //1
{ 
out = response.getWriter();
} 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 


if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

String code = request.getInput("code");
String description = request.getInput("description");
hu = new HealthUnit(description, null);
hu.setCode(Integer.parseInt(code));
facade.insert(hu);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "HealthUnit inserted"));
} 
catch (ObjectAlreadyInsertedException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch (ObjectNotValidException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch(InsertEntryException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch (InvalidSessionException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch(TransactionException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch(CommunicationException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
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

//#endif 


//#if -1093078304 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
HealthUnit hu = null;
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

String code = request.getInput("code");
String description = request.getInput("description");
hu = new HealthUnit(description, null);
hu.setCode(Integer.parseInt(code));
facade.insert(hu);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "HealthUnit inserted"));
} 
catch (ObjectAlreadyInsertedException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch (ObjectNotValidException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch(InsertEntryException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch (InvalidSessionException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch(TransactionException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

catch(CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch(RepositoryException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 


} 

//#endif 

 } 


//#endif 

