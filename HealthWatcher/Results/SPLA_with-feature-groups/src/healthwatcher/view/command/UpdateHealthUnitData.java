
//#if -1367516149
// Compilation Unit of /UpdateHealthUnitData.java

package healthwatcher.view.command;

//#if -83345015
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if 1576079234
import healthwatcher.view.IFacade;
//#endif


//#if -1658295073
import java.io.IOException;
//#endif


//#if -1038074840
import java.io.PrintWriter;
//#endif


//#if -82686431
import javax.servlet.http.HttpSession;
//#endif


//#if -942456645
import lib.exceptions.InvalidSessionException;
//#endif


//#if 846810161
import lib.util.HTMLCode;
//#endif

public class UpdateHealthUnitData extends Command
{

//#if 955157841
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        HealthUnit unit;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            unit = (HealthUnit) request.get(UpdateHealthUnitSearch.HEALTH_UNIT);
            String descricao = request.getInput("descricao");
            unit.setDescription(descricao);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
        } catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
        }


    }

//#endif

    public UpdateHealthUnitData(IFacade f)
    {
        super(f);
    }


//#if 1937624849
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            out = response.getWriter();
        }

//#if -1360934659
        catch (IOException e1) { //1
            e1.printStackTrace();
        }

//#endif



//#if -1780098940
        HttpSession session = request.getSession(true);
//#endif


//#if -261829617
        response.setContentType("text/html");
//#endif

        HealthUnit unit;
        try { //2

//#if -77367913
            if(session == null) { //1
                throw new InvalidSessionException();
            }

//#endif


//#if -953718892
            unit = (HealthUnit) session.getValue(UpdateHealthUnitSearch.HEALTH_UNIT);
//#endif


//#if -2056264455
            String descricao = request.getParameter("descricao");
//#endif


//#if 38329376
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

//#endif


//#if 990318282
            unit = (HealthUnit) request.get(UpdateHealthUnitSearch.HEALTH_UNIT);
//#endif


//#if 683903194
            String descricao = request.getInput("descricao");
//#endif

            unit.setDescription(descricao);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));

//#if 1386628382
            facade.updateHealthUnit(unit);
//#endif

        }

//#if -1777957512
        catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
        }

//#endif

        finally {
            out.close();
        }

    }

//#endif

}


//#endif

