
//#if -1158004688 
// Compilation Unit of /ServletGetDataForSearchByDiseaseType.java 
 

//#if -137042042 
package healthwatcher.view.servlets;
//#endif 


//#if 1368178257 
import healthwatcher.Constants;
//#endif 


//#if -1208525006 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if -1451357787 
import java.io.IOException;
//#endif 


//#if -831137554 
import java.io.PrintWriter;
//#endif 


//#if 1136241607 
import java.rmi.RemoteException;
//#endif 


//#if 844048025 
import javax.servlet.ServletException;
//#endif 


//#if 72322811 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -412011893 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if -997516648 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1521782692 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 294790176 
import lib.exceptions.RepositoryException;
//#endif 


//#if 485560608 
import lib.exceptions.TransactionException;
//#endif 


//#if 1459315319 
import lib.util.HTMLCode;
//#endif 


//#if 94324665 
import lib.util.IteratorDsk;
//#endif 


//#if 1561574214 
public class ServletGetDataForSearchByDiseaseType extends 
//#if 1306973460 
HWServlet
//#endif 

  { 

//#if 264433513 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 1345316580 
PrintWriter out;
//#endif 


//#if -679353770 
response.setContentType("text/html");
//#endif 


//#if -175434074 
out = response.getWriter();
//#endif 


//#if 173575464 
out.println(HTMLCode.open("Queries - Disease information"));
//#endif 


//#if 771993802 
out.println("<body><h1>Queries:<br>Querie about diseases</h1>");
//#endif 


//#if 2009465301 
out.println("<p>Choose a disease: </p>");
//#endif 


//#if -1172285730 
out.println("<form method=\"POST\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletSearchDiseaseData\">");
//#endif 


//#if 208540159 
try //1
{ 

//#if 655938572 
out.println("<div align=\"center\"><center><p><select name=\"codTipoDoenca\" size=\"1\">");
//#endif 


//#if -843333145 
IteratorDsk repTP = facade.getDiseaseTypeList();
//#endif 


//#if -1698521080 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if -455972023 
out.println("</select></p></center></div>");
//#endif 


//#if 783076323 
out.println("<p><font color=\"red\"><b> There isn't diseases registered.</b></font></p>");
//#endif 

} 
else
{ 

//#if 955775 
DiseaseType tp;
//#endif 


//#if -1429882829 
do{ 

//#if -1964654110 
tp = (DiseaseType) repTP.next();
//#endif 


//#if 86759044 
out.println("<option value=\""+ tp.getCode() + "\"> " + tp.getName()+ " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if -953067635 
repTP.close();
//#endif 


//#if -1177397605 
out.println("</select></p></center></div>");
//#endif 


//#if 2083923545 
out.println("<div align=\"center\"><center><p><input type=\"submit\" value=\"Consultar\" name=\"B1\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if -616053941 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if -428041457 
catch(RemoteException e) //1
{ 

//#if -1980784054 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1993399296 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1650940567 
catch (ObjectNotFoundException e) //1
{ 

//#if 612088954 
out.println(HTMLCode.errorPageQueries("There isn't registered diseases"));
//#endif 

} 

//#endif 


//#if 892770707 
catch (RepositoryException e) //1
{ 

//#if 1657012400 
out.println("</select></p></center></div>");
//#endif 


//#if 1795236236 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -1728021199 
catch (TransactionException e) //1
{ 

//#if 1432970087 
out.println("</select></p></center></div>");
//#endif 


//#if 2045940277 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -1716211991 
catch (CommunicationException e) //1
{ 

//#if 230234228 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 

finally { 

//#if 596966325 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

