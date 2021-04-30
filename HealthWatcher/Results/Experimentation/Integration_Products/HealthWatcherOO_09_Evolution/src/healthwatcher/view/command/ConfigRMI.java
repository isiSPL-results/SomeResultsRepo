package healthwatcher.view.command;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import lib.util.HTMLCode;
public class ConfigRMI extends Command
  { 
public ConfigRMI(IFacade f)
    { 
super(f);
} 
public void execute()
    { 
PrintWriter out = null;
try//1
{ 
out = response.getWriter();
} 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 
try//2
{ 
out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
} 
catch (Exception e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 
finally { 
out.close();
} 
} 

 } 
