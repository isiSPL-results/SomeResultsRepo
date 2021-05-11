
//#if 558945737
// Compilation Unit of /ServletUpdateEmployeeData.java


//#if 1923345887
package healthwatcher.view.servlets;
//#endif


//#if -443886274
import healthwatcher.model.employee.Employee;
//#endif


//#if -365769940
import java.io.IOException;
//#endif


//#if 254450293
import java.io.PrintWriter;
//#endif


//#if 896924338
import javax.servlet.ServletException;
//#endif


//#if -393241406
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -1959600732
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -1896878668
import javax.servlet.http.HttpSession;
//#endif


//#if -756179634
import lib.exceptions.InvalidSessionException;
//#endif


//#if -818882114
import lib.util.HTMLCode;
//#endif


//#if 1683682640
public class ServletUpdateEmployeeData extends
//#if -504217836
    HWServlet
//#endif

{

//#if 1832553483
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if 1402356678
        PrintWriter out;
//#endif


//#if 1237583226
        HttpSession session = request.getSession(false);
//#endif


//#if -1046912253
        String name = request.getParameter("name");
//#endif


//#if 1810938527
        String newPassword = request.getParameter("newPassword");
//#endif


//#if -2087302630
        Employee employee = null;
//#endif


//#if -45839944
        response.setContentType("text/html");
//#endif


//#if 328483080
        out = response.getWriter();
//#endif


//#if -505721123
        try { //1

//#if 5005837
            if(session == null) { //1

//#if 964134074
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -1419513276
            employee = (Employee) session.getValue(ServletLogin.EMPLOYEE);
//#endif


//#if -263870523
            employee.setName(name);
//#endif


//#if 1323772196
            if(!newPassword.equals("")) { //1

//#if 648206764
                employee.setPassword(newPassword);
//#endif

            }

//#endif


//#if -265857823
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Employee updated"));
//#endif


//#if -1378076208
            facade.updateEmployee(employee);
//#endif

        }

//#if 1420146132
        catch(Exception e) { //1

//#if 1129406669
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
//#endif


//#if 2126799107
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if 325106453
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

