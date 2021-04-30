
//#if -1525955771 
// Compilation Unit of /SearchSpecialtiesByHealthUnit.java 
 

//#if 206632721 
package healthwatcher.view.command;
//#endif 


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


//#if 818989288 
public class SearchSpecialtiesByHealthUnit extends 
//#if 1590759092 
Command
//#endif 

  { 

//#if 1744318057 
public SearchSpecialtiesByHealthUnit(IFacade f)
    { 

//#if -254646881 
super(f);
//#endif 

} 

//#endif 


//#if 1750334050 
public void execute()
    { 

//#if 663643417 
PrintWriter out = null;
//#endif 


//#if 940493290 
try //1
{ 

//#if -1971111965 
out = response.getWriter();
//#endif 

} 

//#if 1996010848 
catch (IOException e1) //1
{ 

//#if 1931546051 
e1.printStackTrace();
//#endif 

} 

//#endif 


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


//#if -2130960249 
try //2
{ 

//#if -1651318683 
IteratorDsk repEsp = facade.searchSpecialitiesByHealthUnit(codigoUS);
//#endif 


//#if -1182365208 
out.println(HTMLCode.open("Queries - Especialties"));
//#endif 


//#if -972044114 
out.println("<body><h1>Querie result</h1>");
//#endif 


//#if 1519375036 
out.println("<P><h3>Health unit: " + codigoUS+ " </h3></P>");
//#endif 


//#if -1318795865 
out.println("<h3>Especialties :</h3>");
//#endif 


//#if -447047660 
while (repEsp.hasNext()) //1
{ 

//#if -83699795 
MedicalSpeciality esp = (MedicalSpeciality) repEsp.next();
//#endif 


//#if -244987677 
out.println("<dd><dd>" + esp.getDescricao());
//#endif 

} 

//#endif 


//#if 136590478 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if -198187778 
catch(RemoteException e) //1
{ 

//#if 1099770715 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -379796335 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if -56277626 
catch (ObjectNotFoundException e) //1
{ 

//#if -386720766 
out.println(HTMLCode.errorPageQueries("This health unit does not have registered specialties."));
//#endif 

} 

//#endif 


//#if 1128616962 
catch (RepositoryException e) //1
{ 

//#if -952972657 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 1288245410 
catch (TransactionException e) //1
{ 

//#if -1742187319 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 2108041754 
catch (CommunicationException e) //1
{ 

//#if -553529660 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -824996200 
catch(Exception e) //1
{ 

//#if -892583879 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1027069329 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1671766766 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 482620896 
public void execute() throws Exception
    { 

//#if 1347953389 
PrintWriter out = response.getWriter();
//#endif 


//#if -1259617033 
int codigoUS = Integer.parseInt(request.getInput("codUnidadeSaude"));
//#endif 


//#if 1246827252 
try //1
{ 

//#if -1623873731 
IteratorDsk repEsp = facade.searchSpecialitiesByHealthUnit(codigoUS);
//#endif 


//#if 1023012368 
out.println(HTMLCode.open("Queries - Especialties"));
//#endif 


//#if 1469961430 
out.println("<body><h1>Querie result</h1>");
//#endif 


//#if 1877271268 
out.println("<P><h3>Health unit: " + codigoUS+ " </h3></P>");
//#endif 


//#if 2021245055 
out.println("<h3>Especialties :</h3>");
//#endif 


//#if 1320097516 
while (repEsp.hasNext()) //1
{ 

//#if 1657137296 
MedicalSpeciality esp = (MedicalSpeciality) repEsp.next();
//#endif 


//#if 696543200 
out.println("<dd><dd>" + esp.getDescricao());
//#endif 

} 

//#endif 


//#if 798523062 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if 374392302 
catch (ObjectNotFoundException e) //1
{ 

//#if -1498594 
out.println(HTMLCode.errorPageQueries("This health unit does not have registered specialties."));
//#endif 

} 

//#endif 


//#if 1716602986 
catch (RepositoryException e) //1
{ 

//#if -482726832 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -1959024326 
catch (TransactionException e) //1
{ 

//#if 308668598 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -371917646 
catch (CommunicationException e) //1
{ 

//#if -1106611108 
throw new FacadeUnavailableException();
//#endif 

} 

//#endif 


//#if -1828035328 
catch(Exception e) //1
{ 

//#if -1256697816 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if 156738270 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

