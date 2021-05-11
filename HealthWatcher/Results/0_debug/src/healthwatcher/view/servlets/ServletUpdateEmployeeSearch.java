
//#if -728045618
// Compilation Unit of /ServletUpdateEmployeeSearch.java


//#if 1895175868
package healthwatcher.view.servlets;
//#endif


//#if -299080357
import healthwatcher.Constants;
//#endif


//#if 1082938625
import healthwatcher.model.employee.Employee;
//#endif


//#if 362017844
import java.io.FileNotFoundException;
//#endif


//#if -733035089
import java.io.IOException;
//#endif


//#if -112814856
import java.io.PrintWriter;
//#endif


//#if -404660145
import javax.servlet.ServletException;
//#endif


//#if 1133583493
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -1872669119
import javax.servlet.http.HttpServletResponse;
//#endif


//#if 1096504145
import javax.servlet.http.HttpSession;
//#endif


//#if -669248021
import lib.exceptions.InvalidSessionException;
//#endif


//#if 838834433
import lib.util.HTMLCode;
//#endif


//#if 1196013890
import lib.util.Library;
//#endif


//#if 1849485265
public class ServletUpdateEmployeeSearch extends
//#if 1511916330
    HWServlet
//#endif

{

//#if 297610899
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if -736847035
        PrintWriter out;
//#endif


//#if -716475207
        HttpSession session = request.getSession(false);
//#endif


//#if -1796036617
        response.setContentType("text/html");
//#endif


//#if 616990151
        out = response.getWriter();
//#endif


//#if -1338524546
        try { //1

//#if -1136794237
            if(session == null) { //1

//#if -1830824706
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -2144539776
            Employee employee = (Employee)session.getValue(ServletLogin.EMPLOYEE);
//#endif


//#if 605126777
            String[] keywords = {"##LOGIN##",
                                 "##NAME##",
                                 "##SERVLET_SERVER_PATH##",
                                 "##CLOSE##"
                                };
//#endif


//#if -2138479977
            String[] newWords = {employee.getLogin(),
                                 employee.getName(),
                                 Constants.SERVLET_SERVER_PATH,
                                 HTMLCode.closeAdministrator()
                                };
//#endif


//#if 1035604211
            out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"UpdateEmployee.html"));
//#endif

        }

//#if -1570057986
        catch (InvalidSessionException e) { //1

//#if -1856706608
            out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif

        }

//#endif


//#if 1721565610
        catch (FileNotFoundException e) { //1

//#if 1800562753
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif

        }

//#endif

        finally {

//#if -332393333
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

