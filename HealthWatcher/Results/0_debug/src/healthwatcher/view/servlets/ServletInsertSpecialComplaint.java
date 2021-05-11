
//#if -1371082557
// Compilation Unit of /ServletInsertSpecialComplaint.java


//#if 718302434
package healthwatcher.view.servlets;
//#endif


//#if 2079827151
import healthwatcher.model.address.Address;
//#endif


//#if -863757215
import healthwatcher.model.complaint.Complaint;
//#endif


//#if -1421292040
import healthwatcher.model.complaint.SpecialComplaint;
//#endif


//#if -245248823
import java.io.IOException;
//#endif


//#if 374971410
import java.io.PrintWriter;
//#endif


//#if 1881554723
import java.rmi.RemoteException;
//#endif


//#if 1357812322
import java.util.Calendar;
//#endif


//#if -1803631371
import javax.servlet.ServletException;
//#endif


//#if -304197345
import javax.servlet.http.HttpServletRequest;
//#endif


//#if 800765159
import javax.servlet.http.HttpServletResponse;
//#endif


//#if -1374036804
import lib.exceptions.CommunicationException;
//#endif


//#if 812279159
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1568684538
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 2077439100
import lib.exceptions.RepositoryException;
//#endif


//#if -86897596
import lib.exceptions.TransactionException;
//#endif


//#if -1083634235
import lib.util.Date;
//#endif


//#if 1987944091
import lib.util.HTMLCode;
//#endif


//#if 133478039
public class ServletInsertSpecialComplaint extends
//#if -282150780
    HWServlet
//#endif

{

//#if 573687163
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if 252422316
        PrintWriter out = response.getWriter();
//#endif


//#if 187249890
        response.setContentType("text/html");
//#endif


//#if -288759565
        try { //1

//#if -406785464
            String   descricaoQueixa     = request.getParameter("descricaoQueixa");
//#endif


//#if -741885110
            String   observacaoQueixa    = request.getParameter("observacaoQueixa");
//#endif


//#if -1149559736
            String   nomeSolicitante     = request.getParameter("nomeSolicitante");
//#endif


//#if -1671190486
            String   ruaSolicitante      = request.getParameter("ruaSolicitante");
//#endif


//#if 701761204
            String   compSolicitante     = request.getParameter("compSolicitante");
//#endif


//#if 1639984288
            String   bairroSolicitante   = request.getParameter("bairroSolicitante");
//#endif


//#if 1241507742
            String   cidadeSolicitante   = request.getParameter("cidadeSolicitante");
//#endif


//#if 1766066808
            String   ufSolicitante       = request.getParameter("ufSolicitante");
//#endif


//#if 1637255722
            String   cepSolicitante      = request.getParameter("cepSolicitante ");
//#endif


//#if -1626301270
            String   telefoneSolicitante = request.getParameter("telefoneSolicitante");
//#endif


//#if 832287033
            Address endSolicitante = new Address(ruaSolicitante, compSolicitante, cepSolicitante, ufSolicitante,
                                                 telefoneSolicitante, cidadeSolicitante, bairroSolicitante);
//#endif


//#if 625330154
            String   emailSolicitante    = request.getParameter("emailSolicitante");
//#endif


//#if -2105488245
            short    idade              = Short.parseShort(request.getParameter("idade"));
//#endif


//#if 1278510828
            String   instrucao          = request.getParameter("instrucao");
//#endif


//#if -299782934
            String   ocupacao           = request.getParameter("ocupacao");
//#endif


//#if 250982994
            String   ruaOcorrencia      = request.getParameter("ruaOcorrencia");
//#endif


//#if -639191670
            String   compOcorrencia     = request.getParameter("compOcorrencia");
//#endif


//#if -555907190
            String   bairroOcorrencia   = request.getParameter("bairroOcorrencia");
//#endif


//#if -1987808150
            String   cidadeOcorrencia   = request.getParameter("cidadeOcorrencia");
//#endif


//#if 1640535946
            String   ufOcorrencia       = request.getParameter("ufOcorrencia");
//#endif


//#if -1237339470
            String   cepOcorrencia      = request.getParameter("cepOcorrencia ");
//#endif


//#if 724933034
            String   telefoneOcorrencia = request.getParameter("telefoneOcorrencia");
//#endif


//#if -921691195
            Address endOcorrencia      = new Address(ruaOcorrencia, compOcorrencia, cepOcorrencia, ufOcorrencia,
                    telefoneOcorrencia, cidadeOcorrencia, bairroOcorrencia);
//#endif


//#if -581333906
            Calendar agora              = Calendar.getInstance();
//#endif


//#if -750260537
            Complaint queixa = new SpecialComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa, emailSolicitante,
                                                    null, 1, null, new Date(agora.get(Calendar.DAY_OF_MONTH),
                                                            agora.get(Calendar.MONTH),
                                                            agora.get(Calendar.YEAR)),
                                                    endSolicitante, idade, instrucao, ocupacao, endOcorrencia);
//#endif


//#if -768029622
            int codigo = facade.insertComplaint(queixa);
//#endif


//#if 379121055
            out.println(HTMLCode.htmlPage("Complaint inserted", "<p> <h2> Special Complaint inserted</h2> </p>" +"<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
//#endif

        }

//#if 448744367
        catch(RemoteException e) { //1

//#if 414581079
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 833625229
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 829422131
        catch (RepositoryException e) { //1

//#if -788457516
            out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif


//#if 1106226650
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 603140241
        catch (TransactionException e) { //1

//#if 758975051
            out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
//#endif


//#if -630283987
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 1649717892
        catch (ObjectAlreadyInsertedException e) { //1

//#if 1827059659
            out.println(HTMLCode.errorPage("Esta queixa jah existe no BD"));
//#endif


//#if 279009929
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -929495503
        catch (ObjectNotValidException e) { //1

//#if 1146128291
            out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif


//#if -477304449
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 851970633
        catch (CommunicationException e) { //1

//#if -1417321432
            out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif


//#if -1506007932
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -740422135
        catch(Exception e) { //1

//#if 445773133
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif


//#if 531092867
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -618956848
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

