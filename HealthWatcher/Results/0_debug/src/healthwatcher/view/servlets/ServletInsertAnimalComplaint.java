
//#if 1743544417
// Compilation Unit of /ServletInsertAnimalComplaint.java


//#if 1077764814
package healthwatcher.view.servlets;
//#endif


//#if -124621469
import healthwatcher.model.address.Address;
//#endif


//#if 605635153
import healthwatcher.model.complaint.AnimalComplaint;
//#endif


//#if 1990228725
import healthwatcher.model.complaint.Complaint;
//#endif


//#if -962052771
import java.io.IOException;
//#endif


//#if -341832538
import java.io.PrintWriter;
//#endif


//#if 301140751
import java.rmi.RemoteException;
//#endif


//#if 1334689614
import java.util.Calendar;
//#endif


//#if 42332129
import javax.servlet.ServletException;
//#endif


//#if -1360444237
import javax.servlet.http.HttpServletRequest;
//#endif


//#if -1878117421
import javax.servlet.http.HttpServletResponse;
//#endif


//#if 1864683600
import lib.exceptions.CommunicationException;
//#endif


//#if -2140557441
import lib.exceptions.InvalidDateException;
//#endif


//#if -194870005
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -1110198042
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -348976792
import lib.exceptions.RepositoryException;
//#endif


//#if 2003621080
import lib.exceptions.TransactionException;
//#endif


//#if -467370663
import lib.util.Date;
//#endif


//#if -368106449
import lib.util.HTMLCode;
//#endif


//#if -320133450
public class ServletInsertAnimalComplaint extends
//#if 508079924
    HWServlet
//#endif

{

//#if 1060600875
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

//#if -1600107783
        PrintWriter out;
//#endif


//#if -1218065581
        Complaint queixa;
//#endif


//#if -1444882261
        response.setContentType("text/html");
//#endif


//#if 110175355
        out = response.getWriter();
//#endif


//#if -960900534
        try { //1

//#if -389808056
            String descricaoQueixa = request.getParameter("descricaoQueixa");
//#endif


//#if -1606465206
            String observacaoQueixa = request.getParameter("observacaoQueixa");
//#endif


//#if -1132582328
            String nomeSolicitante = request.getParameter("nomeSolicitante");
//#endif


//#if 2127705642
            String ruaSolicitante = request.getParameter("ruaSolicitante");
//#endif


//#if 718738612
            String compSolicitante = request.getParameter("compSolicitante");
//#endif


//#if -292799840
            String bairroSolicitante = request.getParameter("bairroSolicitante");
//#endif


//#if -691276386
            String cidadeSolicitante = request.getParameter("cidadeSolicitante");
//#endif


//#if -1845618568
            String ufSolicitante = request.getParameter("ufSolicitante");
//#endif


//#if 1141184554
            String cepSolicitante = request.getParameter("cepSolicitante ");
//#endif


//#if -1423594838
            String telefoneSolicitante = request.getParameter("telefoneSolicitante");
//#endif


//#if -295387335
            Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante,
                                                 cepSolicitante,
                                                 ufSolicitante,
                                                 telefoneSolicitante,
                                                 cidadeSolicitante,
                                                 bairroSolicitante);
//#endif


//#if -239249942
            String emailSolicitante = request.getParameter("emailSolicitante");
//#endif


//#if -116189398
            String nomeAnimal = request.getParameter("nomeAnimal");
//#endif


//#if -615081693
            short qtdeAnimal = Short.parseShort(request.getParameter("qtdeAnimal"));
//#endif


//#if -1980082161
            int diaIncomodo = Integer.parseInt(request.getParameter("diaIncomodo"));
//#endif


//#if 1475383727
            int mesIncomodo = Integer.parseInt(request.getParameter("mesIncomodo"));
//#endif


//#if 543447631
            int anoIncomodo = Integer.parseInt(request.getParameter("anoIncomodo"));
//#endif


//#if 934264914
            String ruaOcorrencia = request.getParameter("ruaOcorrencia");
//#endif


//#if -1135262838
            String compOcorrencia = request.getParameter("compOcorrencia");
//#endif


//#if -1420487286
            String bairroOcorrencia = request.getParameter("bairroOcorrencia");
//#endif


//#if 1442579050
            String cidadeOcorrencia = request.getParameter("cidadeOcorrencia");
//#endif


//#if -307354230
            String ufOcorrencia = request.getParameter("ufOcorrencia");
//#endif


//#if -554057550
            String cepOcorrencia = request.getParameter("cepOcorrencia ");
//#endif


//#if -1254742102
            String telefoneOcorrencia = request.getParameter("telefoneOcorrencia");
//#endif


//#if 1858546117
            Address endOcorrencia = new Address(ruaOcorrencia,
                                                compOcorrencia,
                                                cepOcorrencia,
                                                ufOcorrencia,
                                                telefoneOcorrencia,
                                                cidadeOcorrencia,
                                                bairroOcorrencia);
//#endif


//#if 347258478
            Calendar agora              = Calendar.getInstance();
//#endif


//#if 2068677474
            queixa = new AnimalComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa,
                                         emailSolicitante, null, 1, null,
                                         new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH),
                                                  agora.get(Calendar.YEAR)), endSolicitante, qtdeAnimal,
                                         new Date(diaIncomodo, mesIncomodo,anoIncomodo), nomeAnimal,endOcorrencia);
//#endif


//#if 1974009418
            int codigo = facade.insertComplaint(queixa);
//#endif


//#if 1138431798
            out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Animal Complaint inserted</h2> </p>" +
                                          "<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
//#endif

        }

//#if 397248692
        catch(RemoteException e) { //1

//#if 792600530
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif

        }

//#endif


//#if 1665019064
        catch (RepositoryException e) { //1

//#if -2087373138
            out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
//#endif

        }

//#endif


//#if 736841388
        catch (TransactionException e) { //1

//#if -1285805692
            out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
//#endif

        }

//#endif


//#if 1432234719
        catch (ObjectAlreadyInsertedException e) { //1

//#if 1774668838
            out.println(HTMLCode.errorPage("Complaint already inserted"));
//#endif

        }

//#endif


//#if 726691382
        catch (ObjectNotValidException e) { //1

//#if -1310877047
            out.println(HTMLCode.errorPage("Unespected error. Try to contact the support team."));
//#endif

        }

//#endif


//#if 489754020
        catch (CommunicationException e) { //1

//#if 1793943216
            out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
//#endif


//#if -1504261364
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 1612479955
        catch(InvalidDateException e) { //1

//#if 1155572819
            out.println(HTMLCode.errorPage("Invalid date."));
//#endif

        }

//#endif

        finally {

//#if 724450940
            out.println(HTMLCode.close());
//#endif


//#if 907937232
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

