
//#if 713010592
// Compilation Unit of /SearchDiseaseData.java


//#if 1174737693
package healthwatcher.view.command;
//#endif


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


//#if -966649145
public class SearchDiseaseData extends
//#if 75372040
    Command
//#endif

{

//#if -894655562
    public void execute()
    {

//#if -777356474
        PrintWriter out = null;
//#endif


//#if -1096056105
        try { //1

//#if -788624881
            out = response.getWriter();
//#endif

        }

//#if 1990860834
        catch (IOException e1) { //1

//#if -1731303881
            e1.printStackTrace();
//#endif

        }

//#endif


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


//#if 2029003898
        try { //2

//#if -2052843192
            DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
//#endif


//#if 1257788556
            out.println(HTMLCode.open("Queries - Diseases"));
//#endif


//#if 672257564
            out.println("<body><h1>Querie result<br>Disease</h1>");
//#endif


//#if 289542222
            out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
//#endif


//#if -1059086665
            out.println("<P>Description: " + tp.getDescription() + "</P>");
//#endif


//#if 610188347
            out.println("<P>How manifests: " + tp.getManifestation() + " </P>");
//#endif


//#if 1354899777
            out.println("<P>Duration: " + tp.getDuration() + " </P>");
//#endif


//#if 371633520
            out.println("<P>Symptoms: </P>");
//#endif


//#if 1339351163
            Iterator i = tp.getSymptoms().iterator();
//#endif


//#if 41938767
            if(!i.hasNext()) { //1

//#if -2054787648
                out.println("<P>There isn't registered symptoms.</P>");
//#endif

            } else {

//#if 221417577
                while (i.hasNext()) { //1

//#if -1422661247
                    Symptom s = (Symptom) i.next();
//#endif


//#if 1225960938
                    out.println("<li> " + s.getDescription() + " </li>");
//#endif

                }

//#endif

            }

//#endif


//#if 2104661586
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if 1976520986
        catch (RemoteException e) { //1

//#if -1885502648
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if -1065925122
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -2053843550
        catch (ObjectNotFoundException e) { //1

//#if 1229266921
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -791064034
        catch (RepositoryException e) { //1

//#if -1886808055
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1907676678
        catch (TransactionException e) { //1

//#if -1910992137
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 381036158
        catch (CommunicationException e) { //1

//#if -1451604296
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 655179700
        catch (Exception e) { //1

//#if -243239981
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if 1235669257
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -123099442
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 1883120208
    public SearchDiseaseData(IFacade f)
    {

//#if -458822319
        super(f);
//#endif

    }

//#endif


//#if 247544332
    public void execute() throws Exception
    {

//#if -1136195536
        PrintWriter out = response.getWriter();
//#endif


//#if 129109150
        int codigoTipoDoenca = Integer.parseInt(request
                                                .getInput("codTipoDoenca"));
//#endif


//#if -1587118217
        try { //1

//#if 843553777
            DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
//#endif


//#if -787061131
            out.println(HTMLCode.open("Queries - Diseases"));
//#endif


//#if -1541374957
            out.println("<body><h1>Querie result<br>Disease</h1>");
//#endif


//#if 2019250039
            out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
//#endif


//#if -1465093842
            out.println("<P>Description: " + tp.getDescription() + "</P>");
//#endif


//#if -121716124
            out.println("<P>How manifests: " + tp.getManifestation() + " </P>");
//#endif


//#if 2103433464
            out.println("<P>Duration: " + tp.getDuration() + " </P>");
//#endif


//#if 56501927
            out.println("<P>Symptoms: </P>");
//#endif


//#if 1732531314
            Iterator i = tp.getSymptoms().iterator();
//#endif


//#if 1781057720
            if(!i.hasNext()) { //1

//#if -140082285
                out.println("<P>There isn't registered symptoms.</P>");
//#endif

            } else {

//#if -478948627
                while (i.hasNext()) { //1

//#if 248143756
                    Symptom s = (Symptom) i.next();
//#endif


//#if 291811445
                    out.println("<li> " + s.getDescription() + " </li>");
//#endif

                }

//#endif

            }

//#endif


//#if 316229499
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if 105590505
        catch (ObjectNotFoundException e) { //1

//#if 1765534267
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 46491365
        catch (RepositoryException e) { //1

//#if -1488614069
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 2102090271
        catch (TransactionException e) { //1

//#if 1516193041
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1766061993
        catch (CommunicationException e) { //1

//#if 301062002
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#if 1212174651
        catch (Exception e) { //1

//#if -201308146
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if -399546428
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif

}

//#endif


//#endif

