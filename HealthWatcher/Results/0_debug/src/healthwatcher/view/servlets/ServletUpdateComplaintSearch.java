
//#if -421330304 
// Compilation Unit of /ServletUpdateComplaintSearch.java 
 

//#if 1301125067 
package healthwatcher.view.servlets;
//#endif 


//#if 2021537516 
import healthwatcher.Constants;
//#endif 


//#if 1189349108 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if -1485294120 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -697561898 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if 1080197861 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if -1662881631 
import healthwatcher.model.complaint.SpecialComplaint;
//#endif 


//#if 1562511296 
import java.io.IOException;
//#endif 


//#if -2112235767 
import java.io.PrintWriter;
//#endif 


//#if -84457844 
import java.rmi.RemoteException;
//#endif 


//#if -56829538 
import javax.servlet.ServletException;
//#endif 


//#if -215458730 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -743305072 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 1444334752 
import javax.servlet.http.HttpSession;
//#endif 


//#if -1285298189 
import lib.exceptions.CommunicationException;
//#endif 


//#if 460116026 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 1190489513 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -938160987 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1509171819 
import lib.exceptions.SituationFacadeException;
//#endif 


//#if 918780219 
import lib.exceptions.TransactionException;
//#endif 


//#if -1943131310 
import lib.util.HTMLCode;
//#endif 


//#if -965014274 
import lib.util.IteratorDsk;
//#endif 


