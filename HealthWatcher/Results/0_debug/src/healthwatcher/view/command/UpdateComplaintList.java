
//#if 1655438892 
// Compilation Unit of /UpdateComplaintList.java 
 

//#if 450825090 
package healthwatcher.view.command;
//#endif 


//#if 1273217148 
import healthwatcher.Constants;
//#endif 


//#if 1480105832 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -1698565647 
import healthwatcher.view.IFacade;
//#endif 


//#if 191551824 
import java.io.IOException;
//#endif 


//#if 811772057 
import java.io.PrintWriter;
//#endif 


//#if -960601840 
import javax.servlet.http.HttpSession;
//#endif 


//#if 1664152746 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if -1900441063 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 379461858 
import lib.util.HTMLCode;
//#endif 


//#if -515084946 
import lib.util.IteratorDsk;
//#endif 


//#if 226154638 
public class UpdateComplaintList extends 
//#if 598780426 
Command
//#endif 

  { 

//#if 1269253304 
public void execute()
    { 

//#if -819930918 
PrintWriter out= null;
//#endif 


//#if 1437365099 
try //1
{ 

//#if 1532161374 
out = response.getWriter();
//#endif 


//#if 1188506320 
HttpSession session = request.getSession(false);
//#endif 


//#if -1067096818 
response.setContentType("text/html");
//#endif 


//#if 1360395467 
if(session == null)//1
{ 

//#if 1281118618 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 976417364 
if(! request.isAuthorized())//1
{ 

//#if -1226088916 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -567397615 
out.println(HTMLCode.open("Queries - Complaint information"));
//#endif 


//#if -753170476 
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
//#endif 


//#if 1834518604 
out.println("<p>Choose a complaint: </p>");
//#endif 


//#if 2096760089 
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintSearch\">");
//#endif 


//#if -232699180 
IteratorDsk repTP = facade.getComplaintList();
//#endif 


//#if -511271386 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if 713433209 
out.println("<p><center><font color=\"red\"><b> There isn't any complaints.</b></font></center></p>");
//#endif 

} 
else
{ 

//#if 1979644646 
out.println("<div align=\"center\"><center><p><select name=\"numQueixa\" size=\"1\">");
//#endif 


//#if -1066709304 
Complaint tp;
//#endif 


//#if -659340943 
do{ 

//#if -1239351377 
tp = (Complaint) repTP.next();
//#endif 


//#if 302885328 
out.println("<option value=\""      +
                                tp.getCodigo() + "\"> " +
                                tp.getDescricao()      +
                                " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if 606358987 
repTP.close();
//#endif 


//#if 605244505 
out.println("</select></p></center></div>");
//#endif 


//#if 1052909920 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateComplaintSearch\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 1494428116 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -1921908354 
catch (ObjectNotFoundException e) //1
{ 

//#if 242528115 
out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
//#endif 

} 

//#endif 


//#if -1151093873 
catch(InvalidSessionException e) //1
{ 

//#if 1965938627 
out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif 

} 

//#endif 


//#if -1089472842 
catch(IOException e) //1
{ 

//#if 640292431 
out.println(HTMLCode.errorPageQueries(e.getMessage()));
//#endif 

} 

//#endif 


//#if 462167184 
catch(Exception e) //1
{ 

//#if -271461066 
out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
//#endif 


//#if -617732419 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 135787475 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1170983734 
public void execute() throws Exception
    { 

//#if 887957368 
PrintWriter out = response.getWriter();
//#endif 


//#if 1506348223 
try //1
{ 

//#if -1812828814 
if(! request.isAuthorized())//1
{ 

//#if -811669923 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1365290890 
IteratorDsk repTP = facade.getComplaintList();
//#endif 


//#if 998290611 
out.println(HTMLCode.open("Queries - Complaint information"));
//#endif 


//#if 1513121910 
out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
//#endif 


//#if 956773866 
out.println("<p>Choose a complaint: </p>");
//#endif 


//#if 972683963 
out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintSearch\">");
//#endif 


//#if -2122790204 
if(repTP==null||!repTP.hasNext())//1
{ 

//#if -1082240304 
out.println("<p><center><font color=\"red\"><b> There isn't any complaints.</b></font></center></p>");
//#endif 

} 
else
{ 

//#if 1155879810 
out.println("<div align=\"center\"><center><p><select name=\"numQueixa\" size=\"1\">");
//#endif 


//#if -746265756 
Complaint tp;
//#endif 


//#if -1490119411 
do{ 

//#if -1499620602 
tp = (Complaint) repTP.next();
//#endif 


//#if -1816864615 
out.println("<option value=\""      +
                                tp.getCodigo() + "\"> " +
                                tp.getDescricao()      +
                                " </OPTION>");
//#endif 

} 
 while (repTP.hasNext());//1

//#endif 


//#if -685036697 
repTP.close();
//#endif 


//#if -78417675 
out.println("</select></p></center></div>");
//#endif 


//#if 1174851140 
out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateComplaintSearch\" name=\"operation\"></p></center></div></form>");
//#endif 

} 

//#endif 


//#if 361836406 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -228971745 
catch (ObjectNotFoundException e) //1
{ 

//#if -1347953860 
out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
//#endif 

} 

//#endif 


//#if 541842736 
catch(InvalidSessionException e) //1
{ 

//#if -1013700434 
out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif 

} 

//#endif 


//#if -1075756047 
catch(Exception e) //1
{ 

//#if 1953538003 
out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
//#endif 


//#if 1713547328 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1070929676 
public UpdateComplaintList(IFacade f)
    { 

//#if 1912765028 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

