
//#if 713010592
// Compilation Unit of /SearchDiseaseData.java

package healthwatcher.view.command;

//#if 1666672888
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if -1076699771
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -12645642
import healthwatcher.view.IFacade;
//#endif


//#if 1981000683
import java.io.IOException;
//#endif


//#if -1693746380
import java.io.PrintWriter;
//#endif


//#if -187923135
import java.rmi.RemoteException;
//#endif


//#if -1688739888
import java.util.Iterator;
//#endif


//#if -2074937506
import lib.exceptions.CommunicationException;
//#endif


//#if -1813492834
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -458822374
import lib.exceptions.RepositoryException;
//#endif


//#if -1401591962
import lib.exceptions.TransactionException;
//#endif


//#if 251715133
import lib.util.HTMLCode;
//#endif


//#if -512809762
import lib.exceptions.FacadeUnavailableException;
//#endif

public class SearchDiseaseData extends Command
{

//#if -894655562
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            out = response.getWriter();
        }

//#if 1990860834
        catch (IOException e1) { //1
            e1.printStackTrace();
        }

//#endif



//#if 575428222
        response.setContentType("text/html");
//#endif


//#if -1835361217
        int codigoTipoDoenca = Integer.parseInt(request
                                                .getParameter("codTipoDoenca"));
//#endif


//#if -323438594
        int codigoTipoDoenca = Integer.parseInt(request
                                                .getInput("codTipoDoenca"));
//#endif

        try { //2
            DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
            out.println(HTMLCode.open("Queries - Diseases"));
            out.println("<body><h1>Querie result<br>Disease</h1>");
            out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
            out.println("<P>Description: " + tp.getDescription() + "</P>");
            out.println("<P>How manifests: " + tp.getManifestation() + " </P>");
            out.println("<P>Duration: " + tp.getDuration() + " </P>");
            out.println("<P>Symptoms: </P>");
            Iterator i = tp.getSymptoms().iterator();
            if(!i.hasNext()) { //1
                out.println("<P>There isn't registered symptoms.</P>");
            } else {
                while (i.hasNext()) { //1
                    Symptom s = (Symptom) i.next();
                    out.println("<li> " + s.getDescription() + " </li>");
                }

            }

            out.println(HTMLCode.closeQueries());
        }

//#if 1976520986
        catch (RemoteException e) { //1
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }

//#endif


//#if -2053843550
        catch (ObjectNotFoundException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if -791064034
        catch (RepositoryException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if 1907676678
        catch (TransactionException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if 381036158
        catch (CommunicationException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if 655179700
        catch (Exception e) { //1
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }

//#endif

        finally {
            out.close();
        }

    }

//#endif

    public SearchDiseaseData(IFacade f)
    {
        super(f);
    }


//#if 247544332
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        int codigoTipoDoenca = Integer.parseInt(request
                                                .getInput("codTipoDoenca"));
        try { //1
            DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
            out.println(HTMLCode.open("Queries - Diseases"));
            out.println("<body><h1>Querie result<br>Disease</h1>");
            out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
            out.println("<P>Description: " + tp.getDescription() + "</P>");
            out.println("<P>How manifests: " + tp.getManifestation() + " </P>");
            out.println("<P>Duration: " + tp.getDuration() + " </P>");
            out.println("<P>Symptoms: </P>");
            Iterator i = tp.getSymptoms().iterator();
            if(!i.hasNext()) { //1
                out.println("<P>There isn't registered symptoms.</P>");
            } else {
                while (i.hasNext()) { //1
                    Symptom s = (Symptom) i.next();
                    out.println("<li> " + s.getDescription() + " </li>");
                }

            }

            out.println(HTMLCode.closeQueries());
        } catch (ObjectNotFoundException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

        catch (RepositoryException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

        catch (TransactionException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

        catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        }

        catch (Exception e) { //1
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }


    }

//#endif

}


//#endif

