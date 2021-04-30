
//#if -1898087170 
// Compilation Unit of /ServletUpdateHealthUnitData.java 
 
package healthwatcher.view.servlets;
import healthwatcher.model.healthguide.HealthUnit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class ServletUpdateHealthUnitData extends HWServlet
  { 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 
PrintWriter out = response.getWriter();
HttpSession session = request.getSession(true);
response.setContentType("text/html");
HealthUnit unit;
try //1
{ 
if(session == null)//1
{ 
throw new InvalidSessionException();
} 

unit = (HealthUnit) session.getValue(ServletUpdateHealthUnitSearch.HEALTH_UNIT);
String descricao = request.getParameter("descricao");
unit.setDescription(descricao);
out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Health Unit updated"));
facade.updateHealthUnit(unit);
} 
catch(Exception e) //1
{ 
out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
} 

finally { 
out.close();
} 

} 

 } 


//#endif 

