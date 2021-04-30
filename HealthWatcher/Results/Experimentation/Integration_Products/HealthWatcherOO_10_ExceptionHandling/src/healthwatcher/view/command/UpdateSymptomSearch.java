package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.exceptions.FacadeUnavailableException;
public class UpdateSymptomSearch extends Command
  { 
public static final String SYMPTOM = "symptom";
public UpdateSymptomSearch(IFacade f)
    { 
super(f);
} 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try//1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 
int symptomCode = (new Integer(request.getInput("symptomCode"))).intValue();
Symptom symptom = facade.searchSymptom(symptomCode);
symptom.addObserver(facade);
request.put(SYMPTOM, symptom);
out.println("Update Symptom");
out.println("<script language=\"javascript\">");
out.println("function submeterDados(modulo)");
out.println("{");
String a1 = "\"";
String a2 = "\"";
out.println("   var f = document.formAlterarUnidade2;");
out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
out.println("   {");
out.println("           alert(\"Digite a nova descri��o do sintoma!\");");
out.println("           f.descricao.select();");
out.println("           return;");
out.println("   }");
out.println("   f.operation.value = \"UpdateSymptomData\";");
out.println("   f.submit();");
out.println("}");
out.println("//--></script>");
out.println("<body><h1>Update Symptom:</h1>");
out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateSymptomData\">" );
out.println("<div align=\"center\"><center><h4>Symptom: " + symptomCode + "</h4></center></div>");
out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + symptom.getDescription() + "\" size=\"60\"></p></center></div>");
out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
out.println(HTMLCode.closeAdministrator());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("Symptom does not exist!");
} 
catch (InvalidSessionException e) //1
{ 
out.println(e.getMessage());
} 
catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 
catch (TransactionException e) //1
{ 
e.printStackTrace();
} 
catch(CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 
} 

 } 
