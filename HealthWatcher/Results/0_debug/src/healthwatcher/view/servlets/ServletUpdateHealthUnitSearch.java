
//#if -325596216 
// Compilation Unit of /ServletUpdateHealthUnitSearch.java 
 

//#if 486764874 
package healthwatcher.view.servlets;
//#endif 


//#if -224908787 
import healthwatcher.Constants;
//#endif 


//#if 1876936903 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if -1179864223 
import java.io.IOException;
//#endif 


//#if -559643990 
import java.io.PrintWriter;
//#endif 


//#if -1004816501 
import java.rmi.RemoteException;
//#endif 


//#if -972927139 
import javax.servlet.ServletException;
//#endif 


//#if 681951671 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if 1306613583 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 528237151 
import javax.servlet.http.HttpSession;
//#endif 


//#if -387887788 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1784932615 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -1054559128 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -767866140 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1902953180 
import lib.exceptions.TransactionException;
//#endif 


//#if -788444365 
import lib.util.HTMLCode;
//#endif 


//#if -79309443 
import lib.util.IteratorDsk;
//#endif 


//#if -362970859 
public class ServletUpdateHealthUnitSearch extends 
//#if 1681446794 
HWServlet
//#endif 

  { 

//#if 25831169 
public static final String HEALTH_UNIT = "health unit";
//#endif 


//#if -1097675213 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 2132224248 
PrintWriter out;
//#endif 


//#if -1512224980 
HttpSession session = request.getSession(false);
//#endif 


//#if 1686871402 
response.setContentType("text/html");
//#endif 


//#if -2019176518 
out = response.getWriter();
//#endif 


//#if 1354000747 
try //1
{ 

//#if 912117657 
if(session == null)//1
{ 

//#if 69408151 
throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif 

} 

//#endif 


//#if 39838434 
out.println("Queries - Complaint information");
//#endif 


//#if -803127226 
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
//#endif 


//#if -2053576678 
out.println("<p>Choose a complaint: </p>");
//#endif 


//#if 303152499 
out.println("<form method=\"POST\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletUpdateHealthUnitSearch\">");
//#endif 


//#if 1337905886 
out.println("<div align=\"center\"><center><p><select name=\"numUS\" size=\"1\">");
//#endif 


//#if 1803134215 
IteratorDsk repTP = facade.getHealthUnitList();
//#endif 


//#if -1717889804 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if 1409549967 
out.println("</select></p></center></div>");
//#endif 


//#if -903716689 
out.println("<p><font color=\"red\"><b> There isn't any health units.</b></font></p>");
//#endif 

} 
else
{ 

//#if 1756491654 
HealthUnit tp;
//#endif 


//#if -751312522 
do{ 

//#if 1948605397 
tp = (HealthUnit) repTP.next();
//#endif 


//#if -2080717698 
out.println("<option value=\""      +
                                tp.getCode() + "\"> " +
                                tp.getDescription()           +
                                " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if -1765995184 
repTP.close();
//#endif 


//#if -2029791970 
out.println("</select></p></center></div>");
//#endif 


//#if 1953481877 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"Search\" name=\"B1\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if -2074079418 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -439943708 
catch (ObjectNotFoundException e) //1
{ 

//#if 116083510 
out.println("There isn't any health units");
//#endif 

} 

//#endif 


//#if 1602673500 
catch (RemoteException e) //1
{ 

//#if -419517463 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -1554125984 
catch (RepositoryException e) //1
{ 

//#if -272165219 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -272407292 
catch (TransactionException e) //1
{ 

//#if -2045443136 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1264381436 
catch (CommunicationException e) //1
{ 

//#if -1258814931 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 330870773 
catch (InvalidSessionException e) //1
{ 

//#if 1950888403 
out.println(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if 2093905057 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -321708927 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 1749304702 
PrintWriter out;
//#endif 


//#if 1779053874 
HttpSession session = request.getSession(false);
//#endif 


//#if -1062080144 
response.setContentType("text/html");
//#endif 


//#if -1881834304 
out = response.getWriter();
//#endif 


//#if 1709833765 
try //1
{ 

//#if 1444076398 
if(session == null)//1
{ 

//#if 1511293410 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 2010337462 
out.println("Update Health Unit");
//#endif 


//#if -1501722718 
out.println("<script language=\"javascript\">");
//#endif 


//#if 162890228 
out.println("function submeterDados(modulo)");
//#endif 


//#if -1965457010 
out.println("{");
//#endif 


//#if -985474631 
String a1 = "\"";
//#endif 


//#if -97970950 
String a2 = "\"";
//#endif 


//#if 770226870 
out.println("   var f = document.formAlterarUnidade2;");
//#endif 


//#if 906089783 
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif 


//#if 359408132 
out.println("   {");
//#endif 


//#if 1374359763 
out.println("           alert(\"Digite a nova descri��o da unidade!\");");
//#endif 


//#if 143191000 
out.println("           f.descricao.select();");
//#endif 


//#if 181480254 
out.println("           return;");
//#endif 


//#if -1965397428 
out.println("   }");
//#endif 


//#if -2144190801 
out.println("   f.submit();");
//#endif 


//#if 2134415494 
out.println("}");
//#endif 


//#if -305184355 
out.println("//--></script>");
//#endif 


//#if -1730105483 
out.println("<body><h1>Update Health unit:</h1>");
//#endif 


//#if 1910467443 
int numUS = (new Integer(request.getParameter("numUS"))).intValue();
//#endif 


//#if -422678651 
HealthUnit unit = facade.searchHealthUnit(numUS);
//#endif 


//#if -140293459 
session.putValue(ServletUpdateHealthUnitSearch.HEALTH_UNIT, unit);
//#endif 


//#if -80318731 
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletUpdateHealthUnitData\">");
//#endif 


//#if 1057152963 
out.println("<div align=\"center\"><center><h4>Unit: " + numUS + "</h4></center></div>");
//#endif 


//#if 182075725 
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + unit.getDescription() + "\" size=\"60\"></p></center></div>");
//#endif 


//#if 1576847453 
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif 


//#if 1199211473 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 1739242022 
catch (ObjectNotFoundException e) //1
{ 

//#if -803953978 
out.println("Health unit does not exist!");
//#endif 

} 

//#endif 


//#if -1784910793 
catch (InvalidSessionException e) //1
{ 

//#if 422516326 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#if -1216472926 
catch (RepositoryException e) //1
{ 

//#if -2042147672 
e.printStackTrace();
//#endif 

} 

//#endif 

finally { 

//#if -415029898 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

