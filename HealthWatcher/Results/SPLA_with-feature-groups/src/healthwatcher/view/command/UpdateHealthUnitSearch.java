
//#if -1271440378 
// Compilation Unit of /UpdateHealthUnitSearch.java 
 
package healthwatcher.view.command;

//#if -909802901 
import healthwatcher.Constants;
//#endif 


//#if -1766840407 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if -1654049374 
import healthwatcher.view.IFacade;
//#endif 


//#if 513862335 
import java.io.IOException;
//#endif 


//#if 1134082568 
import java.io.PrintWriter;
//#endif 


//#if -674601919 
import javax.servlet.http.HttpSession;
//#endif 


//#if -693946661 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 36426826 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -1862161466 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1984445935 
import lib.util.HTMLCode;
//#endif 


//#if -1738168014 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1955430854 
import lib.exceptions.TransactionException;
//#endif 


//#if 1718406322 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class UpdateHealthUnitSearch extends Command
  { 
public static final String HEALTH_UNIT = "health unit";
public UpdateHealthUnitSearch(IFacade f)
    { 
super(f);
} 


//#if 1991481869 
public void execute()
    { 
PrintWriter out=null;

//#if 343506131 
HttpSession session = request.getSession(false);
//#endif 


//#if -988845551 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();

//#if -1068421181 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if 69521228 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

//#endif 

out.println("Update Health Unit");
out.println("<script language=\"javascript\">");
out.println("function submeterDados(modulo)");
out.println("{");
String a1 = "\"";
String a2 = "\"";
out.println("   var f = document.formAlterarUnidade2;");
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
out.println("   {");
out.println("           alert(\"Digite a nova descri��o da unidade!\");");
out.println("           f.descricao.select();");
out.println("           return;");
out.println("   }");
out.println("   f.submit();");
out.println("}");
out.println("//--></script>");
out.println("<body><h1>Update Health unit:</h1>");

//#if 240145480 
int numUS = (new Integer(request.getParameter("numUS"))).intValue();
//#endif 


//#if 411457031 
int numUS = (new Integer(request.getInput("numUS"))).intValue();
//#endif 

HealthUnit unit = facade.searchHealthUnit(numUS);

//#if 1160719806 
unit.addObserver(facade);
//#endif 


//#if -976289261 
session.putValue(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
//#endif 


//#if -1829367785 
request.put(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
//#endif 

out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitData\">");
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateHealthUnitData\">");
out.println("<div align=\"center\"><center><h4>Unit: " + numUS + "</h4></center></div>");
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + unit.getDescription() + "\" size=\"60\"></p></center></div>");
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateHealthUnitData\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" ></h4></center></div></form>");
out.println(HTMLCode.closeAdministrator());
} 

//#if -781248372 
catch (CommunicationException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 570041684 
catch (ObjectNotFoundException e) //1
{ 
out.println("Health unit does not exist!");
} 

//#endif 


//#if 1340856165 
catch (InvalidSessionException e) //1
{ 
out.println(e.getMessage());
} 

//#endif 


//#if -961656112 
catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 914289556 
catch(TransactionException e) //1
{ 
e.printStackTrace(out);
} 

//#endif 


//#if -2038518900 
catch (IOException e) //1
{ 
out.println(e.getMessage());
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 


//#if -373167403 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

int numUS = (new Integer(request.getInput("numUS"))).intValue();
HealthUnit unit = facade.searchHealthUnit(numUS);
unit.addObserver(facade);
request.put(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
out.println("Update Health Unit");
out.println("<script language=\"javascript\">");
out.println("function submeterDados(modulo)");
out.println("{");
String a1 = "\"";
String a2 = "\"";
out.println("   var f = document.formAlterarUnidade2;");
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
out.println("   {");
out.println("           alert(\"Digite a nova descri��o da unidade!\");");
out.println("           f.descricao.select();");
out.println("           return;");
out.println("   }");
out.println("   f.submit();");
out.println("}");
out.println("//--></script>");
out.println("<body><h1>Update Health unit:</h1>");
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitData\">");
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateHealthUnitData\">");
out.println("<div align=\"center\"><center><h4>Unit: " + numUS + "</h4></center></div>");
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + unit.getDescription() + "\" size=\"60\"></p></center></div>");
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateHealthUnitData\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" ></h4></center></div></form>");
out.println(HTMLCode.closeAdministrator());
} 
catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch (ObjectNotFoundException e) //1
{ 
out.println("Health unit does not exist!");
} 

catch (InvalidSessionException e) //1
{ 
out.println(e.getMessage());
} 

catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 

catch(TransactionException e) //1
{ 
e.printStackTrace(out);
} 


} 

//#endif 

 } 


//#endif 

