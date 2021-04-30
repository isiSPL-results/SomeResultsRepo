
//#if -1717150616 
// Compilation Unit of /ConfigRMI.java 
 
package healthwatcher.view.command;

//#if 17775526 
import healthwatcher.view.IFacade;
//#endif 


//#if -2048138949 
import java.io.IOException;
//#endif 


//#if -1427918716 
import java.io.PrintWriter;
//#endif 


//#if 184952717 
import lib.util.HTMLCode;
//#endif 

public class ConfigRMI extends Command
  { 

//#if 1381809836 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
} 
catch (Exception e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 


} 

//#endif 

public ConfigRMI(IFacade f)
    { 
super(f);
} 


//#if 2118939414 
public void execute()
    { 
PrintWriter out = null;

//#if -1913938923 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if -750797200 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 


try //2
{ 
out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
} 

//#if 1605665378 
catch (Exception e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

