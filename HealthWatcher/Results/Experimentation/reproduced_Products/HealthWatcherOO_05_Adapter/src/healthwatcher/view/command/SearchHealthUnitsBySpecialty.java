package healthwatcher.view.command;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;
public class SearchHealthUnitsBySpecialty extends Command
{
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            out = response.getWriter();
        } catch (IOException e1) { //1
            e1.printStackTrace();
        }
        response.setContentType("text/html");
        int codigoEsp =  Integer.parseInt(request.getParameter("codEspecialidade"));
        try { //2
            IteratorDsk repUS = facade.searchHealthUnitsBySpeciality(codigoEsp);
            out.println(HTMLCode.open("Queries - Health Unit"));
            out.println("<body><h1>Querie result<br>Health units</h1>");
            out.println("<P><h3>Medical specialty: " + codigoEsp + "</h3></P>");
            out.println("<h3>Health units:</h3>");
            while (repUS.hasNext()) { //1
                HealthUnit us = (HealthUnit) repUS.next();
                out.println("<dd><dd>" + us.getDescription());
            }
            out.println(HTMLCode.closeQueries());
        } catch (ObjectNotFoundException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (RepositoryException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (TransactionException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (CommunicationException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }
    public SearchHealthUnitsBySpecialty(IFacade f)
    {
        super(f);
    }

}
