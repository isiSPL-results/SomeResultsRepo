
//#if -1214055708 
// Compilation Unit of /UpdateSymptomList.java 
 

//#if 1521256069 
package healthwatcher.view.command;
//#endif 


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


//#if 2125740431 
public class UpdateSymptomList extends 
//#if -1652492022 
Command
//#endif 

  { 

//#if 531269066 
public void execute() throws Exception
    { 

//#if 96638923 
PrintWriter out = response.getWriter();
//#endif 


//#if 61784146 
try //1
{ 

//#if -731809144 
if(! request.isAuthorized())//1
{ 

//#if -1819108520 
throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
//#endif 

} 

//#endif 


//#if -235551838 
IteratorDsk repTP = facade.getSymptomList();
//#endif 


//#if -1621729914 
out.println("Queries - Symptom information");
//#endif 


//#if -479978695 
out.println("<body><h1>Queries:<br>Querie about symptoms</h1>");
//#endif 


//#if -1382110722 
out.println("<p>Choose a symptom: </p>");
//#endif 


//#if -1568620979 
out.println("<form method=\"POST\" action=\"http://"+ Constants.SERVLET_SERVER_PATH+ "HWServlet\">");
//#endif 


//#if 1891179862 
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomSearch\">" );
//#endif 


//#if 128978966 
out.println("<div align=\"center\"><center><p><select name=\"symptomCode\" size=\"1\">");
//#endif 


//#if -1351405734 
if(repTP == null || !repTP.hasNext())//1
{ 

//#if 924662209 
out.println("</select></p></center></div>");
//#endif 


//#if -1486113778 
out.println("<p><font color=\"red\"><b> There isn't any symptoms.</b></font></p>");
//#endif 

} 
else
{ 

//#if -886885284 
Symptom symptom;
//#endif 


//#if -1235868740 
do{ 

//#if -1676197659 
symptom = (Symptom) repTP.next();
//#endif 


//#if 1727422390 
out.println("<option value=\"" + symptom.getCode() + "\"> "
                                + symptom.getDescription() + " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if -643299178 
repTP.close();
//#endif 


//#if 1215058404 
out.println("</select></p></center></div>");
//#endif 


//#if -2053074161 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"Search\" name=\"B1\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if -305228256 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -1637972940 
catch (ObjectNotFoundException e) //1
{ 

//#if -56077764 
out.println("There isn't any symptom");
//#endif 

} 

//#endif 


//#if 1658132912 
catch (RepositoryException e) //1
{ 

//#if -1967674260 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 523370676 
catch (TransactionException e) //1
{ 

//#if -1205651154 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1502829996 
catch (CommunicationException e) //1
{ 

//#if -848195998 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -867158459 
catch (InvalidSessionException e) //1
{ 

//#if 67362939 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1791087566 
public UpdateSymptomList(IFacade f)
    { 

//#if 1037857720 
super(f);
//#endif 

} 

//#endif 


//#if -59173960 
public void execute()
    { 

//#if 522653985 
PrintWriter out = null;
//#endif 


//#if 1137812466 
try //1
{ 

//#if 873081974 
try //1
{ 

//#if -2025695845 
out = response.getWriter();
//#endif 

} 

//#if 460127631 
catch (IOException e1) //1
{ 

//#if -494386564 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 577452931 
if(! request.isAuthorized())//1
{ 

//#if -1414072310 
throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
//#endif 

} 

//#endif 


//#if 1194819073 
out.println("Queries - Symptom information");
//#endif 


//#if -51171276 
out.println("<body><h1>Queries:<br>Querie about symptoms</h1>");
//#endif 


//#if -1795080199 
out.println("<p>Choose a symptom: </p>");
//#endif 


//#if -1223258232 
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateSymptomSearch\">");
//#endif 


//#if -2053200879 
out.println("<div align=\"center\"><center><p><select name=\"symptomCode\" size=\"1\">");
//#endif 


//#if 2072061895 
IteratorDsk repTP = facade.getSymptomList();
//#endif 


//#if 485034005 
if(repTP == null || !repTP.hasNext())//1
{ 

//#if 1834375608 
out.println("</select></p></center></div>");
//#endif 


//#if -1984031163 
out.println("<p><font color=\"red\"><b> There isn't any symptoms.</b></font></p>");
//#endif 

} 
else
{ 

//#if 815236953 
Symptom symptom;
//#endif 


//#if -1578434401 
do{ 

//#if 1301749422 
symptom = (Symptom) repTP.next();
//#endif 


//#if 353391551 
out.println("<option value=\"" + symptom.getCode() + "\"> "
                                + symptom.getDescription() + " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if 1628365305 
repTP.close();
//#endif 


//#if -1055466489 
out.println("</select></p></center></div>");
//#endif 


//#if -1952406032 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateSymptomSearch\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 1108444421 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 1033774360 
catch (ObjectNotFoundException e) //1
{ 

//#if 1987835091 
out.println("There isn't any symptom");
//#endif 

} 

//#endif 


//#if -1901015916 
catch (RepositoryException e) //1
{ 

//#if 1758850977 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1858906704 
catch (TransactionException e) //1
{ 

//#if 569083894 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 757731400 
catch (CommunicationException e) //1
{ 

//#if -419836086 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1804588841 
catch (InvalidSessionException e) //1
{ 

//#if 522135524 
out.println(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -971736382 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

