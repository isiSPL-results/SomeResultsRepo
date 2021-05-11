
//#if -1103788143
// Compilation Unit of /ServletConfigRMI.java


//#if -1821389265
package healthwatcher.view.servlets;
//#endif


//#if -1249226532
import java.io.IOException;
//#endif


//#if -629006299
import java.io.PrintWriter;
//#endif


//#if 1389037314
import javax.servlet.ServletException;
//#endif


//#if -1430544331
import javax.servlet.http.HttpServlet;
//#endif


//#if 370349682
import javax.servlet.http.HttpServletRequest;
//#endif


//#if 236886516
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -1660023954
import lib.util.HTMLCode;
//#endif


//#if -448808979
public class ServletConfigRMI extends
//#if -293901833
    HttpServlet
//#endif

{

//#if 1366785831
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {

//#if -13692703
        PrintWriter out;
//#endif


//#if -237977453
        response.setContentType("text/html");
//#endif


//#if -126900125
        out = response.getWriter();
//#endif


//#if 1939949410
        try { //1

//#if -2063420178
            out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
//#endif

        }

//#if -760006834
        catch (Exception e) { //1

//#if 1852928287
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif

        }

//#endif

        finally {

//#if 607356651
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

