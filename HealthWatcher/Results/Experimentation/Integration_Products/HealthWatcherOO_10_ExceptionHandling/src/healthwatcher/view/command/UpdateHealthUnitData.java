package healthwatcher.view.command;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class UpdateHealthUnitData extends Command
  { 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
HealthUnit unit;
try//1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 
unit = (HealthUnit) request.get(UpdateHealthUnitSearch.HEALTH_UNIT);
String descricao = request.getInput("descricao");
unit.setDescription(descricao);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
} 
catch(Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
} 
} 
public UpdateHealthUnitData(IFacade f)
    { 
super(f);
} 

 } 
