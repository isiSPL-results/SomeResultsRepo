
//#if -1563714736
// Compilation Unit of /InsertAnimalComplaint.java

package healthwatcher.view.command;

//#if -1413403065
import healthwatcher.model.address.Address;
//#endif


//#if 1468479029
import healthwatcher.model.complaint.AnimalComplaint;
//#endif


//#if -2130957863
import healthwatcher.model.complaint.Complaint;
//#endif


//#if 372851680
import healthwatcher.view.IFacade;
//#endif


//#if -576895423
import java.io.IOException;
//#endif


//#if 43324810
import java.io.PrintWriter;
//#endif


//#if 938733739
import java.rmi.RemoteException;
//#endif


//#if -1423832598
import java.util.Calendar;
//#endif


//#if 296151092
import lib.exceptions.CommunicationException;
//#endif


//#if 865628259
import lib.exceptions.InvalidDateException;
//#endif


//#if 667973871
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1804901762
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -529097724
import lib.exceptions.RepositoryException;
//#endif


//#if 714839484
import lib.exceptions.TransactionException;
//#endif


//#if 1983578429
import lib.util.Date;
//#endif


//#if -1011280365
import lib.util.HTMLCode;
//#endif


//#if -820856140
import lib.exceptions.FacadeUnavailableException;
//#endif

