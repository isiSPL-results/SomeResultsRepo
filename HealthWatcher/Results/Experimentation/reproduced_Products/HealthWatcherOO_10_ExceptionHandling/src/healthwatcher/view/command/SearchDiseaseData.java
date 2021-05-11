package healthwatcher.view.command;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import java.util.Iterator;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.exceptions.FacadeUnavailableException;
public class SearchDiseaseData extends Command
{
    public SearchDiseaseData(IFacade f)
    {
        super(f);
    }
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        int codigoTipoDoenca = Integer.parseInt(request
                                                .getInput("codTipoDoenca"));
        try { //1
            DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
            out.println(HTMLCode.open("Queries - Diseases"));
            out.println("<body><h1>Querie result<br>Disease</h1>");
            out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
            out.println("<P>Description: " + tp.getDescription() + "</P>");
            out.println("<P>How manifests: " + tp.getManifestation() + " </P>");
            out.println("<P>Duration: " + tp.getDuration() + " </P>");
            out.println("<P>Symptoms: </P>");
            Iterator i = tp.getSymptoms().iterator();
            if(!i.hasNext()) { //1
                out.println("<P>There isn't registered symptoms.</P>");
            } else {
                while (i.hasNext()) { //1
                    Symptom s = (Symptom) i.next();
                    out.println("<li> " + s.getDescription() + " </li>");
                }
            }
            out.println(HTMLCode.closeQueries());
        } catch (ObjectNotFoundException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (RepositoryException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (TransactionException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        } catch (Exception e) { //1
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }
    }

}
