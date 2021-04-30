
//#if -229464219 
// Compilation Unit of /GetDataForSearchBySpeciality.java 
 
package healthwatcher.view.command;

//#if -1813521997 
import healthwatcher.Constants;
//#endif 


//#if 280460879 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 800340314 
import healthwatcher.view.IFacade;
//#endif 


//#if 769795591 
import java.io.IOException;
//#endif 


//#if 1390015824 
import java.io.PrintWriter;
//#endif 


//#if 1287781541 
import java.rmi.RemoteException;
//#endif 


//#if -707157382 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1932985346 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 113866622 
import lib.exceptions.RepositoryException;
//#endif 


//#if -828102270 
import lib.exceptions.TransactionException;
//#endif 


//#if -719376551 
import lib.util.HTMLCode;
//#endif 


//#if 230602647 
import lib.util.IteratorDsk;
//#endif 


//#if 1798496762 
import lib.exceptions.FacadeUnavailableException;
//#endif 

public class GetDataForSearchBySpeciality extends Command
  { 

//#if -1536649362 
public void execute() throws Exception
    { 
PrintWriter out = response.getWriter();
try //1
{ 
IteratorDsk repEsp = facade.getSpecialityList();
out.println(HTMLCode.open("Queries - Health Units"));
out
            .println("<body><h1>Queries:<br>Search Health units by Medical specialty</h1>");
out.println("<p>Choose a specialty: </p>");
out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchHealthUnitsBySpecialty\">");
out
            .println("<div align=\"center\"><center><p><select name=\"codEspecialidade\" size=\"1\">");
if(!repEsp.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<P>There isn't registered specialties.</P>");
} 
else
{ 
MedicalSpeciality esp;
do{ 
esp = (MedicalSpeciality) repEsp.next();
out.println("<option value=\"" + esp.getCodigo() + "\"> "
                                + esp.getDescricao() + " </OPTION>");
} 
 while (repEsp.hasNext());//1

repEsp.close();
out.println("</select></p></center></div>");
out
                .println(" <div align=\"center\"><center><p><input type=\"submit\" value=\"SearchHealthUnitsBySpecialty\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeQueries());
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
out.println("<P> Nenhuma especialidade foi cadastrada</P>");
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
out.println("Error!");
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 


} 

//#endif 


//#if -1619628396 
public void execute()
    { 
PrintWriter out = null;

//#if -1459050674 
response.setContentType("text/html");
//#endif 

try //1
{ 
out = response.getWriter();
} 

//#if 1170798080 
catch (IOException e1) //1
{ 
e1.printStackTrace();
} 

//#endif 


out.println(HTMLCode.open("Queries - Health Units"));
out
        .println("<body><h1>Queries:<br>Search Health units by Medical specialty</h1>");
out.println("<p>Choose a specialty: </p>");
out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchHealthUnitsBySpecialty\">");
try //2
{ 
out
            .println("<div align=\"center\"><center><p><select name=\"codEspecialidade\" size=\"1\">");
IteratorDsk repEsp = facade.getSpecialityList();
if(!repEsp.hasNext())//1
{ 
out.println("</select></p></center></div>");
out.println("<P>There isn't registered specialties.</P>");
} 
else
{ 
MedicalSpeciality esp;
do{ 
esp = (MedicalSpeciality) repEsp.next();
out.println("<option value=\"" + esp.getCodigo() + "\"> "
                                + esp.getDescricao() + " </OPTION>");
} 
 while (repEsp.hasNext());//1

repEsp.close();
out.println("</select></p></center></div>");
out
                .println(" <div align=\"center\"><center><p><input type=\"submit\" value=\"SearchHealthUnitsBySpecialty\" name=\"operation\"></p></center></div></form>");
} 

out.println(HTMLCode.closeQueries());
} 

//#if 2126950895 
catch (RemoteException e) //1
{ 
out.println("Error!");
out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 

//#endif 


//#if -1373859465 
catch (ObjectNotFoundException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
out.println("<P> Nenhuma especialidade foi cadastrada</P>");
} 

//#endif 


//#if -623230861 
catch (RepositoryException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if -1479429551 
catch (TransactionException e) //1
{ 
out.println("</select></p></center></div>");
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 957160457 
catch (CommunicationException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
} 

//#endif 


//#if 301933641 
catch (Exception e) //1
{ 
out.println("Error!");
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

public GetDataForSearchBySpeciality(IFacade f)
    { 
super(f);
} 

 } 


//#endif 

