
//#if 1522331563 
// Compilation Unit of /InsertSymptom.java 
 

//#if 1213259594 
package healthwatcher.view.command;
//#endif 


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


//#if 22358118 
public class InsertSymptom extends 
//#if -799214999 
Command
//#endif 

  { 

//#if -622427101 
public InsertSymptom(IFacade f)
    { 

//#if 1453897476 
super(f);
//#endif 

} 

//#endif 


//#if -1295583593 
public void execute()
    { 

//#if -1389697224 
PrintWriter out=null;
//#endif 


//#if -193065014 
Symptom symptom = null;
//#endif 


//#if 976346697 
try //1
{ 

//#if 1049848226 
try //1
{ 

//#if -1031546712 
out = response.getWriter();
//#endif 

} 

//#if 605715058 
catch (IOException e1) //1
{ 

//#if -1143104278 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1667582801 
if(! request.isAuthorized())//1
{ 

//#if -469368769 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1176988473 
String code = request.getInput("code");
//#endif 


//#if 914947779 
String description = request.getInput("description");
//#endif 


//#if -1217669425 
symptom = new Symptom(description);
//#endif 


//#if -1633315684 
symptom.setCode(Integer.parseInt(code));
//#endif 


//#if -2135439660 
facade.insert(symptom);
//#endif 


//#if -1861582628 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom inserted"));
//#endif 

} 

//#if -845293973 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 113587669 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1931413059 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1646958550 
catch (ObjectNotValidException e) //1
{ 

//#if 936026549 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1029855779 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1471958099 
catch(InsertEntryException e) //1
{ 

//#if 1112360805 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -317602861 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -286425279 
catch (InvalidSessionException e) //1
{ 

//#if 620279396 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -830416366 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 295024952 
catch(TransactionException e) //1
{ 

//#if 1535419141 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -845883533 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1105921328 
catch(CommunicationException e) //1
{ 

//#if -1524043844 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1926255978 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 680935596 
catch(RepositoryException e) //1
{ 

//#if 428351011 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1505786129 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -108124434 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1448302325 
public void execute() throws Exception
    { 

//#if -2035663114 
PrintWriter out = response.getWriter();
//#endif 


//#if 574065470 
Symptom symptom = null;
//#endif 


//#if 686666941 
try //1
{ 

//#if -102347376 
if(! request.isAuthorized())//1
{ 

//#if -1007410707 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -462667544 
String code = request.getInput("code");
//#endif 


//#if -460825308 
String description = request.getInput("description");
//#endif 


//#if -264979600 
symptom = new Symptom(description);
//#endif 


//#if -1051441091 
symptom.setCode(Integer.parseInt(code));
//#endif 


//#if -1269171949 
facade.insert(symptom);
//#endif 


//#if -1309134181 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom inserted"));
//#endif 

} 

//#if 1839652782 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 1603539157 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -971366077 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 427357255 
catch (ObjectNotValidException e) //1
{ 

//#if -1457212420 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 971327914 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1340112214 
catch(InsertEntryException e) //1
{ 

//#if 231097784 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1549809562 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1787890526 
catch (InvalidSessionException e) //1
{ 

//#if -583268162 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 947740652 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 163179067 
catch(TransactionException e) //1
{ 

//#if -1478104923 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1772180755 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1043922573 
catch(CommunicationException e) //1
{ 

//#if 720130656 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -1401527479 
catch(RepositoryException e) //1
{ 

//#if -532093760 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1254199954 
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

