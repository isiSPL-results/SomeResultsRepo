
//#if -421330304
// Compilation Unit of /ServletUpdateComplaintSearch.java

package healthwatcher.view.servlets;
import healthwatcher.Constants;
import healthwatcher.model.complaint.AnimalComplaint;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.FoodComplaint;
import healthwatcher.model.complaint.Situation;
import healthwatcher.model.complaint.SpecialComplaint;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.exceptions.CommunicationException;
import lib.exceptions.InvalidSessionException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.exceptions.SituationFacadeException;
import lib.exceptions.TransactionException;
import lib.util.HTMLCode;
import lib.util.IteratorDsk;
public class ServletUpdateComplaintSearch extends HWServlet
{
    public static final String QUEIXA = "queixa";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");
        try { //1
            if(session == null) { //1
                throw new InvalidSessionException();
            }

            out.println(HTMLCode.open("Queries - Complaint information"));
            out.println("<body><h1>Queries:<br>Querie about complaint</h1>");
            out.println("<p>Choose a complaint: </p>");
            out.println("<form method=\"POST\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletUpdateComplaintSearch\">");
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
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"Search\" name=\"B1\"></p></center></div></form>");
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

        finally {
            out.close();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");
        try { //1
            if(session == null) { //1
                throw new InvalidSessionException();
            }

            int numQueixa = (new Integer(request.getParameter("numQueixa"))).intValue();
            Complaint q = facade.searchComplaint(numQueixa);
            session.putValue(ServletUpdateComplaintSearch.QUEIXA, q);
            if(q.getSituacao() != Situation.QUEIXA_ABERTA) { //1
                throw new SituationFacadeException("Complaint not open");
            }

            out.println(HTMLCode.open("Update complaint"));
            out.println("<script language=\"javascript\">");
            out.println("function submeterDados(modulo)");
            out.println("{");
            String a1 = "\"";
            String a2 = "\"";
            out.println("   var f = document.formAlterarQueixa2;");
            out.println("   if(f.obsQueixa.value ==" + a1 + a2 + ")");
            out.println("   {");
            out.println("           alert(\"Digite o parecer da queixa!\");");
            out.println("           f.obsQueixa.select();");
            out.println("           return;");
            out.println("   }");
            out.println("   f.submit();");
            out.println("}");
            out.println("//--></script>");
            out.println("<body><h1>Update Complaint:</h1>");
            out.println("<form method=\"POST\" name=\"formAlterarQueixa2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"ServletUpdateComplaintData\">");
            out.println("<div align=\"center\"><center><h4>Complaint : " + numQueixa+ "</h4></center></div>");
            String t = null;
            if(q instanceof SpecialComplaint) { //1
                t = "Special complaint";
            } else if(q instanceof FoodComplaint) { //1
                t = "Food complaint";
            } else if(q instanceof AnimalComplaint) { //1
                t = "Animal complaint";
            }



            out.println("<div align=\"center\"><center><p><strong>Complaint kind: "+t+"</strong></p></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Description: "+ q.getDescricao() + "</strong></p></center></div>");
            out.println("<div align=\"center\"><center><p><strong>Observation (complaint's solution):</strong><br><textarea rows=\"5\" name=\"obsQueixa\" cols=\"22\"></textarea></p></center></div>");
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
            out.println(HTMLCode.closeAdministrator());
        } catch(RemoteException e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
        }

        catch (InvalidSessionException e) { //1
            out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
        }

        catch (RepositoryException e) { //1
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
            e.printStackTrace();
        }

        catch (ObjectNotFoundException e) { //1
            out.println(HTMLCode.errorPageAdministrator("Complaint does not exist!"));
        }

        catch (CommunicationException e) { //1
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
            e.printStackTrace();
        }

        catch (TransactionException e) { //1
            out.println(lib.util.HTMLCode.errorPage(e.getMessage()));
            e.printStackTrace();
        }

        catch (SituationFacadeException e) { //1
            out.println(HTMLCode.errorPageAdministrator("This complaint's status is closed!"));
        }

        finally {
            out.close();
        }

    }

}


//#endif

