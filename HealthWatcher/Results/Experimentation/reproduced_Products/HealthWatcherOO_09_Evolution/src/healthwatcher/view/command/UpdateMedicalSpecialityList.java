package healthwatcher.view.command;
import healthwatcher.Constants;
import healthwatcher.model.healthguide.MedicalSpeciality;
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
public class UpdateMedicalSpecialityList extends Command
{
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            try { //1
                out = response.getWriter();
            } catch (IOException e1) { //1
                e1.printStackTrace();
            }
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
            }
            out.println("Queries - Medical Speciality information");
            out.println("<body><h1>Queries:<br>Querie about medical specialities</h1>");
            out.println("<p>Choose a speciality: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateMedicalSpecialitySearch\">");
            out.println("<div align=\"center\"><center><p><select name=\"specialityCode\" size=\"1\">");
            IteratorDsk repTP = facade.getSpecialityList();
            if(repTP == null || !repTP.hasNext()) { //1
                out.println("</select></p></center></div>");
                out.println("<p><font color=\"red\"><b> There isn't any medical speciality.</b></font></p>");
            } else {
                MedicalSpeciality speciality;
                do {
                    speciality = (MedicalSpeciality) repTP.next();
                    out.println("<option value=\"" + speciality.getCodigo() + "\"> "
                                + speciality.getDescricao() + " </OPTION>");
                } while (repTP.hasNext()); //1
                repTP.close();
                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateMedicalSpecialitySearch\" name=\"operation\"></p></center></div></form>");
            }
            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println("There isn't any medical speciality");
        } catch (RepositoryException e) { //1
            e.printStackTrace();
        } catch (TransactionException e) { //1
            e.printStackTrace();
        } catch (CommunicationException e) { //1
            e.printStackTrace();
        } catch (InvalidSessionException e) { //1
            out.println(e.getMessage());
        } finally {
            out.close();
        }
    }
    public UpdateMedicalSpecialityList(IFacade f)
    {
        super(f);
    }

}