public class InsertAnimalComplaint extends Command
{

//#if -655026779
    public void execute()
    {
        PrintWriter out = null;
        Complaint queixa;

//#if 115736953
        response.setContentType("text/html");
//#endif

        try { //1
            out = response.getWriter();
        }

//#if 581918785
        catch (IOException e1) { //1
            e1.printStackTrace();
        }

//#endif


        try { //2

//#if -1522058069
            String descricaoQueixa = request.getParameter("descricaoQueixa");
//#endif


//#if 1222965485
            String observacaoQueixa = request.getParameter("observacaoQueixa");
//#endif


//#if 2030134955
            String nomeSolicitante = request.getParameter("nomeSolicitante");
//#endif


//#if -1095815347
            String ruaSolicitante = request.getParameter("ruaSolicitante");
//#endif


//#if -413511401
            String compSolicitante = request.getParameter("compSolicitante");
//#endif


//#if 75795843
            String bairroSolicitante = request.getParameter("bairroSolicitante");
//#endif


//#if -322680703
            String cidadeSolicitante = request.getParameter("cidadeSolicitante");
//#endif


//#if -704840101
            String ufSolicitante = request.getParameter("ufSolicitante");
//#endif


//#if -2082336435
            String cepSolicitante = request.getParameter("cepSolicitante ");
//#endif


//#if -1792814067
            String telefoneSolicitante = request.getParameter("telefoneSolicitante");
//#endif


//#if -205513396
            String descricaoQueixa = request.getInput("descricaoQueixa");
//#endif


//#if 1787266668
            String observacaoQueixa = request.getInput("observacaoQueixa");
//#endif


//#if -1336096948
            String nomeSolicitante = request.getInput("nomeSolicitante");
//#endif


//#if 641601036
            String ruaSolicitante = request.getInput("ruaSolicitante");
//#endif


//#if 488676536
            String compSolicitante = request.getInput("compSolicitante");
//#endif


//#if 1429393380
            String bairroSolicitante = request.getInput("bairroSolicitante");
//#endif


//#if -493067678
            String cidadeSolicitante = request.getInput("cidadeSolicitante");
//#endif


//#if 1036635964
            String ufSolicitante = request.getInput("ufSolicitante");
//#endif


//#if -665024500
            String cepSolicitante = request.getInput("cepSolicitante ");
//#endif


//#if 1657310382
            String telefoneSolicitante = request.getInput("telefoneSolicitante");
//#endif

            Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante,
                                                 cepSolicitante,
                                                 ufSolicitante,
                                                 telefoneSolicitante,
                                                 cidadeSolicitante,
                                                 bairroSolicitante);

//#if -1704786547
            String emailSolicitante = request.getParameter("emailSolicitante");
//#endif


//#if -937368755
            String nomeAnimal = request.getParameter("nomeAnimal");
//#endif


//#if -2012465312
            short qtdeAnimal = Short.parseShort(request.getParameter("qtdeAnimal"));
//#endif


//#if 917501516
            int diaIncomodo = Integer.parseInt(request.getParameter("diaIncomodo"));
//#endif


//#if 78000108
            int mesIncomodo = Integer.parseInt(request.getParameter("mesIncomodo"));
//#endif


//#if -853935988
            int anoIncomodo = Integer.parseInt(request.getParameter("anoIncomodo"));
//#endif


//#if 2075043381
            String ruaOcorrencia = request.getParameter("ruaOcorrencia");
//#endif


//#if -63816531
            String compOcorrencia = request.getParameter("compOcorrencia");
//#endif


//#if 1408943405
            String bairroOcorrencia = request.getParameter("bairroOcorrencia");
//#endif


//#if -22957555
            String cidadeOcorrencia = request.getParameter("cidadeOcorrencia");
//#endif


//#if -1427953619
            String ufOcorrencia = request.getParameter("ufOcorrencia");
//#endif


//#if 586720917
            String cepOcorrencia = request.getParameter("cepOcorrencia ");
//#endif


//#if 778390989
            String telefoneOcorrencia = request.getParameter("telefoneOcorrencia");
//#endif


//#if -779021940
            String emailSolicitante = request.getInput("emailSolicitante");
//#endif


//#if 2026064268
            String nomeAnimal = request.getInput("nomeAnimal");
//#endif


//#if 195681153
            short qtdeAnimal = Short.parseShort(request.getInput("qtdeAnimal"));
//#endif


//#if 1843689035
            int diaIncomodo = Integer.parseInt(request.getInput("diaIncomodo"));
//#endif


//#if -1929758613
            int mesIncomodo = Integer.parseInt(request.getInput("mesIncomodo"));
//#endif


//#if 278361483
            int anoIncomodo = Integer.parseInt(request.getInput("anoIncomodo"));
//#endif


//#if -651307626
            String ruaOcorrencia = request.getInput("ruaOcorrencia");
//#endif


//#if -180032532
            String compOcorrencia = request.getInput("compOcorrencia");
//#endif


//#if 1405467564
            String bairroOcorrencia = request.getInput("bairroOcorrencia");
//#endif


//#if -349806580
            String cidadeOcorrencia = request.getInput("cidadeOcorrencia");
//#endif


//#if 1588390956
            String ufOcorrencia = request.getInput("ufOcorrencia");
//#endif


//#if 1667853814
            String cepOcorrencia = request.getInput("cepOcorrencia ");
//#endif


//#if 1974127372
            String telefoneOcorrencia = request.getInput("telefoneOcorrencia");
//#endif

            Address endOcorrencia = new Address(ruaOcorrencia,
                                                compOcorrencia,
                                                cepOcorrencia,
                                                ufOcorrencia,
                                                telefoneOcorrencia,
                                                cidadeOcorrencia,
                                                bairroOcorrencia);
            Calendar agora              = Calendar.getInstance();
            queixa = new AnimalComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa,
                                         emailSolicitante, null, 1, null,
                                         new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH),
                                                  agora.get(Calendar.YEAR)), endSolicitante, qtdeAnimal,
                                         new Date(diaIncomodo, mesIncomodo,anoIncomodo), nomeAnimal,endOcorrencia);
            int codigo = facade.insertComplaint(queixa);
            out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Animal Complaint inserted</h2> </p>" +
                                          "<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
        }

//#if 542225005
        catch(RemoteException e) { //1
            out.println(lib.util.HTMLCode.errorPage("Comunitation error, please try again later."));
        }

//#endif


//#if -975908367
        catch (RepositoryException e) { //1
            out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
        }

//#endif


//#if 472469651
        catch (TransactionException e) { //1
            out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
        }

//#endif


//#if -819185658
        catch (ObjectAlreadyInsertedException e) { //1
            out.println(HTMLCode.errorPage("Complaint already inserted"));
        }

//#endif


//#if 1798295279
        catch (ObjectNotValidException e) { //1
            out.println(HTMLCode.errorPage("Unespected error. Try to contact the support team."));
        }

