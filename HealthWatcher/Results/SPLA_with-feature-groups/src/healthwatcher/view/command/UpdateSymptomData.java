
//#if 1738037463
// Compilation Unit of /UpdateSymptomData.java

package healthwatcher.view.command;

//#if -119769099
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -1909614970
import healthwatcher.view.IFacade;
//#endif


//#if 917754276
import java.io.PrintWriter;
//#endif


//#if 1351180735
import lib.exceptions.InvalidSessionException;
//#endif


//#if 1756106925
import lib.util.HTMLCode;
//#endif

public class UpdateSymptomData extends Command
{
    public UpdateSymptomData(IFacade f)
    {
        super(f);
    }


//#if -165124292
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

//#endif


//#if -313082746
    public void execute()
    {
        PrintWriter out= null;
        try { //1
            out = response.getWriter();
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

        finally {
            out.close();
        }

    }

//#endif

}


//#endif

