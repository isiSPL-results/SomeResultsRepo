
//#if -1112460437 
// Compilation Unit of /UpdateComplaintSearch.java 
 
package healthwatcher.view.command;

//#if -497277257 
import healthwatcher.Constants;
//#endif 


//#if 1617509503 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if 1145778083 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 2051483937 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if -583697232 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if -1274811274 
import healthwatcher.model.complaint.SpecialComplaint;
//#endif 


//#if -4022826 
import healthwatcher.view.IFacade;
//#endif 


//#if 493720843 
import java.io.IOException;
//#endif 


//#if 1113941076 
import java.io.PrintWriter;
//#endif 


//#if -858304479 
import java.rmi.RemoteException;
//#endif 


//#if 571249269 
import javax.servlet.http.HttpSession;
//#endif 


//#if 800118910 
import lib.exceptions.CommunicationException;
//#endif 


//#if 683536655 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 1413910142 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1968807930 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1121900384 
import lib.exceptions.SituationFacadeException;
//#endif 


//#if 840503430 
import lib.exceptions.TransactionException;
//#endif 


//#if -268267683 
import lib.util.HTMLCode;
//#endif 


//#if -88640002 
import lib.exceptions.FacadeUnavailableException;
//#endif 


//#if 248034936 
import lib.exceptions.ObjectNotValidException;
//#endif 

public class UpdateComplaintSearch extends Command
  { 
public static final String QUEIXA = "queixa";

//#if 971320757 
public void execute()
    { 
PrintWriter out= null;
try //1
{ 
out = response.getWriter();

//#if -1128224234 
HttpSession session = request.getSession(false);
//#endif 


//#if 1871546964 
response.setContentType("text/html");
//#endif 


//#if 799558341 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if 864842160 
int numQueixa = (new Integer(request.getParameter("numQueixa"))).intValue();
//#endif 


//#if -1151365170 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if 1241489007 
int numQueixa = (new Integer(request.getInput("numQueixa"))).intValue();
//#endif 

Complaint q = facade.searchComplaint(numQueixa);

//#if 366374181 
q.addObserver(facade);
//#endif 


//#if 1187383759 
session.putValue(UpdateComplaintSearch.QUEIXA, q);
//#endif 


//#if -1624965105 
request.put(UpdateComplaintSearch.QUEIXA, q);
//#endif 

if(q.getSituacao() != Situation.QUEIXA_ABERTA)//1
{ 
throw new SituationFacadeException("Complaint not open");
} 

out.println(HTMLCode.open("Update complaint"));
out.println("<script language=\"javascript\">");
out.println("function submeterDados(modulo)");
out.println("{");
String a1 = "\"";
String a2 = "\"";
out.println("   var f = document.formAlterarQueixa2;");
out.println("   if(f.obsQueixa.value ==" + a1 + a2 + ")");
out.println("   {");
out.println("           alert(\"Digite o parecer da queixa!\");");
out.println("           f.obsQueixa.select();");
out.println("           return;");
out.println("   }");
out.println("   f.submit();");
out.println("}");
out.println("//--></script>");
out.println("<body><h1>Update Complaint:</h1>");
out.println("<form method=\"POST\" name=\"formAlterarQueixa2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintData\">");
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateComplaintData\">");
out.println("<div align=\"center\"><center><h4>Complaint : " + numQueixa+ "</h4></center></div>");
String t = null;
if(q instanceof SpecialComplaint)//1
{ 
t = "Special complaint";
} 
else

//#if 988704717 
if(q instanceof FoodComplaint)//1
{ 
t = "Food complaint";
} 
else

//#if -1873387318 
if(q instanceof AnimalComplaint)//1
{ 
t = "Animal complaint";
} 

//#endif 


//#endif 


out.println("<div align=\"center\"><center><p><strong>Complaint kind: "+t+"</strong></p></center></div>");
out.println("<div align=\"center\"><center><p><strong>Description: "+ q.getDescricao() + "</strong></p></center></div>");
out.println("<div align=\"center\"><center><p><strong>Observation (complaint's solution):</strong><br><textarea rows=\"5\" name=\"obsQueixa\" cols=\"22\"></textarea></p></center></div>");
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateComplaintData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
out.println(HTMLCode.closeAdministrator());
} 

//#if 1926409685 
catch(RemoteException e) //1
{ 
out.println(HTMLCode.errorPage("Comunitation error, please try again later."));
} 

//#endif 


//#if -479528594 
catch (InvalidSessionException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
} 

//#endif 


//#if -1357260455 
catch (RepositoryException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
e.printStackTrace();
} 

//#endif 


//#if -1250343075 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator("Complaint does not exist!"));
} 

//#endif 


//#if -839970461 
catch (CommunicationException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
e.printStackTrace();
} 

//#endif 


//#if 1535456811 
catch (TransactionException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
e.printStackTrace();
} 

//#endif 


//#if -1571893627 
catch (SituationFacadeException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator("This complaint's status is closed!"));
} 

//#endif 


//#if 1013043989 
catch(IOException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 


//#if 143757869 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

int numQueixa = (new Integer(request.getInput("numQueixa"))).intValue();
Complaint q = facade.searchComplaint(numQueixa);
q.addObserver(facade);
request.put(UpdateComplaintSearch.QUEIXA, q);
if(q.getSituacao() != Situation.QUEIXA_ABERTA)//1
{ 
throw new ObjectNotValidException("Complaint not open");
} 

out.println(HTMLCode.open("Update complaint"));
out.println("<script language=\"javascript\">");
out.println("function submeterDados(modulo)");
out.println("{");
String a1 = "\"";
String a2 = "\"";
out.println("   var f = document.formAlterarQueixa2;");
out.println("   if(f.obsQueixa.value ==" + a1 + a2 + ")");
out.println("   {");
out.println("           alert(\"Digite o parecer da queixa!\");");
out.println("           f.obsQueixa.select();");
out.println("           return;");
out.println("   }");
out.println("   f.submit();");
out.println("}");
out.println("//--></script>");
out.println("<body><h1>Update Complaint:</h1>");
out.println("<form method=\"POST\" name=\"formAlterarQueixa2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintData\">");
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateComplaintData\">");
out.println("<div align=\"center\"><center><h4>Complaint : " + numQueixa+ "</h4></center></div>");
String t = null;
if(q instanceof SpecialComplaint)//1
{ 
t = "Special complaint";
} 
else
if(q instanceof FoodComplaint)//1
{ 
t = "Food complaint";
} 
else
if(q instanceof AnimalComplaint)//1
{ 
t = "Animal complaint";
} 



out.println("<div align=\"center\"><center><p><strong>Complaint kind: "+t+"</strong></p></center></div>");
out.println("<div align=\"center\"><center><p><strong>Description: "+ q.getDescricao() + "</strong></p></center></div>");
out.println("<div align=\"center\"><center><p><strong>Observation (complaint's solution):</strong><br><textarea rows=\"5\" name=\"obsQueixa\" cols=\"22\"></textarea></p></center></div>");
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateComplaintData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
out.println(HTMLCode.closeAdministrator());
} 
catch (InvalidSessionException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
} 

catch (RepositoryException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
e.printStackTrace();
} 

catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator("Complaint does not exist!"));
} 

catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch (TransactionException e) //1
{ 
out.println(HTMLCode.errorPage(e.getMessage()));
e.printStackTrace();
} 

catch (ObjectNotValidException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator("This complaint's status is closed!"));
} 


} 

//#endif 

public UpdateComplaintSearch(IFacade f)
    { 
super(f);
} 

 } 


//#endif 

