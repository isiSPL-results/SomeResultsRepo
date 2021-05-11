package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
import lib.util.Library;
public class UpdateEmployeeSearch extends Command
{
    public void execute()
    {
        PrintWriter out = null;
        HttpSession session = request.getSession(false);
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
            Employee employee = (Employee) session
                                .getValue(Login.EMPLOYEE);
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
        } finally {
            out.close();
        }
    }
    public UpdateEmployeeSearch(IFacade f)
    {
        super(f);
    }

}
