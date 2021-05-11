
//#if -1094963893
// Compilation Unit of /SearchHealthUnitsBySpecialty.java

package healthwatcher.view.command;

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

public class SearchHealthUnitsBySpecialty extends Command
{

//#if 813237465
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        int codigoEsp =  Integer.parseInt(request.getInput("codEspecialidade"));
        try { //1
            IteratorDsk repUS = facade.searchHealthUnitsBySpeciality(codigoEsp);
            out.println(HTMLCode.open("Queries - Health Unit"));
            out.println("<body><h1>Querie result<br>Health units</h1>");
            out.println("<P><h3>Medical specialty: " + codigoEsp + "</h3></P>");
            out.println("<h3>Health units:</h3>");
            while (repUS.hasNext()) { //1
                HealthUnit us = (HealthUnit) repUS.next();
                out.println("<dd><dd>" + us.getDescription());
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

        catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }


    }

//#endif


//#if -577488759
    public void execute()
    {
        PrintWriter out = null;
        try { //1
            out = response.getWriter();
        }

//#if -389245819
        catch (IOException e1) { //1
            e1.printStackTrace();
        }

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

        try { //2
            IteratorDsk repUS = facade.searchHealthUnitsBySpeciality(codigoEsp);
            out.println(HTMLCode.open("Queries - Health Unit"));
            out.println("<body><h1>Querie result<br>Health units</h1>");
            out.println("<P><h3>Medical specialty: " + codigoEsp + "</h3></P>");
            out.println("<h3>Health units:</h3>");
            while (repUS.hasNext()) { //1
                HealthUnit us = (HealthUnit) repUS.next();
                out.println("<dd><dd>" + us.getDescription());
            }

            out.println(HTMLCode.closeQueries());
        }

//#if -236201043
        catch(RemoteException e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }

//#endif


//#if 752033077
        catch (ObjectNotFoundException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if 2142788401
        catch (RepositoryException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if -1632178349
        catch (TransactionException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if 194453643
        catch (CommunicationException e) { //1
            out.println("<P> " + e.getMessage() + " </P>");
        }

//#endif


//#if 1807611015
        catch(Exception e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
            e.printStackTrace(out);
        }

//#endif

        finally {
            out.close();
        }

    }

//#endif

    public SearchHealthUnitsBySpecialty(IFacade f)
    {
        super(f);
    }

}


//#endif

