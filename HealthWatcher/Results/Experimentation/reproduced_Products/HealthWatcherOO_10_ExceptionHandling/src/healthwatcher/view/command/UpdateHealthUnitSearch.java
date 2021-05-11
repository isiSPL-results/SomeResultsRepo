package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.HTMLCode;
import lib.exceptions.CommunicationException;
import lib.exceptions.TransactionException;
import lib.exceptions.FacadeUnavailableException;
public class UpdateHealthUnitSearch extends Command
{
    public static final String HEALTH_UNIT = "health unit";
    public UpdateHealthUnitSearch(IFacade f)
    {
        super(f);
    }
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            if(! request.isAuthorized()) { //1
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
        } catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        } catch (ObjectNotFoundException e) { //1
            out.println("Health unit does not exist!");
        } catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        } catch (RepositoryException e) { //1
            e.printStackTrace();
        } catch(TransactionException e) { //1
            e.printStackTrace(out);
        }
    }

}
