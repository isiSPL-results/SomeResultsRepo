
//#if 1655438892
// Compilation Unit of /UpdateComplaintList.java

package healthwatcher.view.command;

//#if 1273217148
import healthwatcher.Constants;
//#endif


//#if 1480105832
import healthwatcher.model.complaint.Complaint;
//#endif


//#if -1698565647
import healthwatcher.view.IFacade;
//#endif


//#if 191551824
import java.io.IOException;
//#endif


//#if 811772057
import java.io.PrintWriter;
//#endif


//#if -960601840
import javax.servlet.http.HttpSession;
//#endif


//#if 1664152746
import lib.exceptions.InvalidSessionException;
//#endif


//#if -1900441063
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 379461858
import lib.util.HTMLCode;
//#endif


//#if -515084946
import lib.util.IteratorDsk;
//#endif

public class UpdateComplaintList extends Command
{

//#if 1269253304
    public void execute()
    {
        PrintWriter out= null;
        try { //1
            out = response.getWriter();

//#if 1188506320
            HttpSession session = request.getSession(false);
//#endif


//#if -1067096818
            response.setContentType("text/html");
//#endif


//#if 1360395467
            if(session == null) { //1
                throw new InvalidSessionException();
            }

//#endif


//#if 976417364
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

//#endif

            out.println(HTMLCode.open("Queries - Complaint information"));
            out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
            out.println("<p>Choose a complaint: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintSearch\">");
            IteratorDsk repTP = facade.getComplaintList();
            if(repTP==null||!repTP.hasNext()) { //1
                out.println("<p><center><font color=\"red\"><b> There isn't any complaints.</b></font></center></p>");
            } else {
                out.println("<div align=\"center\"><center><p><select name=\"numQueixa\" size=\"1\">");
                Complaint tp;
                do {
                    tp = (Complaint) repTP.next();
                    out.println("<option value=\""      +
                                tp.getCodigo() + "\"> " +
                                tp.getDescricao()      +
                                " </OPTION>");
                } while (repTP.hasNext()); //1

                repTP.close();
                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateComplaintSearch\" name=\"operation\"></p></center></div></form>");
            }

            out.println(HTMLCode.closeAdministrator());
        }

//#if -1921908354
        catch (ObjectNotFoundException e) { //1
            out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
        }

//#endif


//#if -1151093873
        catch(InvalidSessionException e) { //1
            out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
        }

//#endif


//#if -1089472842
        catch(IOException e) { //1
            out.println(HTMLCode.errorPageQueries(e.getMessage()));
        }

//#endif


//#if 462167184
        catch(Exception e) { //1
            out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
            e.printStackTrace(out);
        }

//#endif

        finally {
            out.close();
        }

    }

//#endif


//#if -1170983734
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }

            IteratorDsk repTP = facade.getComplaintList();
            out.println(HTMLCode.open("Queries - Complaint information"));
            out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
            out.println("<p>Choose a complaint: </p>");
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintSearch\">");
            if(repTP==null||!repTP.hasNext()) { //1
                out.println("<p><center><font color=\"red\"><b> There isn't any complaints.</b></font></center></p>");
            } else {
                out.println("<div align=\"center\"><center><p><select name=\"numQueixa\" size=\"1\">");
                Complaint tp;
                do {
                    tp = (Complaint) repTP.next();
                    out.println("<option value=\""      +
                                tp.getCodigo() + "\"> " +
                                tp.getDescricao()      +
                                " </OPTION>");
                } while (repTP.hasNext()); //1

                repTP.close();
                out.println("</select></p></center></div>");
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateComplaintSearch\" name=\"operation\"></p></center></div></form>");
            }

            out.println(HTMLCode.closeAdministrator());
        } catch (ObjectNotFoundException e) { //1
            out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
        }

        catch(InvalidSessionException e) { //1
            out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
        }

        catch(Exception e) { //1
            out.println(HTMLCode.errorPageQueries("There isn't any complaints"));
            e.printStackTrace(out);
        }


    }

//#endif

    public UpdateComplaintList(IFacade f)
    {
        super(f);
    }

}


//#endif

