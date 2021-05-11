package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
public class FoodComplaint extends Complaint
{
    private int qtdeComensais;
    private int qtdeDoentes;
    private int qtdeInternacoes;
    private int qtdeObitos;
    private String localAtendimento;
    private String refeicaoSuspeita;
    private Address enderecoDoente;
    public FoodComplaint(String solicitante, String descricao, String observacao, String email,
                         Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                         Address enderecoSolicitante, int qtdeComensais, int qtdeDoentes, int qtdeInternacoes,
                         int qtdeObitos, String localAtendimento, String refeicaoSuspeita, Address enderecoDoente)
    {
        super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);
        this.qtdeComensais = qtdeComensais;
        this.qtdeDoentes = qtdeDoentes;
        this.qtdeInternacoes = qtdeInternacoes;
        this.qtdeObitos = qtdeObitos;
        this.localAtendimento = localAtendimento;
        this.refeicaoSuspeita = refeicaoSuspeita;
        this.enderecoDoente = enderecoDoente;
    }
    public String getLocalAtendimento()
    {
        return localAtendimento;
    }
    public void setEnderecoDoente(Address enderecoDoente)
    {
        this.enderecoDoente = enderecoDoente;
    }
    public String getRefeicaoSuspeita()
    {
        return refeicaoSuspeita;
    }
    public void setQtdeObitos(int qtdeObitos)
    {
        this.qtdeObitos = qtdeObitos;
    }
    public void setLocalAtendimento(String localAtendimento)
    {
        this.localAtendimento = localAtendimento;
    }
    public int getQtdeObitos()
    {
        return qtdeObitos;
    }
    public void setQtdeInternacoes(int qtdeInternacoes)
    {
        this.qtdeInternacoes = qtdeInternacoes;
    }
    public int getQtdeDoentes()
    {
        return qtdeDoentes;
    }
    public int getQtdeInternacoes()
    {
        return qtdeInternacoes;
    }
    public void setQtdeDoentes(int qtdeDoentes)
    {
        this.qtdeDoentes = qtdeDoentes;
    }
    public FoodComplaint()
    {
    }
    public Address getEnderecoDoente()
    {
        return enderecoDoente;
    }
    public void setQtdeComensais(int qtdeComensais)
    {
        this.qtdeComensais = qtdeComensais;
    }
    public int getQtdeComensais()
    {
        return qtdeComensais;
    }
    public void setRefeicaoSuspeita(String refeicaoSuspeita)
    {
        this.refeicaoSuspeita = refeicaoSuspeita;
    }

}
