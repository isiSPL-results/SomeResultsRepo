package healthwatcher.view.command;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.CommunicationException;
import lib.exceptions.InsertEntryException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.exceptions.FacadeUnavailableException;
public class InsertDiseaseType extends Command
{
    public InsertDiseaseType(IFacade f)
    {
        super(f);
    }
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        DiseaseType diseaseType = null;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }
            String code = request.getInput("code");
            String name = request.getInput("name");
            String description = request.getInput("description");
            String manifestacao = request.getInput("manifestacao");
            String duration = request.getInput("duration");
            diseaseType = new DiseaseType(name, description, manifestacao, duration, null);
            diseaseType.setCode(Integer.parseInt(code));
            facade.insert(diseaseType);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "DiseaseType inserted"));
        } catch (ObjectAlreadyInsertedException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch (ObjectNotValidException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch(InsertEntryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch (InvalidSessionException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch(TransactionException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        } catch(CommunicationException e) { //1
            throw new FacadeUnavailableException();
        } catch(RepositoryException e) { //1
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }
    }

}
