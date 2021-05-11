package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.healthguide.HealthUnit;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;
import lib.exceptions.FacadeUnavailableException;
public class GetDataForSearchByHealthUnit extends Command
{
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            IteratorDsk repUS = facade.getPartialHealthUnitList();
            out.println(HTMLCode.open("Queries - Specialties"));
            out
            .println("<body><h1>Queries:<br>Search Specialties of a Health unit</h1>");
            out.println("<p>Choose a health unit: </p>");
            out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchSpecialtiesByHealthUnit\">");
            out
            .println("<div align=\"center\"><center><p><select name=\"codUnidadeSaude\" size=\"1\">");
            if(!repUS.hasNext()) { //1
                out.println("</select></p></center></div>");
                out.println("<P> There isn't registered health units.</P>");
            } else {
                HealthUnit us;
                do {
                    us = (HealthUnit) repUS.next();
                    out.println("<option value=\"" + us.getCode() + "\"> "
                                + us.getDescription() + " </OPTION>");
                } while (repUS.hasNext()); //1
                repUS.close();
                out.println("</select></p></center></div>");
                out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchSpecialtiesByHealthUnit\" name=\"operation\"></p></center></div></form>");
            }
            out.println(HTMLCode.closeQueries());
        } catch (ObjectNotFoundException e) { //1
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
            out.println("<P> Nenhuma unidade de saude foi cadastrada</P>");
        } catch (RepositoryException e) { //1
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (TransactionException e) { //1
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        } catch (Exception e) { //1
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }
    }
    public GetDataForSearchByHealthUnit(IFacade f)
    {
        super(f);
    }

}
