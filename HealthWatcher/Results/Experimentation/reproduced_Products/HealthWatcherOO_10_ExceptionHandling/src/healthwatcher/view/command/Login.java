package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.Library;
import lib.exceptions.CommunicationException;
import lib.exceptions.FacadeUnavailableException;
public class Login extends Command
{
    private String[] keywords = { "##SYSTEM_ROOT##", "##SERVLET_SERVER_PATH##",
                                  "##CLOSE##", "##SYSTEM_ACTION##"
                                };
    private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SERVLET_SERVER_PATH, HTMLCode.closeAdministrator(), Constants.SYSTEM_ACTION
                                };
    public static final String EMPLOYEE = "employee";
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        String login = request.getInput("login");
        String password = request.getInput("password");
        try { //1
            Employee employee = facade.searchEmployee(login);
            if(employee.validatePassword(password)) { //1
                employee.addObserver(facade);
                request.setAuthorized(true);
                request.put(Login.EMPLOYEE, employee);
                out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
            } else {
                out.println(HTMLCode.errorPage("Invalid password! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
            }
        } catch (ObjectNotFoundException e) { //1
            out.println(HTMLCode.errorPage("Invalid login! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>"));
        } catch (FileNotFoundException e) { //1
            out.println(HTMLCode.errorPage(e.getMessage()));
        } catch (TransactionException e) { //1
            out.println(HTMLCode.errorPage(e.getMessage()));
        } catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        } catch (Exception e) { //1
            out.println(HTMLCode.errorPage(e.getMessage()));
        }
    }
    public Login(IFacade f)
    {
        super(f);
    }

}
