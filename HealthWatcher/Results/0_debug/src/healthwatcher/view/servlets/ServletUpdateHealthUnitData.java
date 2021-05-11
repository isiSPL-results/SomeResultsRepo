
//#if -1898087170
// Compilation Unit of /ServletUpdateHealthUnitData.java


//#if 1493519178
package healthwatcher.view.servlets;
//#endif


//#if -291757369
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if -1924294303
import java.io.IOException;
//#endif


//#if -1304074070
import java.io.PrintWriter;
//#endif


//#if 150317405
import javax.servlet.ServletException;
//#endif


//#if 1746479031
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -52776625
import javax.servlet.http.HttpServletResponse;
//#endif


//#if 1651481695
import javax.servlet.http.HttpSession;
//#endif


//#if 1150644473
import lib.exceptions.InvalidSessionException;
//#endif


//#if -1012682445
import lib.util.HTMLCode;
//#endif


//#if -1627133865
public class ServletUpdateHealthUnitData extends
//#if -30270919
    HWServlet
//#endif

{

//#if -193926352
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if -606629902
        PrintWriter out = response.getWriter();
//#endif


//#if -870339177
        HttpSession session = request.getSession(true);
//#endif


//#if -673565092
        response.setContentType("text/html");
//#endif


//#if -1931964300
        HealthUnit unit;
//#endif


//#if -1145985351
        try { //1

//#if -186722234
            if(session == null) { //1

//#if -1345734093
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -1369777542
            unit = (HealthUnit) session.getValue(ServletUpdateHealthUnitSearch.HEALTH_UNIT);
//#endif


//#if 1567927144
            String descricao = request.getParameter("descricao");
//#endif


//#if -973758165
            unit.setDescription(descricao);
//#endif


//#if 174538870
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
//#endif


//#if 1126521101
            facade.updateHealthUnit(unit);
//#endif

        }

//#if 1038436946
        catch(Exception e) { //1

//#if 787141217
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif

        }

//#endif

        finally {

//#if -1176143282
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

