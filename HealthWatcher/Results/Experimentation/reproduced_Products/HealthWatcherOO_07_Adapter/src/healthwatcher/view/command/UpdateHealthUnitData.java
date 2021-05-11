package healthwatcher.view.command;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class UpdateHealthUnitData extends Command
{
    public UpdateHealthUnitData(IFacade f)
    {
        super(f);
    }
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            out = response.getWriter();
        } catch (IOException e1) { //1
            e1.printStackTrace();
        }
        HealthUnit unit;
        try { //2
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }
            unit = (HealthUnit) request.get(UpdateHealthUnitSearch.HEALTH_UNIT);
            String descricao = request.getInput("descricao");
            unit.setDescription(descricao);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
        } catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
        } finally {
            out.close();
        }
    }

}
