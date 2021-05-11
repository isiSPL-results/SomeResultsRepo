
//#if -1094963893
// Compilation Unit of /SearchHealthUnitsBySpecialty.java


//#if 157390824
package healthwatcher.view.command;
//#endif


//#if 707707090
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if 2032746699
import healthwatcher.view.IFacade;
//#endif


//#if -1424282698
import java.io.IOException;
//#endif


//#if -804062465
import java.io.PrintWriter;
//#endif


//#if -570151850
import java.rmi.RemoteException;
//#endif


//#if -1036764567
import lib.exceptions.CommunicationException;
//#endif


//#if 305097203
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1551662575
import lib.exceptions.RepositoryException;
//#endif


//#if 793899313
import lib.exceptions.TransactionException;
//#endif


//#if -1830038328
import lib.util.HTMLCode;
//#endif


//#if 933652424
import lib.util.IteratorDsk;
//#endif


//#if -141432215
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if -429321752
public class SearchHealthUnitsBySpecialty extends
//#if 1863847771
    Command
//#endif

{

//#if 813237465
    public void execute() throws Exception
    {

//#if -1420295850
        PrintWriter out = response.getWriter();
//#endif


//#if 1175549281
        int codigoEsp =  Integer.parseInt(request.getInput("codEspecialidade"));
//#endif


//#if 1668669213
        try { //1

//#if 1785956391
            IteratorDsk repUS = facade.searchHealthUnitsBySpeciality(codigoEsp);
//#endif


//#if 1615885858
            out.println(HTMLCode.open("Queries - Health Unit"));
//#endif


//#if 1179177542
            out.println("<body><h1>Querie result<br>Health units</h1>");
//#endif


//#if 1388179284
            out.println("<P><h3>Medical specialty: " + codigoEsp + "</h3></P>");
//#endif


//#if 72052828
            out.println("<h3>Health units:</h3>");
//#endif


//#if 552891917
            while (repUS.hasNext()) { //1

//#if 124340635
                HealthUnit us = (HealthUnit) repUS.next();
//#endif


//#if -1154579558
                out.println("<dd><dd>" + us.getDescription());
//#endif

            }

//#endif


//#if -608873633
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if -1582672901
        catch (ObjectNotFoundException e) { //1

//#if -1153538437
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1785338633
        catch (RepositoryException e) { //1

//#if 1038998733
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1149935181
        catch (TransactionException e) { //1

//#if -2015697293
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1959069435
        catch (CommunicationException e) { //1

//#if 1231633590
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#if -2078155315
        catch(Exception e) { //1

//#if -1209080915
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 323589091
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -577488759
    public void execute()
    {

//#if 364663287
        PrintWriter out = null;
//#endif


//#if -2138606776
        try { //1

//#if -814702316
            out = response.getWriter();
//#endif

        }

//#if -389245819
        catch (IOException e1) { //1

//#if 157691407
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 1044289517
        response.setContentType("text/html");
//#endif


//#if -1455537941
        int codigoEsp =  Integer.parseInt(request.getParameter("codEspecialidade"));
//#endif


//#if 1291010124
        int codigoEsp =  Integer.parseInt(request.getInput("codEspecialidade"));
//#endif


//#if 310481513
        try { //2

//#if -1847917527
            IteratorDsk repUS = facade.searchHealthUnitsBySpeciality(codigoEsp);
//#endif


//#if 98842148
            out.println(HTMLCode.open("Queries - Health Unit"));
//#endif


//#if 864023684
            out.println("<body><h1>Querie result<br>Health units</h1>");
//#endif


//#if -1359101294
            out.println("<P><h3>Medical specialty: " + codigoEsp + "</h3></P>");
//#endif


//#if -2054315170
            out.println("<h3>Health units:</h3>");
//#endif


//#if 1371118607
            while (repUS.hasNext()) { //1

//#if 1828927708
                HealthUnit us = (HealthUnit) repUS.next();
//#endif


//#if 701382171
                out.println("<dd><dd>" + us.getDescription());
//#endif

            }

//#endif


//#if 1559725665
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if -236201043
        catch(RemoteException e) { //1

//#if 415646029
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if -1422515837
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 752033077
        catch (ObjectNotFoundException e) { //1

//#if 421077379
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 2142788401
        catch (RepositoryException e) { //1

//#if -886487865
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1632178349
        catch (TransactionException e) { //1

//#if 1236114029
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 194453643
        catch (CommunicationException e) { //1

//#if -1998085036
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1807611015
        catch(Exception e) { //1

//#if 1452522747
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if -1503754703
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if 1135139807
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 1064577843
    public SearchHealthUnitsBySpecialty(IFacade f)
    {

//#if -1825941376
        super(f);
//#endif

    }

//#endif

}

//#endif


//#endif

