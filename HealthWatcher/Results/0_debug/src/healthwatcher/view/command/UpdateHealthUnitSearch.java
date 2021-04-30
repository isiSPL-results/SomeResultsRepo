
//#if -1271440378 
// Compilation Unit of /UpdateHealthUnitSearch.java 
 

//#if 1830829553 
package healthwatcher.view.command;
//#endif 


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


//#if 591025332 
public class UpdateHealthUnitSearch extends 
//#if 389715679 
Command
//#endif 

  { 

//#if 1738788257 
public static final String HEALTH_UNIT = "health unit";
//#endif 


//#if 1347479716 
public UpdateHealthUnitSearch(IFacade f)
    { 

//#if 365376610 
super(f);
//#endif 

} 

//#endif 


//#if 1991481869 
public void execute()
    { 

//#if -898833581 
PrintWriter out=null;
//#endif 


//#if 343506131 
HttpSession session = request.getSession(false);
//#endif 


//#if -988845551 
response.setContentType("text/html");
//#endif 


//#if -1974381148 
try //1
{ 

//#if 846779750 
out = response.getWriter();
//#endif 


//#if -1068421181 
if(session == null)//1
{ 

//#if 821847532 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 69521228 
if(! request.isAuthorized())//1
{ 

//#if 1769884397 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if -1531654773 
out.println("Update Health Unit");
//#endif 


//#if 1364338221 
out.println("<script language=\"javascript\">");
//#endif 


//#if -307869889 
out.println("function submeterDados(modulo)");
//#endif 


//#if -906324647 
out.println("{");
//#endif 


//#if -2137501234 
String a1 = "\"";
//#endif 


//#if -1249997553 
String a2 = "\"";
//#endif 


//#if -358183861 
out.println("   var f = document.formAlterarUnidade2;");
//#endif 


//#if -440334324 
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif 


//#if 2141877849 
out.println("   {");
//#endif 


//#if 740064616 
out.println("           alert(\"Digite a nova descri��o da unidade!\");");
//#endif 


//#if -995283933 
out.println("           f.descricao.select();");
//#endif 


//#if -1238828343 
out.println("           return;");
//#endif 


//#if -906265065 
out.println("   }");
//#endif 


//#if 347164858 
out.println("   f.submit();");
//#endif 


//#if -378082085 
out.println("}");
//#endif 


//#if -1658589262 
out.println("//--></script>");
//#endif 


//#if 1218437706 
out.println("<body><h1>Update Health unit:</h1>");
//#endif 


//#if 240145480 
int numUS = (new Integer(request.getParameter("numUS"))).intValue();
//#endif 


//#if 411457031 
int numUS = (new Integer(request.getInput("numUS"))).intValue();
//#endif 


//#if -2131340390 
HealthUnit unit = facade.searchHealthUnit(numUS);
//#endif 


//#if 1160719806 
unit.addObserver(facade);
//#endif 


//#if -976289261 
session.putValue(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
//#endif 


//#if -1829367785 
request.put(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
//#endif 


//#if 113485887 
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitData\">");
//#endif 


//#if 2001389441 
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateHealthUnitData\">");
//#endif 


//#if 1350587598 
out.println("<div align=\"center\"><center><h4>Unit: " + numUS + "</h4></center></div>");
//#endif 


//#if -1845905128 
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + unit.getDescription() + "\" size=\"60\"></p></center></div>");
//#endif 


//#if -187901037 
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateHealthUnitData\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" ></h4></center></div></form>");
//#endif 


//#if 1726095324 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -781248372 
catch (CommunicationException e) //1
{ 

//#if 533159504 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 570041684 
catch (ObjectNotFoundException e) //1
{ 

//#if -863583882 
out.println("Health unit does not exist!");
//#endif 

} 

//#endif 


//#if 1340856165 
catch (InvalidSessionException e) //1
{ 

//#if 1496899606 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#if -961656112 
catch (RepositoryException e) //1
{ 

//#if 1863733494 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 914289556 
catch(TransactionException e) //1
{ 

//#if -2017136914 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -2038518900 
catch (IOException e) //1
{ 

//#if -232610695 
out.println(e.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -1403937077 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -373167403 
public void execute() throws Exception
    { 

//#if 1390670466 
PrintWriter out = response.getWriter();
//#endif 


//#if 139322697 
try //1
{ 

//#if 742909816 
if(! request.isAuthorized())//1
{ 

//#if 1775886387 
throw new InvalidSessionException();
//#endif 

} 

//#endif 


//#if 204593459 
int numUS = (new Integer(request.getInput("numUS"))).intValue();
//#endif 


//#if -853830714 
HealthUnit unit = facade.searchHealthUnit(numUS);
//#endif 


//#if -1779389934 
unit.addObserver(facade);
//#endif 


//#if 1763477099 
request.put(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
//#endif 


//#if 1349683895 
out.println("Update Health Unit");
//#endif 


//#if -1982534783 
out.println("<script language=\"javascript\">");
//#endif 


//#if -1929227885 
out.println("function submeterDados(modulo)");
//#endif 


//#if -631790163 
out.println("{");
//#endif 


//#if 728318458 
String a1 = "\"";
//#endif 


//#if 1615822139 
String a2 = "\"";
//#endif 


//#if 613930615 
out.println("   var f = document.formAlterarUnidade2;");
//#endif 


//#if -1114182344 
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif 


//#if -1114008187 
out.println("   {");
//#endif 


//#if 686218132 
out.println("           alert(\"Digite a nova descri��o da unidade!\");");
//#endif 


//#if -1240282505 
out.println("           f.descricao.select();");
//#endif 


//#if 201686045 
out.println("           return;");
//#endif 


//#if -631730581 
out.println("   }");
//#endif 


//#if 990185486 
out.println("   f.submit();");
//#endif 


//#if 660999175 
out.println("}");
//#endif 


//#if -985200674 
out.println("//--></script>");
//#endif 


//#if 544589686 
out.println("<body><h1>Update Health unit:</h1>");
//#endif 


//#if -897661845 
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitData\">");
//#endif 


//#if 817327021 
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateHealthUnitData\">");
//#endif 


//#if -1999241182 
out.println("<div align=\"center\"><center><h4>Unit: " + numUS + "</h4></center></div>");
//#endif 


//#if 1132935532 
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + unit.getDescription() + "\" size=\"60\"></p></center></div>");
//#endif 


//#if -149693721 
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateHealthUnitData\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" ></h4></center></div></form>");
//#endif 


//#if 1822732080 
out.println(HTMLCode.closeAdministrator());
//#endif 

} 

//#if -933889137 
catch (CommunicationException e) //1
{ 

//#if -164901451 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if 133145265 
catch (ObjectNotFoundException e) //1
{ 

//#if 884510595 
out.println("Health unit does not exist!");
//#endif 

} 

//#endif 


//#if 903959746 
catch (InvalidSessionException e) //1
{ 

//#if 1301672853 
out.println(e.getMessage());
//#endif 

} 

//#endif 


//#if -737476947 
catch (RepositoryException e) //1
{ 

//#if -1705981417 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -726090921 
catch(TransactionException e) //1
{ 

//#if 687591234 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

