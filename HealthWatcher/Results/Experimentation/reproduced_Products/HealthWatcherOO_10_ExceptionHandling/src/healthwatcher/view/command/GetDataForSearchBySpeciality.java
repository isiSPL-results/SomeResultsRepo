package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.healthguide.MedicalSpeciality;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;
import lib.exceptions.FacadeUnavailableException;
public class GetDataForSearchBySpeciality extends Command
{
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            IteratorDsk repEsp = facade.getSpecialityList();
            out.println(HTMLCode.open("Queries - Health Units"));
            out
            .println("<body><h1>Queries:<br>Search Health units by Medical specialty</h1>");
            out.println("<p>Choose a specialty: </p>");
            out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchHealthUnitsBySpecialty\">");
            out
            .println("<div align=\"center\"><center><p><select name=\"codEspecialidade\" size=\"1\">");
            if(!repEsp.hasNext()) { //1
                out.println("</select></p></center></div>");
                out.println("<P>There isn't registered specialties.</P>");
            } else {
                MedicalSpeciality esp;
                do {
                    esp = (MedicalSpeciality) repEsp.next();
                    out.println("<option value=\"" + esp.getCodigo() + "\"> "
                                + esp.getDescricao() + " </OPTION>");
                } while (repEsp.hasNext()); //1
                repEsp.close();
                out.println("</select></p></center></div>");
                out
                .println(" <div align=\"center\"><center><p><input type=\"submit\" value=\"SearchHealthUnitsBySpecialty\" name=\"operation\"></p></center></div></form>");
            }
            out.println(HTMLCode.closeQueries());
        } catch (ObjectNotFoundException e) { //1
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
            out.println("<P> Nenhuma especialidade foi cadastrada</P>");
        } catch (RepositoryException e) { //1
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (TransactionException e) { //1
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        } catch (Exception e) { //1
            out.println("Error!");
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }
    }
    public GetDataForSearchBySpeciality(IFacade f)
    {
        super(f);
    }

}
