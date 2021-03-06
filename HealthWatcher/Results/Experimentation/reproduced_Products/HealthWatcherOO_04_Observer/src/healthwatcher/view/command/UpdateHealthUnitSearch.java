package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.HTMLCode;
public class UpdateHealthUnitSearch extends Command
{
    public static final String HEALTH_UNIT = "health unit";
    public UpdateHealthUnitSearch(IFacade f)
    {
        super(f);
    }
    public void execute()
    {
        PrintWriter out=null;
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");
        try { //1
            out = response.getWriter();
            if(session == null) { //1
                throw new InvalidSessionException();
            }
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
            int numUS = (new Integer(request.getParameter("numUS"))).intValue();
            HealthUnit unit = facade.searchHealthUnit(numUS);
            unit.addObserver(facade);
            session.putValue(UpdateHealthUnitSearch.HEALTH_UNIT, unit);
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateHealthUnitData\">");
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateHealthUnitData\">");
            out.println("<div align=\"center\"><center><h4>Unit: " + numUS + "</h4></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + unit.getDescription() + "\" size=\"60\"></p></center></div>");
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateHealthUnitData\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" ></h4></center></div></form>");
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("Health unit does not exist!");
        } catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        } catch (RepositoryException e) { //1
            e.printStackTrace();
        } catch (IOException e) { //1
            out.println(e.getMessage());
        } finally {
            out.close();
        }
    }

}
