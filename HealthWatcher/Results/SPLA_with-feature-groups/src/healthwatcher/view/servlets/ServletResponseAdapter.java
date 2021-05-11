
//#if 1299956082
// Compilation Unit of /ServletResponseAdapter.java

package healthwatcher.view.servlets;

//#if -294690345
import healthwatcher.view.command.CommandResponse;
//#endif


//#if -234936316
import java.io.IOException;
//#endif


//#if 385283917
import java.io.PrintWriter;
//#endif


//#if -1854021172
import javax.servlet.http.HttpServletResponse;
//#endif

public class ServletResponseAdapter implements CommandResponse
{
    protected HttpServletResponse response;
    public PrintWriter getWriter() throws IOException
    {
        return this.response.getWriter();
    }

    public ServletResponseAdapter(HttpServletResponse response)
    {
        this.response = response;
        this.response.setContentType("text/html");
    }

}


//#endif

