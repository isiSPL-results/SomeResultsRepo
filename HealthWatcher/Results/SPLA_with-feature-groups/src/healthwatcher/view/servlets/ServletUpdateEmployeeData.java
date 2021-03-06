
//#if 558945737
// Compilation Unit of /ServletUpdateEmployeeData.java

package healthwatcher.view.servlets;
import healthwatcher.model.employee.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class ServletUpdateEmployeeData extends HWServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        HttpSession session = request.getSession(false);
        String name = request.getParameter("name");
        String newPassword = request.getParameter("newPassword");
        Employee employee = null;
        response.setContentType("text/html");
        out = response.getWriter();
        try { //1
            if(session == null) { //1
                throw new InvalidSessionException();
            }

            employee = (Employee) session.getValue(ServletLogin.EMPLOYEE);
            employee.setName(name);
            if(!newPassword.equals("")) { //1
                employee.setPassword(newPassword);
            }

            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Employee updated"));
            facade.updateEmployee(employee);
        } catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
            e.printStackTrace(out);
        }

        finally {
            out.close();
        }

    }

}


//#endif

