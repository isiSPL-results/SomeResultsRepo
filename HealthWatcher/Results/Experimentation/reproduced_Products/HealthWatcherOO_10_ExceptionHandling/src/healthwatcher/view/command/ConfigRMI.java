package healthwatcher.view.command;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.util.HTMLCode;
public class ConfigRMI extends Command
{
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
        } catch (Exception e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
        }
    }
    public ConfigRMI(IFacade f)
    {
        super(f);
    }

}
