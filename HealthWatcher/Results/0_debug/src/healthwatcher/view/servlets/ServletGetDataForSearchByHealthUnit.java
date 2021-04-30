
//#if -979336152 
// Compilation Unit of /ServletGetDataForSearchByHealthUnit.java 
 

//#if 1053146226 
package healthwatcher.view.servlets;
//#endif 


//#if -611482139 
import healthwatcher.Constants;
//#endif 


//#if -1467257361 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 1922677561 
import java.io.IOException;
//#endif 


//#if -1752069502 
import java.io.PrintWriter;
//#endif 


//#if -103688525 
import java.rmi.RemoteException;
//#endif 


//#if -2141294459 
import javax.servlet.ServletException;
//#endif 


//#if -1866366065 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -381824905 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 1358761772 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1551969680 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -774727668 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1690245812 
import lib.exceptions.TransactionException;
//#endif 


//#if -2067896053 
import lib.util.HTMLCode;
//#endif 


//#if 1610205349 
import lib.util.IteratorDsk;
//#endif 


//#if 539275044 
public class ServletGetDataForSearchByHealthUnit extends 
//#if -1692989093 
HWServlet
//#endif 

  { 

//#if 1026206274 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -1933474193 
PrintWriter out;
//#endif 


//#if -126847071 
response.setContentType("text/html");
//#endif 


//#if 1410270321 
out = response.getWriter();
//#endif 


//#if -1249618421 
out.println(HTMLCode.open("Queries - Specialties"));
//#endif 


//#if -1725797998 
out.println("<body><h1>Queries:<br>Search Specialties of a Health unit</h1>");
//#endif 


//#if -1326046268 
out.println("<p>Choose a health unit: </p>");
//#endif 


//#if -31780832 
out.println("<form method=\"POST\"action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletSearchSpecialtiesByHealthUnit\">");
//#endif 


//#if -1488995820 
try //1
{ 

//#if 2023899644 
out.println("<div align=\"center\"><center><p><select name=\"codUnidadeSaude\" size=\"1\">");
//#endif 


//#if -483771746 
IteratorDsk repUS = facade.getPartialHealthUnitList();
//#endif 


//#if 585198046 
if(!repUS.hasNext())//1
{ 

//#if -1347133745 
out.println("</select></p></center></div>");
//#endif 


//#if -642907170 
out.println("<P> There isn't registered health units.</P>");
//#endif 

} 
else
{ 

//#if 663203639 
HealthUnit us;
//#endif 


//#if 1082410081 
do{ 

//#if 1479783515 
us = (HealthUnit) repUS.next();
//#endif 


//#if -1766772992 
out.println("<option value=\""+ us.getCode() + "\"> " + us.getDescription() + " </OPTION>");
//#endif 

} 
 while (repUS.hasNext());//1

//#endif 


//#if 610257467 
repUS.close();
//#endif 


//#if -1611962581 
out.println("</select></p></center></div>");
//#endif 


//#if 425046761 
out.println("<div align=\"center\"><center><p><input type=\"submit\" value=\"Consultar\" name=\"B1\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 61442319 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if 693438690 
catch(RemoteException e) //1
{ 

//#if -1377935938 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if 695248244 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -1528150678 
catch (ObjectNotFoundException e) //1
{ 

//#if -1753799720 
out.println("</select></p></center></div>");
//#endif 


//#if 1921847140 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 


//#if 631305640 
out.println("<P> Nenhuma unidade de saude foi cadastrada</P>");
//#endif 

} 

//#endif 


//#if 1471014374 
catch (RepositoryException e) //1
{ 

//#if 1363337886 
out.println("</select></p></center></div>");
//#endif 


//#if -486984098 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -982336706 
catch (TransactionException e) //1
{ 

//#if 1234931854 
out.println("</select></p></center></div>");
//#endif 


//#if -1570714002 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 1922014646 
catch (CommunicationException e) //1
{ 

//#if -1117808331 
out.println("</select></p></center></div>");
//#endif 


//#if -1233723609 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -2146800260 
catch(Exception e) //1
{ 

//#if -1901559838 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if 199767448 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 778559857 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

