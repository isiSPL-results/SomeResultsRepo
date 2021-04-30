
//#if 560128689 
// Compilation Unit of /GetDataForSearchByDiseaseType.java 
 
package healthwatcher.view.command;

//#if 538608302 
import healthwatcher.Constants;
//#endif 


//#if 117548623 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if 722643583 
import healthwatcher.view.IFacade;
//#endif 


//#if -860978046 
import java.io.IOException;
//#endif 


//#if -240757813 
import java.io.PrintWriter;
//#endif 


//#if 1189376778 
import java.rmi.RemoteException;
//#endif 


//#if 979859509 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1604065881 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1728770979 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1989292541 
import lib.exceptions.TransactionException;
//#endif 


//#if 47640724 
import lib.util.HTMLCode;
//#endif 


//#if 1216227452 
import lib.util.IteratorDsk;
//#endif 


//#if -2061934027 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class GetDataForSearchByDiseaseType extends Command
  { 

//#if 1393547339 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
IteratorDsk repTP = facade.getDiseaseTypeList();
out.println(HTMLCode.open("Queries - Disease information"));
out.println("<body><h1>Queries:<br>Querie about diseases</h1>");
out.println("<p>Choose a disease: </p>");
out
            .println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=SearchDiseaseData\">");
out
            .println("<div align=\"center\"><center><p><select name=\"codTipoDoenca\" size=\"1\">");
if(repTP == null || !repTP.hasNext())//1
{ 
out.println("</select></p></center></div>");
out
                .println("<p><font color=\"red\"><b> There isn't diseases registered.</b></font></p>");
} 
else
{ 
DiseaseType tp;
do{ 
tp = (DiseaseType) repTP.next();
out.println("<option value=\"" + tp.getCode() + "\"> "
                                + tp.getName() + " </OPTION>");
} 
 while (repTP.hasNext());//1

repTP.close();
out.println("</select></p></center></div>");
out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchDiseaseData\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeQueries());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode
                        .errorPageQueries("There isn't registered diseases"));
} 

catch (RepositoryException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

catch (TransactionException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 


} 

//#endif 


//#if 634597207 
public void execute()
    { 
PrintWriter out = null;

//#if 12219201 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if -673020319 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 


out.println(HTMLCode.open("Queries - Disease information"));
out.println("<body><h1>Queries:<br>Querie about diseases</h1>");
out.println("<p>Choose a disease: </p>");
out
        .println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=SearchDiseaseData\">");
try //2
{ 
out
            .println("<div align=\"center\"><center><p><select name=\"codTipoDoenca\" size=\"1\">");
IteratorDsk repTP = facade.getDiseaseTypeList();
if(repTP == null || !repTP.hasNext())//1
{ 
out.println("</select></p></center></div>");
out
                .println("<p><font color=\"red\"><b> There isn't diseases registered.</b></font></p>");
} 
else
{ 
DiseaseType tp;
do{ 
tp = (DiseaseType) repTP.next();
out.println("<option value=\"" + tp.getCode() + "\"> "
                                + tp.getName() + " </OPTION>");
} 
 while (repTP.hasNext());//1

repTP.close();
out.println("</select></p></center></div>");
out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchDiseaseData\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeQueries());
} 

//#if 338752819 
catch (RemoteException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 


//#if -2067705669 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode
                        .errorPageQueries("There isn't registered diseases"));
} 

//#endif 


//#if 1596539319 
catch (RepositoryException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if -1386030707 
catch (TransactionException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 519136325 
catch (CommunicationException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

public GetDataForSearchByDiseaseType(IFacade f)
    { 
super(f);
} 

 } 


//#endif 

