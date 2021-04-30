
//#if -1432443477 
// Compilation Unit of /ServletSearchHealthUnitsBySpecialty.java 
 

//#if -987547000 
package healthwatcher.view.servlets;
//#endif 


//#if -11563643 
import healthwatcher.model.healthguide.HealthUnit;
//#endif 


//#if 1739582563 
import java.io.IOException;
//#endif 


//#if -1935164500 
import java.io.PrintWriter;
//#endif 


//#if -1482829879 
import java.rmi.RemoteException;
//#endif 


//#if -447430373 
import javax.servlet.ServletException;
//#endif 


//#if 117538361 
import javax.servlet.http.HttpServletRequest;
//#endif 


//#if 989670157 
import javax.servlet.http.HttpServletResponse;
//#endif 


//#if -952301098 
import lib.exceptions.CommunicationException;
//#endif 


//#if -1371502554 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 996322722 
import lib.exceptions.RepositoryException;
//#endif 


//#if 758233054 
import lib.exceptions.TransactionException;
//#endif 


//#if 19061941 
import lib.util.HTMLCode;
//#endif 


//#if 229227707 
import lib.util.IteratorDsk;
//#endif 


//#if 1911229730 
public class ServletSearchHealthUnitsBySpecialty extends 
//#if 2107692307 
HWServlet
//#endif 

  { 

//#if -1985352182 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 

//#if -921926554 
PrintWriter out = response.getWriter();
//#endif 


//#if -1857826712 
response.setContentType("text/html");
//#endif 


//#if 1053695632 
int codigoEsp =  Integer.parseInt(request.getParameter("codEspecialidade"));
//#endif 


//#if 1901469229 
try //1
{ 

//#if -1479269790 
IteratorDsk repUS = facade.searchHealthUnitsBySpeciality(codigoEsp);
//#endif 


//#if 694871645 
out.println(HTMLCode.open("Queries - Health Unit"));
//#endif 


//#if -1999014805 
out.println("<body><h1>Querie result<br>Health units</h1>");
//#endif 


//#if -1170802951 
out.println("<P><h3>Medical specialty: " + codigoEsp + "</h3></P>");
//#endif 


//#if -2127027945 
out.println("<h3>Health units:</h3>");
//#endif 


//#if -827316408 
while (repUS.hasNext()) //1
{ 

//#if 2133854898 
HealthUnit us = (HealthUnit) repUS.next();
//#endif 


//#if 433051505 
out.println("<dd><dd>" + us.getDescription());
//#endif 

} 

//#endif 


//#if 1487012890 
out.println(HTMLCode.closeQueries());
//#endif 

} 

//#if -2077382884 
catch(RemoteException e) //1
{ 

//#if -502875791 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -1934030937 
e.printStackTrace(out);
//#endif 

} 

//#endif 


//#if 2076576164 
catch (ObjectNotFoundException e) //1
{ 

//#if -572868318 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 1010358048 
catch (RepositoryException e) //1
{ 

//#if -226585927 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 1917186372 
catch (TransactionException e) //1
{ 

//#if -254455162 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if 929917500 
catch (CommunicationException e) //1
{ 

//#if 1088969245 
out.println("<P> " + e.getMessage() + " </P>");
//#endif 

} 

//#endif 


//#if -1738752202 
catch(Exception e) //1
{ 

//#if 1371885534 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif 


//#if -2039314540 
e.printStackTrace(out);
//#endif 

} 

//#endif 

finally { 

//#if 1127450630 
out.close();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

