
//#if -455109041 
// Compilation Unit of /InsertDiseaseType.java 
 

//#if -62064865 
package healthwatcher.view.command;
//#endif 


//#if 800530810 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if -1438015820 
import healthwatcher.view.IFacade;
//#endif 


//#if 1580773869 
import java.io.IOException;
//#endif 


//#if -2093973194 
import java.io.PrintWriter;
//#endif 


//#if 651641056 
import lib.exceptions.CommunicationException;
//#endif 


//#if 28082691 
import lib.exceptions.InsertEntryException;
//#endif 


//#if 375690477 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 824403355 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -59811242 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 1010361048 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1193421160 
import lib.exceptions.TransactionException;
//#endif 


//#if 1095990463 
import lib.util.HTMLCode;
//#endif 


//#if -1378951840 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if 806274600 
public class InsertDiseaseType extends 
//#if -1149983226 
Command
//#endif 

  { 

//#if -1757075788 
public void execute()
    { 

//#if 786959487 
PrintWriter out=null;
//#endif 


//#if 172401 
DiseaseType diseaseType = null;
//#endif 


//#if 1862319056 
try //1
{ 

//#if 1558014634 
try //1
{ 

//#if -565605356 
out = response.getWriter();
//#endif 

} 

//#if 1923339525 
catch (IOException e1) //1
{ 

//#if 554699159 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 1320426935 
if(! request.isAuthorized())//1
{ 

//#if -1056403191 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -894363697 
String code = request.getInput("code");
//#endif 


//#if 899072399 
String name = request.getInput("name");
//#endif 


//#if 60527563 
String description = request.getInput("description");
//#endif 


//#if 838931727 
String manifestacao = request.getInput("manifestacao");
//#endif 


//#if 1849542063 
String duration = request.getInput("duration");
//#endif 


//#if 701604510 
diseaseType = new DiseaseType(name, description, manifestacao, duration, null);
//#endif 


//#if -1681515881 
diseaseType.setCode(Integer.parseInt(code));
//#endif 


//#if 1519937465 
facade.insert(diseaseType);
//#endif 


//#if -1416364799 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "DiseaseType inserted"));
//#endif 

} 

//#if 1483142921 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -449058297 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 2102956021 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -383869620 
catch (ObjectNotValidException e) //1
{ 

//#if -1761534497 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 154461645 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -2038826383 
catch(InsertEntryException e) //1
{ 

//#if 1465719367 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1161564107 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 976663651 
catch (InvalidSessionException e) //1
{ 

//#if 1786847846 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1209436268 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1079207766 
catch(TransactionException e) //1
{ 

//#if 996002597 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1359013997 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1208638514 
catch(CommunicationException e) //1
{ 

//#if -1444676317 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 611031057 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1233430834 
catch(RepositoryException e) //1
{ 

//#if 930005128 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 524279606 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 1170555382 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1889066003 
public InsertDiseaseType(IFacade f)
    { 

//#if -1124019363 
super(f);
//#endif 

} 

//#endif 


//#if 1619958606 
public void execute() throws Exception
    { 

//#if 987253310 
PrintWriter out = response.getWriter();
//#endif 


//#if -1748873754 
DiseaseType diseaseType = null;
//#endif 


//#if 691875333 
try //1
{ 

//#if 152656581 
if(! request.isAuthorized())//1
{ 

//#if -106446572 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 638308957 
String code = request.getInput("code");
//#endif 


//#if -1863222243 
String name = request.getInput("name");
//#endif 


//#if -1134707239 
String description = request.getInput("description");
//#endif 


//#if -1025444963 
String manifestacao = request.getInput("manifestacao");
//#endif 


//#if -969665987 
String duration = request.getInput("duration");
//#endif 


//#if 921611820 
diseaseType = new DiseaseType(name, description, manifestacao, duration, null);
//#endif 


//#if -205756635 
diseaseType.setCode(Integer.parseInt(code));
//#endif 


//#if -2112031381 
facade.insert(diseaseType);
//#endif 


//#if -2075614285 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "DiseaseType inserted"));
//#endif 

} 

//#if -301667529 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 343078322 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 671278048 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1529536734 
catch (ObjectNotValidException e) //1
{ 

//#if -1859525660 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 421013394 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1966821345 
catch(InsertEntryException e) //1
{ 

//#if -1968765999 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1580404417 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1404897291 
catch (InvalidSessionException e) //1
{ 

//#if 1113410753 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1092120111 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1151212804 
catch(TransactionException e) //1
{ 

//#if 1884033549 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1620331643 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -731273732 
catch(CommunicationException e) //1
{ 

//#if -1771375729 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if 1816933216 
catch(RepositoryException e) //1
{ 

//#if 1285325666 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 877082000 
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

