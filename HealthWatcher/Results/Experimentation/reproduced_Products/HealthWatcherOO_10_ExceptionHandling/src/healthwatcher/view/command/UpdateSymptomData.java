package healthwatcher.view.command;
import healthwatcher.model.complaint.Symptom;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class UpdateSymptomData extends Command
{
    public UpdateSymptomData(IFacade f)
    {
        super(f);
    }
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            Symptom symptom;
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }
            symptom = (Symptom) request.get(UpdateSymptomSearch.SYMPTOM);
            String descricao = request.getInput("descricao");
            symptom.setDescription(descricao);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom updated"));
        } catch(Exception e) { //1
            out.println(HTMLCode.errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }
    }

}
