
//#if -466001881 
// Compilation Unit of /GetDataForSearchByHealthUnit.java 
 
package healthwatcher.view.command;

//#if -2082080538 
import healthwatcher.Constants;
//#endif 


//#if 1277292878 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 1696917831 
import healthwatcher.view.IFacade;
//#endif 


//#if -1721903430 
import java.io.IOException;
//#endif 


//#if -1101683197 
import java.io.PrintWriter;
//#endif 


//#if 1552401362 
import java.rmi.RemoteException;
//#endif 


//#if 1777052781 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1634089071 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -680138133 
import lib.exceptions.RepositoryException;
//#endif 


//#if 327554101 
import lib.exceptions.TransactionException;
//#endif 


//#if 690319564 
import lib.util.HTMLCode;
//#endif 


//#if 297344324 
import lib.util.IteratorDsk;
//#endif 


//#if 846772845 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class GetDataForSearchByHealthUnit extends Command
  { 

//#if -460179772 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
IteratorDsk repUS = facade.getPartialHealthUnitList();
out.println(HTMLCode.open("Queries - Specialties"));
out
            .println("<body><h1>Queries:<br>Search Specialties of a Health unit</h1>");
out.println("<p>Choose a health unit: </p>");
out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchSpecialtiesByHealthUnit\">");
out
            .println("<div align=\"center\"><center><p><select name=\"codUnidadeSaude\" size=\"1\">");
if(!repUS.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<P> There isn't registered health units.</P>");
} 
else
{ 
HealthUnit us;
do{ 
us = (HealthUnit) repUS.next();
out.println("<option value=\"" + us.getCode() + "\"> "
                                + us.getDescription() + " </OPTION>");
} 
 while (repUS.hasNext());//1

repUS.close();
out.println("</select></p></center></div>");
out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchSpecialtiesByHealthUnit\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeQueries());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
out.println("<P> Nenhuma unidade de saude foi cadastrada</P>");
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

catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 


} 

//#endif 


//#if -657928706 
public void execute()
    { 
PrintWriter out = null;

//#if -9431536 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if 1434716313 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 


out.println(HTMLCode.open("Queries - Specialties"));
out
        .println("<body><h1>Queries:<br>Search Specialties of a Health unit</h1>");
out.println("<p>Choose a health unit: </p>");
out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchSpecialtiesByHealthUnit\">");
try //2
{ 
out
            .println("<div align=\"center\"><center><p><select name=\"codUnidadeSaude\" size=\"1\">");
IteratorDsk repUS = facade.getPartialHealthUnitList();
if(!repUS.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<P> There isn't registered health units.</P>");
} 
else
{ 
HealthUnit us;
do{ 
us = (HealthUnit) repUS.next();
out.println("<option value=\"" + us.getCode() + "\"> "
                                + us.getDescription() + " </OPTION>");
} 
 while (repUS.hasNext());//1

repUS.close();
out.println("</select></p></center></div>");
out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchSpecialtiesByHealthUnit\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeQueries());
} 

//#if -1381158685 
catch (RemoteException e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 


//#if -1763779477 
catch (ObjectNotFoundException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
out.println("<P> Nenhuma unidade de saude foi cadastrada</P>");
} 

//#endif 


//#if 599795047 
catch (RepositoryException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 2074635229 
catch (TransactionException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 1914413717 
catch (CommunicationException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 329050685 
catch (Exception e) //1
{ 
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 

finally { 
out.close();
} 

} 

//#endif 

public GetDataForSearchByHealthUnit(IFacade f)
    { 
super(f);
} 

 } 


//#endif 

