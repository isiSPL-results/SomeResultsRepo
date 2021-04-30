
//#if 213775492 
// Compilation Unit of /ServletSearchSpecialtiesByHealthUnit.java 
 

//#if 1756589836 
package healthwatcher.view.servlets;
//#endif 


//#if 832258471 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if -2068982945 
import java.io.IOException;
//#endif 


//#if -1448762712 
import java.io.PrintWriter;
//#endif 


//#if 1231349325 
import java.rmi.RemoteException;
//#endif 


//#if -441850721 
import javax.servlet.ServletException;
//#endif 


//#if 1179262517 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if -456619375 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if 109423058 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1477175210 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -38637786 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1260771622 
import lib.exceptions.TransactionException;
//#endif 


//#if 287724209 
import lib.util.HTMLCode;
//#endif 


//#if -1872186049 
import lib.util.IteratorDsk;
//#endif 


//#if -1116461303 
public class ServletSearchSpecialtiesByHealthUnit extends 
//#if 1054553277 
HWServlet
//#endif 

  { 

//#if -1093085772 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if 1333339107 
PrintWriter out = response.getWriter();
//#endif 


//#if -664067957 
response.setContentType("text/html");
//#endif 


//#if -634702354 
int codigoUS = Integer.parseInt(request.getParameter("codUnidadeSaude"));
//#endif 


//#if -128907670 
try //1
{ 

//#if -1403724530 
IteratorDsk repEsp = facade.searchSpecialitiesByHealthUnit(codigoUS);
//#endif 


//#if -610668449 
out.println(HTMLCode.open("Queries - Especialties"));
//#endif 


//#if -1888446939 
out.println("<body><h1>Querie result</h1>");
//#endif 


//#if -552786509 
out.println("<P><h3>Health unit: " + codigoUS+ " </h3></P>");
//#endif 


//#if -1021761072 
out.println("<h3>Especialties :</h3>");
//#endif 


//#if -1632816707 
while (repEsp.hasNext()) //1
{ 

//#if -187014666 
MedicalSpeciality esp = (MedicalSpeciality) repEsp.next();
//#endif 


//#if -859975110 
out.println("<dd><dd>" + esp.getDescricao());
//#endif 

} 

//#endif 


//#if -408017083 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if -416363894 
catch(RemoteException e) //1
{ 

//#if -1394121316 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if 1233944146 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 1583079186 
catch (ObjectNotFoundException e) //1
{ 

//#if 1198369210 
out.println(HTMLCode.errorPageQueries("This health unit does not have registered specialties."));
//#endif 

} 

//#endif 


//#if 704549774 
catch (RepositoryException e) //1
{ 

//#if -1038772206 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 1027064470 
catch (TransactionException e) //1
{ 

//#if 1553820912 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 221261582 
catch (CommunicationException e) //1
{ 

//#if 190846259 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 237014308 
catch(Exception e) //1
{ 

//#if -1214996537 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -995785987 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if -1645501829 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

