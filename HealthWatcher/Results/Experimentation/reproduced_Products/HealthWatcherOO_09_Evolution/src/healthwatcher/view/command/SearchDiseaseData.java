package healthwatcher.view.command;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
public class SearchDiseaseData extends Command
{
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            out = response.getWriter();
        } catch (IOException e1) { //1
            e1.printStackTrace();
        }
        int codigoTipoDoenca = Integer.parseInt(request
                                                .getInput("codTipoDoenca"));
        try { //2
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
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (Exception e) { //1
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }
    public SearchDiseaseData(IFacade f)
    {
        super(f);
    }

}
