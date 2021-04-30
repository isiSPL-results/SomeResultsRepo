package healthwatcher.view.command;

import healthwatcher.model.healthguide.MedicalSpeciality;
import healthwatcher.view.IFacade;

import java.io.PrintWriter;

import lib.exceptions.CommunicationException;
import lib.exceptions.FacadeUnavailableException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;


public class InsertMedicalSpeciality extends Command
{

    public InsertMedicalSpeciality(IFacade f)
    {
        super(f);
    }

    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();

        MedicalSpeciality speciality = null;

        try {
            if (! request.isAuthorized()) {
                throw new InvalidSessionException();
            }

            //Complaint Normal
            String code = request.getInput("code");
            String description = request.getInput("description");

            speciality = new MedicalSpeciality(description);
            speciality.setCodigo(Integer.parseInt(code));
            facade.insert(speciality);

            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "MedicalSpecialty inserted"));
        } catch (ObjectAlreadyInsertedException e) {
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch (ObjectNotValidException e) {
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch(InsertEntryException e) {
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch (InvalidSessionException e) {
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch(TransactionException e) {
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch(CommunicationException e) {
            throw new FacadeUnavailableException();
        } catch(RepositoryException e) {
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }
    }

}
