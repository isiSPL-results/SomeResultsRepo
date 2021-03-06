package healthwatcher.view.command;

import healthwatcher.Constants;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.view.IFacade;

import java.io.IOException;
import java.io.PrintWriter;

import lib.exceptions.CommunicationException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;

public class UpdateSymptomList extends Command
{

    public UpdateSymptomList(IFacade f)
    {
        super(f);
    }

    public void execute()
    {

        PrintWriter out = null;

        try {
            try {
                out = response.getWriter();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (! request.isAuthorized()) {
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
            }

            out.println("Queries - Symptom information");
            out.println("<body><h1>Queries:<br>Querie about symptoms</h1>");
            out.println("<p>Choose a symptom: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateSymptomSearch\">");

            out.println("<div align=\"center\"><center><p><select name=\"symptomCode\" size=\"1\">");

            IteratorDsk repTP = facade.getSymptomList();

            if (repTP == null || !repTP.hasNext()) {
                out.println("</select></p></center></div>");
                out.println("<p><font color=\"red\"><b> There isn't any symptoms.</b></font></p>");
            } else {
                Symptom symptom;
                do {
                    symptom = (Symptom) repTP.next();
                    out.println("<option value=\"" + symptom.getCode() + "\"> "
                                + symptom.getDescription() + " </OPTION>");
                } while (repTP.hasNext());
                repTP.close();

                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateSymptomSearch\" name=\"operation\"></p></center></div></form>");
            }
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) {
            out.println("There isn't any symptom");
        } catch (RepositoryException e) {
            e.printStackTrace();
        } catch (TransactionException e) {
            e.printStackTrace();
        } catch (CommunicationException e) {
            e.printStackTrace();
        } catch (InvalidSessionException e) {
            out.println(e.getMessage());
        } finally {
            out.close();
        }
    }

}
