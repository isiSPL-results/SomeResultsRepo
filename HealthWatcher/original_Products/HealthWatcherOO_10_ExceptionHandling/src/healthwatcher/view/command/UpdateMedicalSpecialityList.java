package healthwatcher.view.command;

import healthwatcher.Constants;
import healthwatcher.model.healthguide.MedicalSpeciality;
import healthwatcher.view.IFacade;

import java.io.PrintWriter;

import lib.exceptions.CommunicationException;
import lib.exceptions.FacadeUnavailableException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;

public class UpdateMedicalSpecialityList extends Command
{

    public UpdateMedicalSpecialityList(IFacade f)
    {
        super(f);
    }

    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();

        try {

            if (! request.isAuthorized()) {
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
            }
            // Facade calls must come before using out
            IteratorDsk repTP = facade.getSpecialityList();

            out.println("Queries - Medical Speciality information");
            out.println("<body><h1>Queries:<br>Querie about medical specialities</h1>");
            out.println("<p>Choose a speciality: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateMedicalSpecialitySearch\">");

            out.println("<div align=\"center\"><center><p><select name=\"specialityCode\" size=\"1\">");


            if (repTP == null || !repTP.hasNext()) {
                out.println("</select></p></center></div>");
                out.println("<p><font color=\"red\"><b> There isn't any medical speciality.</b></font></p>");
            } else {
                MedicalSpeciality speciality;
                do {
                    speciality = (MedicalSpeciality) repTP.next();
                    out.println("<option value=\"" + speciality.getCodigo() + "\"> "
                                + speciality.getDescricao() + " </OPTION>");
                } while (repTP.hasNext());
                repTP.close();

                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateMedicalSpecialitySearch\" name=\"operation\"></p></center></div></form>");
            }
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) {
            out.println("There isn't any medical speciality");
        } catch (RepositoryException e) {
            e.printStackTrace();
        } catch (TransactionException e) {
            e.printStackTrace();
        } catch (CommunicationException e) {
            throw new FacadeUnavailableException();
        } catch (InvalidSessionException e) {
            out.println(e.getMessage());
        }
    }
}
