
//#if 1494628522
// Compilation Unit of /UpdateEmployeeSearch.java


//#if 1574550748
package healthwatcher.view.command;
//#endif


//#if 2052140758
import healthwatcher.Constants;
//#endif


//#if 814312252
import healthwatcher.model.employee.Employee;
//#endif


//#if 1801366871
import healthwatcher.view.IFacade;
//#endif


//#if 635204975
import java.io.FileNotFoundException;
//#endif


//#if -1640921942
import java.io.IOException;
//#endif


//#if -1020701709
import java.io.PrintWriter;
//#endif


//#if 975370614
import javax.servlet.http.HttpSession;
//#endif


//#if -406730992
import lib.exceptions.InvalidSessionException;
//#endif


//#if 1173084860
import lib.util.HTMLCode;
//#endif


//#if -1841245145
import lib.util.Library;
//#endif


//#if -66131241
public class UpdateEmployeeSearch extends
//#if 1093274398
    Command
//#endif

{

//#if -46479562
    public void execute() throws Exception
    {

//#if 1803239631
        PrintWriter out = response.getWriter();
//#endif


//#if -694007722
        try { //1

//#if 124997893
            if(! request.isAuthorized()) { //1

//#if 1642856963
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 1579772328
            Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
//#endif


//#if -322524110
            String[] keywords = { "##LOGIN##", "##NAME##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
//#endif


//#if -2068251760
            String[] newWords = { employee.getLogin(), employee.getName(),
                                  Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };
//#endif


//#if 354525914
            out.println(Library.getFileListReplace(keywords, newWords,
                                                   Constants.FORM_PATH + "UpdateEmployee.html"));
//#endif

        }

//#if -1813494770
        catch (InvalidSessionException e) { //1

//#if 1709451728
            out
            .println(HTMLCode
                     .errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""
                                             + Constants.SYSTEM_LOGIN
                                             + "\">login</a> again!"));
//#endif

        }

//#endif


//#if 872151226
        catch (FileNotFoundException e) { //1

//#if -422369909
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1129555916
    public void execute()
    {

//#if 2013896379
        PrintWriter out = null;
//#endif


//#if 777971307
        HttpSession session = request.getSession(false);
//#endif


//#if -295441495
        response.setContentType("text/html");
//#endif


//#if 1433184012
        try { //1

//#if 1616172451
            out = response.getWriter();
//#endif

        }

//#if 1892554793
        catch (IOException e1) { //1

//#if -4584278
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if -284911579
        try { //2

//#if -1231403198
            if(session == null) { //1

//#if -859720766
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -24101778
            Employee employee = (Employee) session
                                .getValue(Login.EMPLOYEE);
//#endif


//#if -592325621
            if(! request.isAuthorized()) { //1

//#if 1110875061
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -1957938846
            Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
//#endif


//#if 2080448952
            String[] keywords = { "##LOGIN##", "##NAME##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
//#endif


//#if 2146770070
            String[] newWords = { employee.getLogin(), employee.getName(),
                                  Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };
//#endif


//#if -1234043628
            out.println(Library.getFileListReplace(keywords, newWords,
                                                   Constants.FORM_PATH + "UpdateEmployee.html"));
//#endif

        }

//#if 1987430505
        catch (InvalidSessionException e) { //1

//#if -1682868649
            out
            .println(HTMLCode
                     .errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""
                                             + Constants.SYSTEM_LOGIN
                                             + "\">login</a> again!"));
//#endif

        }

//#endif


//#if 1162139605
        catch (FileNotFoundException e) { //1

//#if 105353286
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif

        }

//#endif

        finally {

//#if -166877878
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 199303411
    public UpdateEmployeeSearch(IFacade f)
    {

//#if -1715367341
        super(f);
//#endif

    }

//#endif

}

//#endif


//#endif

