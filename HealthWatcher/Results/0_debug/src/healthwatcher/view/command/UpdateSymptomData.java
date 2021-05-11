
//#if 1738037463
// Compilation Unit of /UpdateSymptomData.java


//#if -1796736627
package healthwatcher.view.command;
//#endif


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


//#if 455135651
public class UpdateSymptomData extends
//#if -378870056
    Command
//#endif

{

//#if 56046732
    public UpdateSymptomData(IFacade f)
    {

//#if -1485941345
        super(f);
//#endif

    }

//#endif


//#if -165124292
    public void execute() throws Exception
    {

//#if 1098146808
        PrintWriter out = response.getWriter();
//#endif


//#if -855299777
        try { //1

//#if -1047376748
            Symptom symptom;
//#endif


//#if -1849049014
            if(! request.isAuthorized()) { //1

//#if 574456312
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 1664398647
            symptom = (Symptom) request.get(UpdateSymptomSearch.SYMPTOM);
//#endif


//#if 1037752580
            String descricao = request.getInput("descricao");
//#endif


//#if -434991815
            symptom.setDescription(descricao);
//#endif


//#if 1323778468
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom updated"));
//#endif

        }

//#if -1997238981
        catch(Exception e) { //1

//#if 1268557298
            out.println(HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 411250585
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -313082746
    public void execute()
    {

//#if -283083554
        PrintWriter out= null;
//#endif


//#if 1434562159
        try { //1

//#if 1013407069
            out = response.getWriter();
//#endif


//#if 303176329
            Symptom symptom;
//#endif


//#if 45066677
            if(! request.isAuthorized()) { //1

//#if 892169443
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 905420834
            symptom = (Symptom) request.get(UpdateSymptomSearch.SYMPTOM);
//#endif


//#if -1764848529
            String descricao = request.getInput("descricao");
//#endif


//#if 901761316
            symptom.setDescription(descricao);
//#endif


//#if -94184561
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "Symptom updated"));
//#endif

        }

//#if -1352559949
        catch(Exception e) { //1

//#if 1090301830
            out.println(HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 975156869
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -1724747404
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

