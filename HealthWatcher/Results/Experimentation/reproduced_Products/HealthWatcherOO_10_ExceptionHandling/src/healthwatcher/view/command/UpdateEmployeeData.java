package healthwatcher.view.command;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class UpdateEmployeeData extends Command
{
    public UpdateEmployeeData(IFacade f)
    {
        super(f);
    }
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        String name = request.getInput("name");
        String newPassword = request.getInput("newPassword");
        Employee employee = null;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }
            employee = (Employee) request.get(Login.EMPLOYEE);
            employee.setName(name);
            if(!newPassword.equals("")) { //1
                employee.setPassword(newPassword);
            }
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee updated"));
        } catch (Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
            e.printStackTrace(out);
        }
    }

}
