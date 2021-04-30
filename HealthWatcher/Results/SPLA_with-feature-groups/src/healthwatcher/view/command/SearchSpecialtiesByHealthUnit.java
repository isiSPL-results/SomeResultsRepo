
//#if -1525955771 
// Compilation Unit of /SearchSpecialtiesByHealthUnit.java 
 
package healthwatcher.view.command;

//#if 448418343 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 648861826 
import healthwatcher.view.IFacade;
//#endif 


//#if -299056161 
import java.io.IOException;
//#endif 


//#if 321164072 
import java.io.PrintWriter;
//#endif 


//#if -2077735475 
import java.rmi.RemoteException;
//#endif 


//#if -581338542 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1538402090 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 828665510 
import lib.exceptions.RepositoryException;
//#endif 


//#if -144173222 
import lib.exceptions.TransactionException;
//#endif 


//#if -693673167 
import lib.util.HTMLCode;
//#endif 


//#if 1455936703 
import lib.util.IteratorDsk;
//#endif 


//#if 2094206418 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class SearchSpecialtiesByHealthUnit extends Command
  { 
public SearchSpecialtiesByHealthUnit(IFacade f)
    { 
super(f);
} 


//#if 1750334050 
public void execute()
    { 
PrintWriter out = null;
try //1
{ 
out = response.getWriter();
} 

//#if 1996010848 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 



//#if -1177228021 
response.setContentType("text/html");
//#endif 


//#if 1779235182 
int codigoUS = Integer.parseInt(request.getParameter("codUnidadeSaude"));
//#endif 


//#if 1850521325 
int codigoUS = Integer.parseInt(request.getInput("codUnidadeSaude"));
//#endif 

try //2
{ 
IteratorDsk repEsp = facade.searchSpecialitiesByHealthUnit(codigoUS);
out.println(HTMLCode.open("Queries - Especialties"));
out.println("<body><h1>Querie result</h1>");
out.println("<P><h3>Health unit: " + codigoUS+ " </h3></P>");
out.println("<h3>Especialties :</h3>");
while (repEsp.hasNext()) //1
{ 
MedicalSpeciality esp = (MedicalSpeciality) repEsp.next();
out.println("<dd><dd>" + esp.getDescricao());
} 

out.println(HTMLCode.closeQueries());
} 

//#if -198187778 
catch(RemoteException e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 


//#if -56277626 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode.errorPageQueries("This health unit does not have registered specialties."));
} 

//#endif 


//#if 1128616962 
catch (RepositoryException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 1288245410 
catch (TransactionException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 2108041754 
catch (CommunicationException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if -824996200 
catch(Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 


//#if 482620896 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
int codigoUS = Integer.parseInt(request.getInput("codUnidadeSaude"));
try //1
{ 
IteratorDsk repEsp = facade.searchSpecialitiesByHealthUnit(codigoUS);
out.println(HTMLCode.open("Queries - Especialties"));
out.println("<body><h1>Querie result</h1>");
out.println("<P><h3>Health unit: " + codigoUS+ " </h3></P>");
out.println("<h3>Especialties :</h3>");
while (repEsp.hasNext()) //1
{ 
MedicalSpeciality esp = (MedicalSpeciality) repEsp.next();
out.println("<dd><dd>" + esp.getDescricao());
} 

out.println(HTMLCode.closeQueries());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println(HTMLCode.errorPageQueries("This health unit does not have registered specialties."));
} 

catch (RepositoryException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

catch (TransactionException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

catch (CommunicationException e) //1
{ 
throw new FacadeUnavailableException();
} 

catch(Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 


} 

//#endif 

 } 


//#endif 

