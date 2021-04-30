
//#if 170706818 
// Compilation Unit of /UpdateComplaintData.java 
 
package healthwatcher.view.command;

//#if -1906598313 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 658893668 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if -445312751 
import healthwatcher.model.employee.Employee;
//#endif 


//#if 1101028002 
import healthwatcher.view.IFacade;
//#endif 


//#if -134650433 
import java.io.IOException;
//#endif 


//#if 485569800 
import java.io.PrintWriter;
//#endif 


//#if 1361380012 
import java.util.Calendar;
//#endif 


//#if -1847129791 
import javax.servlet.http.HttpSession;
//#endif 


//#if -800400421 
import lib.exceptions.InvalidSessionException;
//#endif 


//#if 1156775185 
import lib.util.HTMLCode;
//#endif 

public class UpdateComplaintData extends Command
  { 

//#if -308223777 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
String obsQueixa = request.getInput("obsQueixa");
Complaint q = null;
try //1
{ 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

q = (Complaint) request
                .get(UpdateComplaintSearch.QUEIXA);
q.setObservacao(obsQueixa);
Calendar agora = Calendar.getInstance();
q.setDataParecer(new lib.util.Date(
                                 agora.get(Calendar.DAY_OF_MONTH),
                                 agora.get(Calendar.MONTH), agora.get(Calendar.YEAR)));
Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
q.setAtendente(employee);
q.setSituacao(Situation.QUEIXA_FECHADA);
out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Complaint updated" + "<P>" + obsQueixa + "</P>"));
} 
catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 


} 

//#endif 

public UpdateComplaintData(IFacade f)
    { 
super(f);
} 


//#if -173239997 
public void execute()
    { 
PrintWriter out = null;
try //1
{ 
out = response.getWriter();
} 

//#if 312349783 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 



//#if -510112745 
HttpSession session = request.getSession(false);
//#endif 


//#if 254267190 
String obsQueixa = request.getParameter("obsQueixa");
//#endif 


//#if -1415537257 
String obsQueixa = request.getInput("obsQueixa");
//#endif 

Complaint q = null;

//#if 872660309 
response.setContentType("text/html");
//#endif 

try //2
{ 

//#if 2095355077 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if -756735859 
q = (Complaint) session
                .getValue(UpdateComplaintSearch.QUEIXA);
//#endif 


//#if -918070834 
if(! request.isAuthorized())//1
{ 
throw new InvalidSessionException();
} 

//#endif 


//#if -439126425 
q = (Complaint) request
                .get(UpdateComplaintSearch.QUEIXA);
//#endif 

q.setObservacao(obsQueixa);

//#if 1478581781 
q.setSituacao(Situation.QUEIXA_FECHADA);
//#endif 

Calendar agora = Calendar.getInstance();
q.setDataParecer(new lib.util.Date(
                                 agora.get(Calendar.DAY_OF_MONTH),
                                 agora.get(Calendar.MONTH), agora.get(Calendar.YEAR)));

//#if 1438616305 
Employee employee = (Employee) session
                                .getValue(Login.EMPLOYEE);
//#endif 


//#if -787438337 
Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
//#endif 

q.setAtendente(employee);

//#if -1408604996 
q.setSituacao(Situation.QUEIXA_FECHADA);
//#endif 


//#if -813029548 
facade.updateComplaint(q);
//#endif 

out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Complaint updated" + "<P>" + obsQueixa + "</P>"));
} 

//#if 820764354 
catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
e.printStackTrace(out);
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

 } 


//#endif 

