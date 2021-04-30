
//#if -1103886862 
// Compilation Unit of /UpdateHealthUnitList.java 
 
package healthwatcher.view.command;

//#if -914219603 
import healthwatcher.Constants;
//#endif 


//#if 1509486887 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if -88032480 
import healthwatcher.view.IFacade;
//#endif 


//#if 98662145 
import java.io.IOException;
//#endif 


//#if 718882378 
import java.io.PrintWriter;
//#endif 


//#if -898615317 
import java.rmi.RemoteException;
//#endif 


//#if 180812479 
import javax.servlet.http.HttpSession;
//#endif 


//#if 1661495540 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1616408409 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -1948185400 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 783471428 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1545189764 
import lib.exceptions.TransactionException;
//#endif 


//#if -858622253 
import lib.util.HTMLCode;
//#endif 


//#if 900302301 
import lib.util.IteratorDsk;
//#endif 


//#if -1639589004 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class UpdateHealthUnitList extends Command
  { 
public UpdateHealthUnitList(IFacade f)
    { 
super(f);
} 


//#if 841538801 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
} 

IteratorDsk repTP = facade.getHealthUnitList();
out.println("Queries - Complaint information");
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
out.println("<p>Choose a complaint: </p>");
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitSearch\">");
out.println("<div align=\"center\"><center><p><select name=\"numUS\" size=\"1\">");
if(repTP==null||!repTP.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<p><font color=\"red\"><b> There isn't any health units.</b></font></p>");
} 
else
{ 
HealthUnit tp;
do{ 
tp = (HealthUnit) repTP.next();
out.println("<option value=\""      +
                                tp.getCode() + "\"> " +
                                tp.getDescription()           +
                                " </OPTION>");
} 
 while (repTP.hasNext());//1

repTP.close();
out.println("</select></p></center></div>");
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateHealthUnitSearch\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeAdministrator());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("There isn't any health units");
} 

catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 

catch (TransactionException e) //1
{ 
e.printStackTrace();
} 

catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch (InvalidSessionException e) //1
{ 
out.println(e.getMessage());
} 


} 

//#endif 


//#if -819842191 
public void execute()
    { 
PrintWriter out=null;

//#if -2076587550 
HttpSession session = request.getSession(false);
//#endif 


//#if 1431909920 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();

//#if 273257773 
if(session == null)//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
} 

//#endif 


//#if -1621821386 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
} 

//#endif 

out.println("Queries - Complaint information");
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
out.println("<p>Choose a complaint: </p>");
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitSearch\">");
out.println("<div align=\"center\"><center><p><select name=\"numUS\" size=\"1\">");
IteratorDsk repTP = facade.getHealthUnitList();
if(repTP==null||!repTP.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<p><font color=\"red\"><b> There isn't any health units.</b></font></p>");
} 
else
{ 
HealthUnit tp;
do{ 
tp = (HealthUnit) repTP.next();
out.println("<option value=\""      +
                                tp.getCode() + "\"> " +
                                tp.getDescription()           +
                                " </OPTION>");
} 
 while (repTP.hasNext());//1

repTP.close();
out.println("</select></p></center></div>");
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateHealthUnitSearch\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeAdministrator());
} 

//#if 1019572954 
catch (ObjectNotFoundException e) //1
{ 
out.println("There isn't any health units");
} 

//#endif 


//#if -1305696686 
catch (RemoteException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 1201228630 
catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if -755760178 
catch (TransactionException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 618725958 
catch (CommunicationException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 1790387435 
catch (InvalidSessionException e) //1
{ 
out.println(e.getMessage());
} 

//#endif 


//#if 769495570 
catch (IOException e) //1
{ 
out.println(e.getMessage());
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