//#endif


//#if -168414773
        catch (CommunicationException e) { //1
            out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
            e.printStackTrace(out);
        }

//#endif


//#if 1348108218
        catch(InvalidDateException e) { //1
            out.println(HTMLCode.errorPage("Invalid date."));
        }

//#endif

        finally {
            out.println(HTMLCode.close());
            out.close();
        }

    }

//#endif

    public InsertAnimalComplaint(IFacade f)
    {
        super(f);
    }


//#if -1583952835
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        Complaint queixa;
        try { //1
            String descricaoQueixa = request.getInput("descricaoQueixa");
            String observacaoQueixa = request.getInput("observacaoQueixa");
            String nomeSolicitante = request.getInput("nomeSolicitante");
            String ruaSolicitante = request.getInput("ruaSolicitante");
            String compSolicitante = request.getInput("compSolicitante");
            String bairroSolicitante = request.getInput("bairroSolicitante");
            String cidadeSolicitante = request.getInput("cidadeSolicitante");
            String ufSolicitante = request.getInput("ufSolicitante");
            String cepSolicitante = request.getInput("cepSolicitante ");
            String telefoneSolicitante = request.getInput("telefoneSolicitante");
            Address endSolicitante = new Address(ruaSolicitante,
                                                 compSolicitante,
                                                 cepSolicitante,
                                                 ufSolicitante,
                                                 telefoneSolicitante,
                                                 cidadeSolicitante,
                                                 bairroSolicitante);
            String emailSolicitante = request.getInput("emailSolicitante");
            String nomeAnimal = request.getInput("nomeAnimal");
            short qtdeAnimal = Short.parseShort(request.getInput("qtdeAnimal"));
            int diaIncomodo = Integer.parseInt(request.getInput("diaIncomodo"));
            int mesIncomodo = Integer.parseInt(request.getInput("mesIncomodo"));
            int anoIncomodo = Integer.parseInt(request.getInput("anoIncomodo"));
            String ruaOcorrencia = request.getInput("ruaOcorrencia");
            String compOcorrencia = request.getInput("compOcorrencia");
            String bairroOcorrencia = request.getInput("bairroOcorrencia");
            String cidadeOcorrencia = request.getInput("cidadeOcorrencia");
            String ufOcorrencia = request.getInput("ufOcorrencia");
            String cepOcorrencia = request.getInput("cepOcorrencia ");
            String telefoneOcorrencia = request.getInput("telefoneOcorrencia");
            Address endOcorrencia = new Address(ruaOcorrencia,
                                                compOcorrencia,
                                                cepOcorrencia,
                                                ufOcorrencia,
                                                telefoneOcorrencia,
                                                cidadeOcorrencia,
                                                bairroOcorrencia);
            Calendar agora              = Calendar.getInstance();
            queixa = new AnimalComplaint(nomeSolicitante, descricaoQueixa, observacaoQueixa,
                                         emailSolicitante, null, 1, null,
                                         new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH),
                                                  agora.get(Calendar.YEAR)), endSolicitante, qtdeAnimal,
                                         new Date(diaIncomodo, mesIncomodo,anoIncomodo), nomeAnimal,endOcorrencia);
            int codigo = facade.insertComplaint(queixa);
            out.println(HTMLCode.htmlPage("Complaint inserted",
                                          "<p> <h2> Animal Complaint inserted</h2> </p>" +
                                          "<p> <h2> Save the complaint number: " + codigo + "</h2> </p>"));
            out.println(HTMLCode.close());
        } catch (RepositoryException e) { //1
            out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
        }

        catch (TransactionException e) { //1
            out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
        }

        catch (ObjectAlreadyInsertedException e) { //1
            out.println(HTMLCode.errorPage("Complaint already inserted"));
        }

        catch (ObjectNotValidException e) { //1
            out.println(HTMLCode.errorPage("Unespected error. Try to contact the support team."));
        }

        catch (CommunicationException e) { //1
            throw new FacadeUnavailableException();
        }

        catch(InvalidDateException e) { //1
            out.println(HTMLCode.errorPage("Invalid date."));
        }


    }

//#endif

}


//#endif

