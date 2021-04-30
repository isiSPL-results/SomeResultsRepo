
//#if -1717150616 
// Compilation Unit of /ConfigRMI.java 
 

//#if 2117793901 
package healthwatcher.view.command;
//#endif 


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


//#if -919150715 
public class ConfigRMI extends 
//#if 147977576 
Command
//#endif 

  { 

//#if 1381809836 
public void execute() throws Exception
    { 

//#if 621476894 
PrintWriter out = response.getWriter();
//#endif 


//#if 535455717 
try //1
{ 

//#if 446580923 
out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
//#endif 

} 

//#if -388924149 
catch (Exception e) //1
{ 

//#if 936580627 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 243918494 
public ConfigRMI(IFacade f)
    { 

//#if 839966564 
super(f);
//#endif 

} 

//#endif 


//#if 2118939414 
public void execute()
    { 

//#if -633153329 
PrintWriter out = null;
//#endif 


//#if -1913938923 
response.setContentType("text/html");
//#endif 


//#if -470526944 
try //1
{ 

//#if -1705325089 
out = response.getWriter();
//#endif 

} 

//#if -750797200 
catch (IOException e1) //1
{ 

//#if 548649414 
e1.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if 1305141905 
try //2
{ 

//#if 45782968 
out.println(HTMLCode.htmlPage("Health-Watcher 2003", "Server name stored"));
//#endif 

} 

//#if 1605665378 
catch (Exception e) //1
{ 

//#if -1705216171 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif 

} 

//#endif 

finally { 

//#if -174308171 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

