package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
import lib.util.Library;
public class UpdateEmployeeSearch extends Command
{
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }
            Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
            String[] keywords = { "##LOGIN##", "##NAME##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
            String[] newWords = { employee.getLogin(), employee.getName(),
                                  Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };
            out.println(Library.getFileListReplace(keywords, newWords,
                                                   Constants.FORM_PATH + "UpdateEmployee.html"));
        } catch (InvalidSessionException e) { //1
            out
            .println(HTMLCode
                     .errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""
                                             + Constants.SYSTEM_LOGIN
                                             + "\">login</a> again!"));
        } catch (FileNotFoundException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
        }
    }
    public UpdateEmployeeSearch(IFacade f)
    {
        super(f);
    }

}
