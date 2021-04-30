
//#if -1214055708 
// Compilation Unit of /UpdateSymptomList.java 
 
package healthwatcher.view.command;

//#if -1034603265 
import healthwatcher.Constants;
//#endif 


//#if -1460719891 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if -140014962 
import healthwatcher.view.IFacade;
//#endif 


//#if 813238099 
import java.io.IOException;
//#endif 


//#if 1433458332 
import java.io.PrintWriter;
//#endif 


//#if 1836009670 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1563588153 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -833214666 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -255699790 
import lib.exceptions.RepositoryException;
//#endif 


//#if 600240846 
import lib.exceptions.TransactionException;
//#endif 


//#if 1247146917 
import lib.util.HTMLCode;
//#endif 


//#if 1577320395 
import lib.util.IteratorDsk;
//#endif 


//#if 1471447622 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class UpdateSymptomList extends Command
  { 

//#if 531269066 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
} 

IteratorDsk repTP = facade.getSymptomList();
out.println("Queries - Symptom information");
out.println("<body><h1>Queries:<br>Querie about symptoms</h1>");
out.println("<p>Choose a symptom: </p>");
out.println("<form method=\"POST\" action=\"http://"+ Constants.SERVLET_SERVER_PATH+ "HWServlet\">");
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomSearch\">" );
out.println("<div align=\"center\"><center><p><select name=\"symptomCode\" size=\"1\">");
if(repTP == null || !repTP.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<p><font color=\"red\"><b> There isn't any symptoms.</b></font></p>");
} 
else
{ 
Symptom symptom;
do{ 
symptom = (Symptom) repTP.next();
out.println("<option value=\"" + symptom.getCode() + "\"> "
                                + symptom.getDescription() + " </OPTION>");
} 
 while (repTP.hasNext());//1

repTP.close();
out.println("</select></p></center></div>");
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"Search\" name=\"B1\"></p></center></div></form>");
} 

out.println(HTMLCode.closeAdministrator());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("There isn't any symptom");
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

public UpdateSymptomList(IFacade f)
    { 
super(f);
} 


//#if -59173960 
public void execute()
    { 
PrintWriter out = null;
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
throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
} 

out.println("Queries - Symptom information");
out.println("<body><h1>Queries:<br>Querie about symptoms</h1>");
out.println("<p>Choose a symptom: </p>");
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateSymptomSearch\">");
out.println("<div align=\"center\"><center><p><select name=\"symptomCode\" size=\"1\">");
IteratorDsk repTP = facade.getSymptomList();
if(repTP == null || !repTP.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<p><font color=\"red\"><b> There isn't any symptoms.</b></font></p>");
} 
else
{ 
Symptom symptom;
do{ 
symptom = (Symptom) repTP.next();
out.println("<option value=\"" + symptom.getCode() + "\"> "
                                + symptom.getDescription() + " </OPTION>");
} 
 while (repTP.hasNext());//1

repTP.close();
out.println("</select></p></center></div>");
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateSymptomSearch\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeAdministrator());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("There isn't any symptom");
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
e.printStackTrace();
} 

catch (InvalidSessionException e) //1
{ 
out.println(e.getMessage());
} 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

