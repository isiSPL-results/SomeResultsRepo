package healthwatcher.view.servlets;
import healthwatcher.view.command.CommandResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
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
