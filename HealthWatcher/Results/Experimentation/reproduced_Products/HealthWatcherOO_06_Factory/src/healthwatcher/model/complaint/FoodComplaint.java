package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
import healthwatcher.model.complaint.state.FoodComplaintState;
import healthwatcher.model.complaint.state.FoodComplaintStateClosed;
import healthwatcher.model.complaint.state.FoodComplaintStateOpen;
public class FoodComplaint extends Complaint
{
    private FoodComplaintState state;
    public FoodComplaint(String solicitante, String descricao, String observacao, String email,
                         Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                         Address enderecoSolicitante, int qtdeComensais, int qtdeDoentes, int qtdeInternacoes,
                         int qtdeObitos, String localAtendimento, String refeicaoSuspeita, Address enderecoDoente)
    {
        super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);
        if(situacao==Situation.QUEIXA_ABERTA)//1
            state= new FoodComplaintStateOpen(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                              refeicaoSuspeita,enderecoDoente);
        else if(situacao==Situation.QUEIXA_FECHADA) //1
            state= new FoodComplaintStateClosed(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                                refeicaoSuspeita,enderecoDoente);
    }
    public String getLocalAtendimento()
    {
        return state.getLocalAtendimento();
    }
    public void setEnderecoDoente(Address enderecoDoente)
    {
        state.setEnderecoDoente(enderecoDoente);
    }
    public String getRefeicaoSuspeita()
    {
        return state.getRefeicaoSuspeita();
    }
    public void setQtdeObitos(int qtdeObitos)
    {
        state.setQtdeObitos(qtdeObitos);
    }
    public void setLocalAtendimento(String localAtendimento)
    {
        state.setLocalAtendimento(localAtendimento);
    }
    public void setSituacao(int situacao)
    {
        super.setSituacao(situacao);
        state.setStatus(situacao, this);
    }
    public int getQtdeObitos()
    {
        return state.getQtdeObitos();
    }
    public void setComplaintState(FoodComplaintState _state)
    {
        state= _state;
    }
    public void setQtdeInternacoes(int qtdeInternacoes)
    {
        state.setQtdeInternacoes(qtdeInternacoes);
    }
    public int getQtdeDoentes()
    {
        return state.getQtdeDoentes();
    }
    public int getQtdeInternacoes()
    {
        return state.getQtdeInternacoes();
    }
    public void setQtdeDoentes(int qtdeDoentes)
    {
        state.setQtdeDoentes(qtdeDoentes);
    }
    public FoodComplaint()
    {
        state= new FoodComplaintStateOpen();
    }
    public Address getEnderecoDoente()
    {
        return state.getEnderecoDoente();
    }
    public void setQtdeComensais(int qtdeComensais)
    {
        state.setQtdeComensais(qtdeComensais);
    }
    public int getQtdeComensais()
    {
        return state.getQtdeComensais();
    }
    public void setRefeicaoSuspeita(String refeicaoSuspeita)
    {
        state.setRefeicaoSuspeita(refeicaoSuspeita);
    }

}
