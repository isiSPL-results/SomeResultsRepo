
//#if -592981846
// Compilation Unit of /LoginMenu.java


//#if -283152338
package healthwatcher.view.command;
//#endif


//#if -1224123608
import healthwatcher.Constants;
//#endif


//#if 1741440965
import healthwatcher.view.IFacade;
//#endif


//#if -1317504699
import java.io.PrintWriter;
//#endif


//#if -1203655452
import javax.servlet.http.HttpSession;
//#endif


//#if -152753026
import lib.exceptions.InvalidSessionException;
//#endif


//#if -905433970
import lib.util.HTMLCode;
//#endif


//#if -1354104811
import lib.util.Library;
//#endif


//#if -1212985726
public class LoginMenu extends
//#if -254093769
    Command
//#endif

{

//#if 1381292425
    private String[] keywords = { "##SYSTEM_ROOT##", "##SERVLET_SERVER_PATH##",
                                  "##CLOSE##", "##SYSTEM_ACTION##"
                                };
//#endif


//#if -1402070017
    private String[] newWords = { Constants.SYSTEM_ROOT,
                                  Constants.SERVLET_SERVER_PATH, HTMLCode.closeAdministrator(), Constants.SYSTEM_ACTION
                                };
//#endif


//#if 731834409
    public LoginMenu(IFacade f)
    {

//#if 1444378809
        super(f);
//#endif

    }

//#endif


//#if 469210469
    public void execute()
    {

//#if 579422131
        PrintWriter out = null;
//#endif


//#if 1775551603
        HttpSession session = request.getSession(false);
//#endif


//#if -612609615
        response.setContentType("text/html");
//#endif


//#if 969597444
        try { //1

//#if -1495241351
            out = response.getWriter();
//#endif

        }

//#if -543715160
        catch (Exception e) { //1

//#if 1887444172
            e.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 1622465069
        try { //2

//#if -977362164
            if(session == null) { //1

//#if -594435403
                throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif

            }

//#endif


//#if 383089493
            if(! request.isAuthorized()) { //1

//#if -1916234998
                throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif

            }

//#endif


//#if 502259828
            out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
//#endif

        }

//#if -854741584
        catch (Exception e) { //1

//#if 965181784
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif

        }

//#endif

        finally {

//#if 650603284
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 1154274429
    public void execute() throws Exception
    {

//#if -1698655141
        PrintWriter out = response.getWriter();
//#endif


//#if -81389342
        try { //1

//#if -1387257062
            if(! request.isAuthorized()) { //1

//#if -2067989656
                throw new InvalidSessionException("Invalid Session! <br><a href=\""+Constants.SYSTEM_LOGIN+"\">Try again</a>");
//#endif

            }

//#endif


//#if 2003301327
            out.println(Library.getFileListReplace(keywords, newWords, Constants.FORM_PATH+"MenuEmployee.html"));
//#endif

        }

//#if 330238350
        catch (Exception e) { //1

//#if 765287372
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif

        }

//#endif

        finally {

//#if 1282402841
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

