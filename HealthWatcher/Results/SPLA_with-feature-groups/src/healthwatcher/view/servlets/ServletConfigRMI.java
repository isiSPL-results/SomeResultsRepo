
//#if -1103788143
// Compilation Unit of /ServletConfigRMI.java

package healthwatcher.view.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.util.HTMLCode;
public class ServletConfigRMI extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        PrintWriter out;
        response.setContentType("text/html");
        out = response.getWriter();
        try { //1
            out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
        } catch (Exception e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
        }

        finally {
            out.close();
        }

    }

}


//#endif

