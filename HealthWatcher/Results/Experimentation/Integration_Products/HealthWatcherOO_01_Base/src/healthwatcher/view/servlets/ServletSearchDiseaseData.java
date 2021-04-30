package healthwatcher.view.servlets;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.complaint.Symptom;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
public class ServletSearchDiseaseData extends HWServlet
  { 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 
PrintWriter out = response.getWriter();
response.setContentType("text/html");
int codigoTipoDoenca = Integer.parseInt(request.getParameter("codTipoDoenca"));
try//1
{ 
DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
out.println(HTMLCode.open("Queries - Diseases"));
out.println("<body><h1>Querie result<br>Disease</h1>");
out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
out.println("<P>Description: " + tp.getDescription() + "</P>");
out.println("<P>How manifests: " + tp.getManifestation()
                        + " </P>");
out.println("<P>Duration: " + tp.getDuration() + " </P>");
out.println("<P>Symptoms: </P>");
Iterator i = tp.getSymptoms().iterator();
if(! i.hasNext())//1
{ 
out.println("<P>There isn't registered symptoms.</P>");
} 
else
{ 
while(i.hasNext()) //1
{ 
Symptom s = (Symptom) i.next();
out.println("<li> " + s.getDescription() + " </li>");
} 
} 
out.println(HTMLCode.closeQueries());
} 
catch(RemoteException e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 
catch (ObjectNotFoundException e) //1
{ 
out.println("<P> " + e.getMessage() + " </P>");
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
out.println("<P> " + e.getMessage() + " </P>");
} 
catch(Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
e.printStackTrace(out);
} 
finally { 
out.close();
} 
} 

 } 
