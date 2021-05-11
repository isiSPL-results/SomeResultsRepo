
//#if 296113232
// Compilation Unit of /ServletUpdateComplaintData.java


//#if -2015117205
package healthwatcher.view.servlets;
//#endif


//#if 1279289656
import healthwatcher.model.complaint.Complaint;
//#endif


//#if -450185659
import healthwatcher.model.complaint.Situation;
//#endif


//#if 505487410
import healthwatcher.model.employee.Employee;
//#endif


//#if 1069394720
import java.io.IOException;
//#endif


//#if 1689614953
import java.io.PrintWriter;
//#endif


//#if -2063463125
import java.util.Calendar;
//#endif


//#if -99919298
import javax.servlet.ServletException;
//#endif


//#if 556132278
import javax.servlet.http.HttpServletRequest;
//#endif


//#if 1701179696
import javax.servlet.http.HttpServletResponse;
//#endif


//#if 1401244992
import javax.servlet.http.HttpSession;
//#endif


//#if -1390366502
import lib.exceptions.InvalidSessionException;
//#endif


//#if 907749042
import lib.util.HTMLCode;
//#endif


//#if -1676674135
public class ServletUpdateComplaintData extends
//#if -223660859
    HWServlet
//#endif

{

//#if 811759036
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if 1079006685
        PrintWriter out = response.getWriter();
//#endif


//#if -1681620845
        HttpSession session = request.getSession(false);
//#endif


//#if 1611991098
        String      obsQueixa = request.getParameter("obsQueixa");
//#endif


//#if -902069269
        Complaint     q         = null;
//#endif


//#if 41561553
        response.setContentType("text/html");
//#endif


//#if -1944057372
        try { //1

//#if -1356887640
            if(session == null) { //1

//#if 900346420
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -660833565
            q = (Complaint) session.getValue(ServletUpdateComplaintSearch.QUEIXA);
//#endif


//#if 465144619
            q.setObservacao(obsQueixa);
//#endif


//#if 519832440
            q.setSituacao(Situation.QUEIXA_FECHADA);
//#endif


//#if 475837070
            Calendar agora = Calendar.getInstance();
//#endif


//#if 2097831888
            q.setDataParecer(new lib.util.Date(agora.get(Calendar.DAY_OF_MONTH),
                                               agora.get(Calendar.MONTH),
                                               agora.get(Calendar.YEAR)));
//#endif


//#if -1121440581
            Employee employee = (Employee) session.getValue(ServletLogin.EMPLOYEE);
//#endif


//#if 1148016573
            q.setAtendente(employee);
//#endif


//#if 1189389815
            facade.updateComplaint(q);
//#endif


//#if -849455720
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Complaint updated"+"<P>" + obsQueixa + "</P>"));
//#endif

        }

//#if -1014623492
        catch(Exception e) { //1

//#if -143782750
            out.println(lib.util.HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if 388860561
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -1864979024
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

