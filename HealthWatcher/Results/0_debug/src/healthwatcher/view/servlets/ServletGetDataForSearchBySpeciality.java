
//#if -566944454
// Compilation Unit of /ServletGetDataForSearchBySpeciality.java


//#if 1425429462
package healthwatcher.view.servlets;
//#endif


//#if 1689051137
import healthwatcher.Constants;
//#endif


//#if 575938333
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if 1406305109
import java.io.IOException;
//#endif


//#if 2026525342
import java.io.PrintWriter;
//#endif


//#if -1801601001
import java.rmi.RemoteException;
//#endif


//#if -859390231
import javax.servlet.ServletException;
//#endif


//#if 788200619
import javax.servlet.http.HttpServletRequest;
//#endif


//#if 305363675
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -281638840
import lib.exceptions.CommunicationException;
//#endif


//#if -2055809036
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -85650320
import lib.exceptions.RepositoryException;
//#endif


//#if 1576807120
import lib.exceptions.TransactionException;
//#endif


//#if -964523993
import lib.util.HTMLCode;
//#endif


//#if -1512438775
import lib.util.IteratorDsk;
//#endif


//#if -1538522987
public class ServletGetDataForSearchBySpeciality extends
//#if 485931517
    HWServlet
//#endif

{

//#if 49640800
    public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if -749681343
        PrintWriter out;
//#endif


//#if 965537011
        response.setContentType("text/html");
//#endif


//#if 2059625667
        out = response.getWriter();
//#endif


//#if 1045922512
        out.println(HTMLCode.open("Queries - Health Units"));
//#endif


//#if -1844997019
        out.println("<body><h1>Queries:<br>Search Health units by Medical specialty</h1>");
//#endif


//#if -2082685030
        out.println("<p>Choose a specialty: </p>");
//#endif


//#if -208917391
        out.println("<form method=\"POST\"action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletSearchHealthUnitsBySpecialty\">");
//#endif


//#if 198256386
        try { //1

//#if -814189323
            out.println("<div align=\"center\"><center><p><select name=\"codEspecialidade\" size=\"1\">");
//#endif


//#if 1322533998
            IteratorDsk repEsp = facade.getSpecialityList();
//#endif


//#if 786748816
            if(!repEsp.hasNext()) { //1

//#if 1893563733
                out.println("</select></p></center></div>");
//#endif


//#if -601670623
                out.println("<P>There isn't registered specialties.</P>");
//#endif

            } else {

//#if 1433999529
                MedicalSpeciality esp;
//#endif


//#if -625178771
                do {

//#if 1074211430
                    esp = (MedicalSpeciality) repEsp.next();
//#endif


//#if -2140078234
                    out.println("<option value=\"" + esp.getCodigo() + "\"> "+ esp.getDescricao() + " </OPTION>");
//#endif

                } while (repEsp.hasNext()); //1

//#endif


//#if -2081489899
                repEsp.close();
//#endif


//#if 97790235
                out.println("</select></p></center></div>");
//#endif


//#if -125544231
                out.println(" <div align=\"center\"><center><p><input type=\"submit\" value=\"Consultar\" name=\"B1\"></p></center></div></form>");
//#endif

            }

//#endif


//#if 1076491377
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if -1622836321
        catch(RemoteException e) { //1

//#if 886705715
            out.println("Error!");
//#endif


//#if 439373186
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 474821432
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 449751847
        catch (ObjectNotFoundException e) { //1

//#if 491847258
            out.println("</select></p></center></div>");
//#endif


//#if -602205150
            out.println("<P> " + e.getMessage() + " </P>");
//#endif


//#if 1748329212
            out.println("<P> Nenhuma especialidade foi cadastrada</P>");
//#endif

        }

//#endif


//#if -1501777373
        catch (RepositoryException e) { //1

//#if 1932820858
            out.println("</select></p></center></div>");
//#endif


//#if 1056662786
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1350399649
        catch (TransactionException e) { //1

//#if 1557410320
            out.println("</select></p></center></div>");
//#endif


//#if 626879532
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1708723289
        catch (CommunicationException e) { //1

//#if -1660723380
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 84079097
        catch(Exception e) { //1

//#if 1008650205
            out.println("Error!");
//#endif


//#if -1450421224
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if -39866674
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -1970455601
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

