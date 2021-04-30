package healthwatcher.view.command;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
public class InsertSymptom extends Command
  { 
public InsertSymptom(IFacade f)
    { 
super(f);
} 
public void execute()
    { 
PrintWriter out=null;
Symptom symptom = null;
try//1
{ 
try//1
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

 } 
