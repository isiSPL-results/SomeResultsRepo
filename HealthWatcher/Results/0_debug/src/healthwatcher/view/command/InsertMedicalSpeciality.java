
//#if -120944686 
// Compilation Unit of /InsertMedicalSpeciality.java 
 

//#if -1229578590 
package healthwatcher.view.command;
//#endif 


//#if 1339033336 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 741079761 
import healthwatcher.view.IFacade;
//#endif 


//#if 1754729584 
import java.io.IOException;
//#endif 


//#if -1920017479 
import java.io.PrintWriter;
//#endif 


//#if -1170005853 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1895598458 
import lib.exceptions.InsertEntryException;
//#endif 


//#if -260788854 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -1235168674 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -696290573 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 532664821 
import lib.exceptions.RepositoryException;
//#endif 


//#if -730259989 
import lib.exceptions.TransactionException;
//#endif 


//#if -1317233662 
import lib.util.HTMLCode;
//#endif 


//#if -454089821 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if 593950747 
public class InsertMedicalSpeciality extends 
//#if -654382378 
Command
//#endif 

  { 

//#if 1308537732 
public void execute()
    { 

//#if 1720883969 
PrintWriter out=null;
//#endif 


//#if 416420118 
MedicalSpeciality speciality = null;
//#endif 


//#if -1432226350 
try //1
{ 

//#if -1118252669 
try //1
{ 

//#if -1486034891 
out = response.getWriter();
//#endif 

} 

//#if -659577774 
catch (IOException e1) //1
{ 

//#if 1655009619 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -103888496 
if(! request.isAuthorized())//1
{ 

//#if 1897639145 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -620249880 
String code = request.getInput("code");
//#endif 


//#if -145041116 
String description = request.getInput("description");
//#endif 


//#if -1403688537 
speciality = new MedicalSpeciality(description);
//#endif 


//#if -1017935189 
speciality.setCodigo(Integer.parseInt(code));
//#endif 


//#if 1386193487 
facade.insert(speciality);
//#endif 


//#if 770273981 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "MedicalSpecialty inserted"));
//#endif 

} 

//#if 850907259 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if -1508740102 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 162781224 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1946574822 
catch (ObjectNotValidException e) //1
{ 

//#if 653443615 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1906817549 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -837510557 
catch(InsertEntryException e) //1
{ 

//#if 319711411 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1053544543 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -586041551 
catch (InvalidSessionException e) //1
{ 

//#if -1204580868 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 998745002 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -2014443704 
catch(TransactionException e) //1
{ 

//#if -1662253347 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1060592971 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -2090332352 
catch(CommunicationException e) //1
{ 

//#if -2113585502 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -2111151920 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1576267932 
catch(RepositoryException e) //1
{ 

//#if 482235930 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1267969464 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1329307121 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1284494462 
public void execute() throws Exception
    { 

//#if -1118926796 
PrintWriter out = response.getWriter();
//#endif 


//#if -678574387 
MedicalSpeciality speciality = null;
//#endif 


//#if -1721033093 
try //1
{ 

//#if 1688456154 
if(! request.isAuthorized())//1
{ 

//#if 1572941533 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 689987506 
String code = request.getInput("code");
//#endif 


//#if 2077348462 
String description = request.getInput("description");
//#endif 


//#if -188331491 
speciality = new MedicalSpeciality(description);
//#endif 


//#if 197421857 
speciality.setCodigo(Integer.parseInt(code));
//#endif 


//#if -384476775 
facade.insert(speciality);
//#endif 


//#if -1467797625 
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "MedicalSpecialty inserted"));
//#endif 

} 

//#if 795975382 
catch (ObjectAlreadyInsertedException e) //1
{ 

//#if 1844145248 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 1890430222 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1763013151 
catch (ObjectNotValidException e) //1
{ 

//#if 1417477796 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -773762478 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1710190978 
catch(InsertEntryException e) //1
{ 

//#if -551401347 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -898246933 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1171420874 
catch (InvalidSessionException e) //1
{ 

//#if -1560534480 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1779810594 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1407843171 
catch(TransactionException e) //1
{ 

//#if -1061969477 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if -1453789527 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1077373083 
catch(CommunicationException e) //1
{ 

//#if 352157759 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -252998367 
catch(RepositoryException e) //1
{ 

//#if -626654724 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 


//#if 347150250 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -57123347 
public InsertMedicalSpeciality(IFacade f)
    { 

//#if -567306493 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

