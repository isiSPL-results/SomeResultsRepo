package healthwatcher.view.command;
import healthwatcher.model.address.Address;
import healthwatcher.model.complaint.AnimalComplaint;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.view.IFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import lib.exceptions.CommunicationException;
import lib.exceptions.InvalidDateException;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.util.Date;
import lib.util.HTMLCode;
public class InsertAnimalComplaint extends Command
{
    public void execute()
    {
        PrintWriter out = null;
        Complaint queixa;
        try { //1
            out = response.getWriter();
        } catch (IOException e1) { //1
            e1.printStackTrace();
        }
        try { //2
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
        } catch (RepositoryException e) { //1
            out.println(HTMLCode.errorPage("Problemas com o banco de dados"));
        } catch (TransactionException e) { //1
            out.println(HTMLCode.errorPage("Erro no mecanismo de persist?ncia"));
        } catch (ObjectAlreadyInsertedException e) { //1
            out.println(HTMLCode.errorPage("Complaint already inserted"));
        } catch (ObjectNotValidException e) { //1
            out.println(HTMLCode.errorPage("Unespected error. Try to contact the support team."));
        } catch (CommunicationException e) { //1
            out.println(HTMLCode.errorPage("Erro ao inserir esta queixa"));
            e.printStackTrace(out);
        } catch(InvalidDateException e) { //1
            out.println(HTMLCode.errorPage("Invalid date."));
        } finally {
            out.println(HTMLCode.close());
            out.close();
        }
    }
    public InsertAnimalComplaint(IFacade f)
    {
        super(f);
    }

}
