package healthwatcher.view.command;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class UpdateEmployeeData extends Command
{
    public UpdateEmployeeData(IFacade f)
    {
        super(f);
    }
    public void execute()
    {
        PrintWriter out = null;
        HttpSession session = request.getSession(false);
        String name = request.getParameter("name");
        String newPassword = request.getParameter("newPassword");
        Employee employee = null;
        response.setContentType("text/html");
        try { //1
            out = response.getWriter();
        } catch (IOException e1) { //1
            e1.printStackTrace();
        }
        try { //2
            if(session == null) { //1
                throw new InvalidSessionException();
            }
            employee = (Employee) session.getValue(Login.EMPLOYEE);
            employee.setName(name);
            if(!newPassword.equals("")) { //1
                employee.setPassword(newPassword);
            }
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee updated"));
            facade.updateEmployee(employee);
        } catch (Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }

}
