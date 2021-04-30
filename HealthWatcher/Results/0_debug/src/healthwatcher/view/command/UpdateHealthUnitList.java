
//#if -1103886862 
// Compilation Unit of /UpdateHealthUnitList.java 
 

//#if -1162254285 
package healthwatcher.view.command;
//#endif 


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


//#if -1034829912 
public class UpdateHealthUnitList extends 
//#if -1864817085 
Command
//#endif 

  { 

//#if 459293366 
public UpdateHealthUnitList(IFacade f)
    { 

//#if 1305814296 
super(f);
//#endif 

} 

//#endif 


//#if 841538801 
public void execute() throws Exception
    { 

//#if -1359089481 
PrintWriter out = response.getWriter();
//#endif 


//#if 499793470 
try //1
{ 

//#if 1117809854 
if(! request.isAuthorized())//1
{ 

//#if -2008943236 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif 

} 

//#endif 


//#if 945018147 
IteratorDsk repTP = facade.getHealthUnitList();
//#endif 


//#if -818277634 
out.println("Queries - Complaint information");
//#endif 


//#if -1091796310 
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
//#endif 


//#if 895977014 
out.println("<p>Choose a complaint: </p>");
//#endif 


//#if -598086908 
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitSearch\">");
//#endif 


//#if -711187206 
out.println("<div align=\"center\"><center><p><select name=\"numUS\" size=\"1\">");
//#endif 


//#if -1010491120 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if -673471057 
out.println("</select></p></center></div>");
//#endif 


//#if 709211535 
out.println("<p><font color=\"red\"><b> There isn't any health units.</b></font></p>");
//#endif 

} 
else
{ 

//#if -1631730855 
HealthUnit tp;
//#endif 


//#if -33022845 
do{ 

//#if -740865164 
tp = (HealthUnit) repTP.next();
//#endif 


//#if -68917539 
out.println("<option value=\""      +
                                tp.getCode() + "\"> " +
                                tp.getDescription()           +
                                " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if 573289437 
repTP.close();
//#endif 


//#if 1409435371 
out.println("</select></p></center></div>");
//#endif 


//#if 234425131 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateHealthUnitSearch\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 1639017386 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 1093204617 
catch (ObjectNotFoundException e) //1
{ 

//#if -123579333 
out.println("There isn't any health units");
//#endif 

} 

//#endif 


//#if -1231420795 
catch (RepositoryException e) //1
{ 

//#if -1114721086 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1141518975 
catch (TransactionException e) //1
{ 

//#if -1610786476 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -1457108809 
catch (CommunicationException e) //1
{ 

//#if -613310626 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if 1864019098 
catch (InvalidSessionException e) //1
{ 

//#if -481284792 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -819842191 
public void execute()
    { 

//#if -1695933596 
PrintWriter out=null;
//#endif 


//#if -2076587550 
HttpSession session = request.getSession(false);
//#endif 


//#if 1431909920 
response.setContentType("text/html");
//#endif 


//#if -918253707 
try //1
{ 

//#if 735658556 
out = response.getWriter();
//#endif 


//#if 273257773 
if(session == null)//1
{ 

//#if 1183201921 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif 

} 

//#endif 


//#if -1621821386 
if(! request.isAuthorized())//1
{ 

//#if 532565370 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif 

} 

//#endif 


//#if 578366582 
out.println("Queries - Complaint information");
//#endif 


//#if -1357298126 
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
//#endif 


//#if 962468782 
out.println("<p>Choose a complaint: </p>");
//#endif 


//#if -602848132 
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitSearch\">");
//#endif 


//#if 1336795762 
out.println("<div align=\"center\"><center><p><select name=\"numUS\" size=\"1\">");
//#endif 


//#if -1953304933 
IteratorDsk repTP = facade.getHealthUnitList();
//#endif 


//#if -1752092024 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if -933481399 
out.println("</select></p></center></div>");
//#endif 


//#if -396878027 
out.println("<p><font color=\"red\"><b> There isn't any health units.</b></font></p>");
//#endif 

} 
else
{ 

//#if 2086837950 
HealthUnit tp;
//#endif 


//#if 1121955134 
do{ 

//#if 1188773149 
tp = (HealthUnit) repTP.next();
//#endif 


//#if -610934842 
out.println("<option value=\""      +
                                tp.getCode() + "\"> " +
                                tp.getDescription()           +
                                " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if -115194600 
repTP.close();
//#endif 


//#if -1014284570 
out.println("</select></p></center></div>");
//#endif 


//#if 1112004326 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateHealthUnitSearch\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if -1779612878 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 1019572954 
catch (ObjectNotFoundException e) //1
{ 

//#if 363392169 
out.println("There isn't any health units");
//#endif 

} 

//#endif 


//#if -1305696686 
catch (RemoteException e) //1
{ 

//#if -939871247 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1201228630 
catch (RepositoryException e) //1
{ 

//#if 408537204 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -755760178 
catch (TransactionException e) //1
{ 

//#if -1511787174 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 618725958 
catch (CommunicationException e) //1
{ 

//#if -864799271 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1790387435 
catch (InvalidSessionException e) //1
{ 

//#if -1352143556 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#if 769495570 
catch (IOException e) //1
{ 

//#if -505863270 
out.println(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -53277131 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

