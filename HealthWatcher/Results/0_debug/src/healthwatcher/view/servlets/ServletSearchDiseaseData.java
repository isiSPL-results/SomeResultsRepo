
//#if 557422222
// Compilation Unit of /ServletSearchDiseaseData.java


//#if 1667112387
package healthwatcher.view.servlets;
//#endif


//#if -1385237483
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if 838762274
import healthwatcher.model.complaint.Symptom;
//#endif


//#if -1180931384
import java.io.IOException;
//#endif


//#if -560711151
import java.io.PrintWriter;
//#endif


//#if 1479116932
import java.rmi.RemoteException;
//#endif


//#if 2088587603
import java.util.Iterator;
//#endif


//#if -530333290
import javax.servlet.ServletException;
//#endif


//#if 910363998
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -202538872
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -159475461
import lib.exceptions.CommunicationException;
//#endif


//#if 1731255713
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 498530461
import lib.exceptions.RepositoryException;
//#endif


//#if -1788425149
import lib.exceptions.TransactionException;
//#endif


//#if -596266918
import lib.util.HTMLCode;
//#endif


//#if -1636926445
public class ServletSearchDiseaseData extends
//#if -582960311
    HWServlet
//#endif

{

//#if -559494080
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if 730226134
        PrintWriter out = response.getWriter();
//#endif


//#if 2114266360
        response.setContentType("text/html");
//#endif


//#if -1812277115
        int codigoTipoDoenca = Integer.parseInt(request.getParameter("codTipoDoenca"));
//#endif


//#if 1100028829
        try { //1

//#if -369392709
            DiseaseType tp = facade.searchDiseaseType(codigoTipoDoenca);
//#endif


//#if 1485415103
            out.println(HTMLCode.open("Queries - Diseases"));
//#endif


//#if 854112393
            out.println("<body><h1>Querie result<br>Disease</h1>");
//#endif


//#if -1644254143
            out.println("<P><h3>Name: " + tp.getName() + "</h3></P>");
//#endif


//#if -411729244
            out.println("<P>Description: " + tp.getDescription() + "</P>");
//#endif


//#if 1631958318
            out.println("<P>How manifests: " + tp.getManifestation()
                        + " </P>");
//#endif


//#if -2032616722
            out.println("<P>Duration: " + tp.getDuration() + " </P>");
//#endif


//#if -1475928163
            out.println("<P>Symptoms: </P>");
//#endif


//#if -862962456
            Iterator i = tp.getSymptoms().iterator();
//#endif


//#if -741312510
            if(! i.hasNext()) { //1

//#if -293589433
                out.println("<P>There isn't registered symptoms.</P>");
//#endif

            } else {

//#if -720575658
                while(i.hasNext()) { //1

//#if 1683609760
                    Symptom s = (Symptom) i.next();
//#endif


//#if 1366349705
                    out.println("<li> " + s.getDescription() + " </li>");
//#endif

                }

//#endif

            }

//#endif


//#if -321685435
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if 1381923834
        catch(RemoteException e) { //1

//#if 2037935504
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 773459014
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 1497047170
        catch (ObjectNotFoundException e) { //1

//#if -1496963252
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 706219262
        catch (RepositoryException e) { //1

//#if -48780449
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1078818598
        catch (TransactionException e) { //1

//#if -690373094
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1582628962
        catch (CommunicationException e) { //1

//#if -125132935
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1114762604
        catch(Exception e) { //1

//#if 263286967
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if -900736019
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if 374681979
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

