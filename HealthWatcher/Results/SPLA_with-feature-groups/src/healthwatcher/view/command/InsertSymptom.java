
//#if 1522331563 
// Compilation Unit of /InsertSymptom.java 
 
package healthwatcher.view.command;

//#if 184751474 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if 1096975657 
import healthwatcher.view.IFacade;
//#endif 


//#if -776932072 
import java.io.IOException;
//#endif 


//#if -156711839 
import java.io.PrintWriter;
//#endif 


//#if -813486261 
import lib.exceptions.CommunicationException;
//#endif 


//#if -2033774802 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -2093583390 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -1768179450 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1765882187 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 2052228173 
import lib.exceptions.RepositoryException;
//#endif 


//#if -868436333 
import lib.exceptions.TransactionException;
//#endif 


//#if -37187926 
import lib.util.HTMLCode;
//#endif 


//#if 683122251 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class InsertSymptom extends Command
  { 
public InsertSymptom(IFacade f)
    { 
super(f);
} 


//#if -1295583593 
public void execute()
    { 
PrintWriter out=null;
Symptom symptom = null;
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
symptom = new Symptom(description);
symptom.setCode(Integer.parseInt(code));
facade.insert(symptom);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom inserted"));
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


//#if -1448302325 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
Symptom symptom = null;
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

String code = request.getInput("code");
String description = request.getInput("description");
symptom = new Symptom(description);
symptom.setCode(Integer.parseInt(code));
facade.insert(symptom);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom inserted"));
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