//#if -1778936505 
public class ServletUpdateComplaintSearch extends 
//#if 1033532708 
HWServlet
//#endif 

  { 

//#if -1623072802 
public static final String QUEIXA = "queixa";
//#endif 


//#if 649579865 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 833782922 
PrintWriter out = response.getWriter();
//#endif 


//#if 1620542598 
HttpSession session = request.getSession(false);
//#endif 


//#if 1029559492 
response.setContentType("text/html");
//#endif 


//#if -465423023 
try //1
{ 

//#if 2035141631 
if(session == null)//1
{ 

//#if -606522846 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 1576038749 
out.println(HTMLCode.open("Queries - Complaint information"));
//#endif 


//#if 264093728 
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
//#endif 


//#if -1851476608 
out.println("<p>Choose a complaint: </p>");
//#endif 


//#if -535171322 
out.println("<form method=\"POST\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletUpdateComplaintSearch\">");
//#endif 


//#if -287203040 
IteratorDsk repTP = facade.getComplaintList();
//#endif 


//#if 2025948506 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if 354130695 
out.println("<p><center><font color=\"red\"><b> There isn't any complaints.</b></font></center></p>");
//#endif 

} 
else
{ 

//#if -1942704978 
out.println("<div align=\"center\"><center><p><select name=\"numQueixa\" size=\"1\">");
//#endif 


//#if -1729787760 
Complaint tp;
//#endif 


//#if 1640021305 
do{ 

//#if -1131230216 
tp = (Complaint) repTP.next();
//#endif 


//#if -2096890009 
out.println("<option value=\""      +
                                tp.getCodigo() + "\"> " +
                                tp.getDescricao()      +
                                " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if -956877421 
repTP.close();
//#endif 


//#if -302750175 
out.println("</select></p></center></div>");
//#endif 


//#if 1175274802 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"Search\" name=\"B1\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 1439924256 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 1481995995 
catch (ObjectNotFoundException e) //1
{ 

//#if 247381472 
out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
//#endif 

} 

//#endif 


//#if -2042156820 
catch(InvalidSessionException e) //1
{ 

//#if -1925994359 
out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif 

} 

//#endif 


//#if 2021755053 
catch(Exception e) //1
{ 

//#if 190742459 
out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
//#endif 


//#if -1381234344 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1386465529 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1991376357 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -1618566173 
PrintWriter out = response.getWriter();
//#endif 


//#if 327063885 
HttpSession session = request.getSession(false);
//#endif 


//#if -1978818421 
response.setContentType("text/html");
//#endif 


//#if -1862367638 
try //1
{ 

//#if 1035897520 
if(session == null)//1
{ 

//#if 1545471125 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1724767717 
int numQueixa = (new Integer(request.getParameter("numQueixa"))).intValue();
//#endif 


//#if -14409935 
Complaint q = facade.searchComplaint(numQueixa);
//#endif 


//#if 1385915897 
session.putValue(ServletUpdateComplaintSearch.QUEIXA, q);
//#endif 


//#if 1842155577 
if(q.getSituacao() != Situation.QUEIXA_ABERTA)//1
{ 

//#if -1250962300 
throw new SituationFacadeException("Complaint not open");
//#endif 

} 

//#endif 


//#if 1590166736 
out.println(HTMLCode.open("Update complaint"));
//#endif 


//#if 1172332320 
out.println("<script language=\"javascript\">");
//#endif 


//#if -1841028878 
out.println("function submeterDados(modulo)");
//#endif 


//#if 473164172 
out.println("{");
//#endif 


//#if 103522939 
String a1 = "\"";
//#endif 


//#if 991026620 
String a2 = "\"";
//#endif 


//#if -759382017 
out.println("   var f = document.formAlterarQueixa2;");
//#endif 


//#if 851124465 
out.println("   if(f.obsQueixa.value ==" + a1 + a2 + ")");
//#endif 


//#if -48770746 
out.println("   {");
//#endif 


//#if -1874320893 
out.println("           alert(\"Digite o parecer da queixa!\");");
//#endif 


//#if -1401580466 
out.println("           f.obsQueixa.select();");
//#endif 


//#if -823059268 
out.println("           return;");
//#endif 


//#if 473223754 
out.println("   }");
//#endif 


//#if 1742815533 
out.println("   f.submit();");
//#endif 


//#if 1726236616 
out.println("}");
//#endif 


//#if 887244383 
out.println("//--></script>");
//#endif 


//#if -408736810 
out.println("<body><h1>Update Complaint:</h1>");
//#endif 


//#if 1186978483 
out.println("<form method=\"POST\" name=\"formAlterarQueixa2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletUpdateComplaintData\">");
//#endif 


//#if -1513695641 
out.println("<div align=\"center\"><center><h4>Complaint : " + numQueixa+ "</h4></center></div>");
//#endif 


//#if 354427556 
String t = null;
//#endif 


//#if 1203736994 
if(q instanceof SpecialComplaint)//1
{ 

//#if -2073161116 
t = "Special complaint";
//#endif 

} 
else

//#if -137162843 
if(q instanceof FoodComplaint)//1
{ 

//#if 161089027 
t = "Food complaint";
//#endif 

} 
else

//#if -1437398989 
if(q instanceof AnimalComplaint)//1
{ 

//#if -829231374 
t = "Animal complaint";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if 1057839351 
out.println("<div align=\"center\"><center><p><strong>Complaint kind: "+t+"</strong></p></center></div>");
//#endif 


//#if -2145062887 
out.println("<div align=\"center\"><center><p><strong>Description: "+ q.getDescricao() + "</strong></p></center></div>");
//#endif 


//#if -546370802 
out.println("<div align=\"center\"><center><p><strong>Observation (complaint's solution):</strong><br><textarea rows=\"5\" name=\"obsQueixa\" cols=\"22\"></textarea></p></center></div>");
//#endif 


//#if -1661849253 
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif 


//#if -125777329 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if 1369529160 
catch(RemoteException e) //1
{ 

//#if 1170042622 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 

} 

//#endif 


//#if -302349343 
catch (InvalidSessionException e) //1
{ 

//#if 2127011056 
out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif 

} 

//#endif 


//#if 52335948 
catch (RepositoryException e) //1
{ 

//#if 2016960622 
out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
//#endif 


//#if 739848142 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -1073163824 
catch (ObjectNotFoundException e) //1
{ 

//#if 1295170456 
out.println(HTMLCode.errorPageAdministrator("Complaint does not exist!"));
//#endif 

} 

//#endif 


//#if 551218320 
catch (CommunicationException e) //1
{ 

//#if -2065391169 
out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
//#endif 


//#if 1947704285 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -2011694952 
catch (TransactionException e) //1
{ 

//#if 1255143152 
out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
//#endif 


//#if 435849228 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -374304142 
catch (SituationFacadeException e) //1
{ 

//#if -2128758114 
out.println(HTMLCode.errorPageAdministrator("This complaint's status is closed!"));
//#endif 

} 

//#endif 

finally { 

//#if 837498552 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

