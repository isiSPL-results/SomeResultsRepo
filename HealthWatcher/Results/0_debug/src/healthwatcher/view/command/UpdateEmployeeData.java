
//#if 1637668325
// Compilation Unit of /UpdateEmployeeData.java


//#if -753118740
package healthwatcher.view.command;
//#endif


//#if -442438580
import healthwatcher.model.employee.Employee;
//#endif


//#if -2014497209
import healthwatcher.view.IFacade;
//#endif


//#if 597830074
import java.io.IOException;
//#endif


//#if 1218050307
import java.io.PrintWriter;
//#endif


//#if -379352474
import javax.servlet.http.HttpSession;
//#endif


//#if -711301120
import lib.exceptions.InvalidSessionException;
//#endif


//#if 241337292
import lib.util.HTMLCode;
//#endif


//#if 1514763657
public class UpdateEmployeeData extends
//#if -438726880
    Command
//#endif

{

//#if -1215344013
    public UpdateEmployeeData(IFacade f)
    {

//#if 599499125
        super(f);
//#endif

    }

//#endif


//#if -1936010764
    public void execute() throws Exception
    {

//#if -311006434
        PrintWriter out = response.getWriter();
//#endif


//#if -1013148534
        String name = request.getInput("name");
//#endif


//#if -656883128
        String newPassword = request.getInput("newPassword");
//#endif


//#if 1311506978
        Employee employee = null;
//#endif


//#if -575531291
        try { //1

//#if 1395922953
            if(! request.isAuthorized()) { //1

//#if 1085036229
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 1330983346
            employee = (Employee) request.get(Login.EMPLOYEE);
//#endif


//#if 1734400050
            employee.setName(name);
//#endif


//#if 649466903
            if(!newPassword.equals("")) { //1

//#if 1775646281
                employee.setPassword(newPassword);
//#endif

            }

//#endif


//#if 1190124494
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee updated"));
//#endif

        }

//#if 1233279176
        catch (Exception e) { //1

//#if -391684659
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
//#endif


//#if -139878909
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -974964530
    public void execute()
    {

//#if 272081744
        PrintWriter out = null;
//#endif


//#if -21314698
        HttpSession session = request.getSession(false);
//#endif


//#if -492120185
        String name = request.getParameter("name");
//#endif


//#if -1668679645
        String newPassword = request.getParameter("newPassword");
//#endif


//#if -1334451962
        String name = request.getInput("name");
//#endif


//#if 2143585732
        String newPassword = request.getInput("newPassword");
//#endif


//#if 761698206
        Employee employee = null;
//#endif


//#if -1469643852
        response.setContentType("text/html");
//#endif


//#if 73344097
        try { //1

//#if -819908828
            out = response.getWriter();
//#endif

        }

//#if -1589698151
        catch (IOException e1) { //1

//#if -1282994170
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if -1144283472
        try { //2

//#if -1592264410
            if(session == null) { //1

//#if -68299280
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -869333372
            employee = (Employee) session.getValue(Login.EMPLOYEE);
//#endif


//#if 1245018351
            if(! request.isAuthorized()) { //1

//#if -1060634905
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 1783691660
            employee = (Employee) request.get(Login.EMPLOYEE);
//#endif


//#if -599126516
            employee.setName(name);
//#endif


//#if 498562301
            if(!newPassword.equals("")) { //1

//#if 88822434
                employee.setPassword(newPassword);
//#endif

            }

//#endif


//#if -222413144
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Employee updated"));
//#endif


//#if 164164457
            facade.updateEmployee(employee);
//#endif

        }

//#if 1668667898
        catch (Exception e) { //1

//#if -517536510
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
//#endif


//#if -128277896
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -2109899986
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

