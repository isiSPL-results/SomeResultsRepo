package healthwatcher.view.command;

import healthwatcher.Constants;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.view.IFacade;

import java.io.IOException;
import java.io.PrintWriter;

import lib.exceptions.CommunicationException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;

public class GetDataForSearchByDiseaseType extends Command
{

    public GetDataForSearchByDiseaseType(IFacade f)
    {
        super(f);
        // TODO Auto-generated constructor stub
    }

    public void execute()
    {
        PrintWriter out = null;

        response.setContentType("text/html");

        try {
            out = response.getWriter();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        out.println(HTMLCode.open("Queries - Disease information"));
        out.println("<body><h1>Queries:<br>Querie about diseases</h1>");
        out.println("<p>Choose a disease: </p>");
        out
        .println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=SearchDiseaseData\">");

        try {
            out
            .println("<div align=\"center\"><center><p><select name=\"codTipoDoenca\" size=\"1\">");
            IteratorDsk repTP = facade.getDiseaseTypeList();

            if (repTP == null || !repTP.hasNext()) {
                out.println("</select></p></center></div>");
                out
                .println("<p><font color=\"red\"><b> There isn't diseases registered.</b></font></p>");
            } else {
                DiseaseType tp;
                do {
                    tp = (DiseaseType) repTP.next();

                    out.println("<option value=\"" + tp.getCode() + "\"> "
                                + tp.getName() + " </OPTION>");
                } while (repTP.hasNext());
                repTP.close();

                out.println("</select></p></center></div>");
                out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchDiseaseData\" name=\"operation\"></p></center></div></form>");
            }
            out.println(HTMLCode.closeQueries());

        } catch (ObjectNotFoundException e) {
            out.println(HTMLCode
                        .errorPageQueries("There isn't registered diseases"));
        } catch (RepositoryException e) {
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (TransactionException e) {
            out.println("</select></p></center></div>");
            out.println("<P> " + e.getMessage() + " </P>");
        } catch (CommunicationException e) {
            out.println("<P> " + e.getMessage() + " </P>");
        } finally {
            out.close();
        }

    }
}