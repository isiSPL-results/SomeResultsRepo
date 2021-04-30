
//#if 1494628522 
// Compilation Unit of /UpdateEmployeeSearch.java 
 
package healthwatcher.view.command;

//#if 2052140758 
import healthwatcher.Constants;
//#endif 


//#if 814312252 
import healthwatcher.model.employee.Employee;
//#endif 


//#if 1801366871 
import healthwatcher.view.IFacade;
//#endif 


//#if 635204975 
import java.io.FileNotFoundException;
//#endif 


//#if -1640921942 
import java.io.IOException;
//#endif 


//#if -1020701709 
import java.io.PrintWriter;
//#endif 


//#if 975370614 
import javax.servlet.http.HttpSession;
//#endif 


//#if -406730992 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 1173084860 
import lib.util.HTMLCode;
//#endif 


//#if -1841245145 
import lib.util.Library;
//#endif 

public class UpdateEmployeeSearch extends Command
  { 

//#if -46479562 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
String[] keywords = { "##LOGIN##", "##NAME##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
String[] newWords = { employee.getLogin(), employee.getName(),
                                  Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };
out.println(Library.getFileListReplace(keywords, newWords,
                                                   Constants.FORM_PATH + "UpdateEmployee.html"));
} 
catch (InvalidSessionException e) //1
{ 
out
            .println(HTMLCode
                     .errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""
                                             + Constants.SYSTEM_LOGIN
                                             + "\">login</a> again!"));
} 

catch (FileNotFoundException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 


} 

//#endif 


//#if 1129555916 
public void execute()
    { 
PrintWriter out = null;

//#if 777971307 
HttpSession session = request.getSession(false);
//#endif 


//#if -295441495 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if 1892554793 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 


try //2
{ 

//#if -1231403198 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if -24101778 
Employee employee = (Employee) session
                                .getValue(Login.EMPLOYEE);
//#endif 


//#if -592325621 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if -1957938846 
Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
//#endif 

String[] keywords = { "##LOGIN##", "##NAME##",
                                  "##SERVLET_SERVER_PATH##", "##CLOSE##"
                                };
String[] newWords = { employee.getLogin(), employee.getName(),
                                  Constants.SERVLET_SERVER_PATH,
                                  HTMLCode.closeAdministrator()
                                };
out.println(Library.getFileListReplace(keywords, newWords,
                                                   Constants.FORM_PATH + "UpdateEmployee.html"));
} 

//#if 1987430505 
catch (InvalidSessionException e) //1
{ 
out
            .println(HTMLCode
                     .errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""
                                             + Constants.SYSTEM_LOGIN
                                             + "\">login</a> again!"));
} 

//#endif 


//#if 1162139605 
catch (FileNotFoundException e) //1
{ 
out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

public UpdateEmployeeSearch(IFacade f)
    { 
super(f);
} 

 } 


//#endif 

