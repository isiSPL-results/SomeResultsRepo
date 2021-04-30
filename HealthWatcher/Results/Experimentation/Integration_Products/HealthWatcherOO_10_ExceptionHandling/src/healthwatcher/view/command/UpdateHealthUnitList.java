package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;
import lib.exceptions.FacadeUnavailableException;
public class UpdateHealthUnitList extends Command
  { 
public UpdateHealthUnitList(IFacade f)
    { 
super(f);
} 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try//1
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

 } 
