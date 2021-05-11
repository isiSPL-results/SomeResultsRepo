
//#if -1367516149
// Compilation Unit of /UpdateHealthUnitData.java


//#if -1114398703
package healthwatcher.view.command;
//#endif


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


//#if 1424753558
public class UpdateHealthUnitData extends
//#if -905367069
    Command
//#endif

{

//#if 955157841
    public void execute() throws Exception
    {

//#if 1600947567
        PrintWriter out = response.getWriter();
//#endif


//#if -1397717289
        HealthUnit unit;
//#endif


//#if -940612362
        try { //1

//#if 1409718674
            if(! request.isAuthorized()) { //1

//#if -1025398283
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 1492077592
            unit = (HealthUnit) request.get(UpdateHealthUnitSearch.HEALTH_UNIT);
//#endif


//#if -1257495988
            String descricao = request.getInput("descricao");
//#endif


//#if -1936971768
            unit.setDescription(descricao);
//#endif


//#if 384491411
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
//#endif

        }

//#if -1234360373
        catch(Exception e) { //1

//#if 190925136
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -13812958
    public UpdateHealthUnitData(IFacade f)
    {

//#if 123947203
        super(f);
//#endif

    }

//#endif


//#if 1937624849
    public void execute()
    {

//#if -1479733867
        PrintWriter out = null;
//#endif


//#if -2030060698
        try { //1

//#if -2022874925
            out = response.getWriter();
//#endif

        }

//#if -1360934659
        catch (IOException e1) { //1

//#if -141169862
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if -1780098940
        HttpSession session = request.getSession(true);
//#endif


//#if -261829617
        response.setContentType("text/html");
//#endif


//#if 1807904359
        HealthUnit unit;
//#endif


//#if -103682677
        try { //2

//#if -77367913
            if(session == null) { //1

//#if -358960815
                throw new InvalidSessionException();
//#endif

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

//#if 1313743114
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 990318282
            unit = (HealthUnit) request.get(UpdateHealthUnitSearch.HEALTH_UNIT);
//#endif


//#if 683903194
            String descricao = request.getInput("descricao");
//#endif


//#if -1500367046
            unit.setDescription(descricao);
//#endif


//#if -1276619451
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
//#endif


//#if 1386628382
            facade.updateHealthUnit(unit);
//#endif

        }

//#if -1777957512
        catch(Exception e) { //1

//#if -1111611354
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif

        }

//#endif

        finally {

//#if -1826555745
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

