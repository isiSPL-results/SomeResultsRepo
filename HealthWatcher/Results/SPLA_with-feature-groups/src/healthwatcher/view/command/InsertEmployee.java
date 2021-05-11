
//#if -1666715820
// Compilation Unit of /InsertEmployee.java

package healthwatcher.view.command;

//#if -62174382
import healthwatcher.model.employee.Employee;
//#endif


//#if -716701951
import healthwatcher.view.IFacade;
//#endif


//#if -1623040448
import java.io.IOException;
//#endif


//#if -1002820215
import java.io.PrintWriter;
//#endif


//#if -1475805172
import java.rmi.RemoteException;
//#endif


//#if 106391072
import javax.servlet.http.HttpSession;
//#endif


//#if 1492199510
import lib.exceptions.InsertEntryException;
//#endif


//#if -1808012870
import lib.exceptions.InvalidSessionException;
//#endif


//#if -713654226
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 2051452707
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -1637429317
import lib.exceptions.TransactionException;
//#endif


//#if -1888345646
import lib.util.HTMLCode;
//#endif


//#if -1081368973
import lib.exceptions.CommunicationException;
//#endif


//#if -882072027
import lib.exceptions.RepositoryException;
//#endif


//#if -215729805
import lib.exceptions.FacadeUnavailableException;
//#endif

public class InsertEmployee extends Command
{

//#if -652007399
    public void execute()
    {
        PrintWriter out = null;
        Employee employee;

//#if -1153675715
        HttpSession session = request.getSession(false);
//#endif


//#if -477674117
        response.setContentType("text/html");
//#endif

        try { //1
            out = response.getWriter();
        }

//#if -779048244
        catch (IOException e1) { //1
            e1.printStackTrace();
        }

//#endif


        try { //2

//#if -1770699776
            if(session == null) { //1
                throw new InvalidSessionException();
            }

//#endif


//#if -171025758
            String name = request.getParameter("name");
//#endif


//#if 772141666
            String login = request.getParameter("login");
//#endif


//#if -1498364766
            String password = request.getParameter("password");
//#endif


//#if -708936887
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

//#endif


//#if -1678431839
            String name = request.getInput("name");
//#endif


//#if 1106369347
            String login = request.getInput("login");
//#endif


//#if 1758774305
            String password = request.getInput("password");
//#endif

            employee = new Employee(login, password, name);
            facade.insert(employee);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee inserted"));
        }

//#if 1706141570
        catch (ObjectAlreadyInsertedException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif


//#if -1454730509
        catch (ObjectNotValidException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif


//#if -94197238
        catch (InvalidSessionException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif


//#if 402079274
        catch (InsertEntryException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif


//#if -774853873
        catch (TransactionException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif


//#if 182631025
        catch (RemoteException e) { //1
            e.printStackTrace();
        }

//#endif


//#if -550445753
        catch (CommunicationException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif


//#if 1893349365
        catch(RepositoryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

//#endif

        finally {
            out.close();
        }

    }

//#endif

    public InsertEmployee(IFacade f)
    {
        super(f);
    }


//#if -145030327
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        Employee employee;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            String name = request.getInput("name");
            String login = request.getInput("login");
            String password = request.getInput("password");
            employee = new Employee(login, password, name);
            facade.insert(employee);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee inserted"));
        } catch (ObjectAlreadyInsertedException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (ObjectNotValidException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (InvalidSessionException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (InsertEntryException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (TransactionException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }

        catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        }

        catch(RepositoryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }


    }

//#endif

}


//#endif

