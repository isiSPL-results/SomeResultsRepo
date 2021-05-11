package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
public abstract class Complaint implements java.io.Serializable
{
    public static final int QUEIXA_ALIMENTAR = 1;
    public static final int QUEIXA_ANIMAL = 2;
    public static final int QUEIXA_DIVERSA = 3;
    private int codigo;
    private String solicitante;
    private String descricao;
    private String observacao;
    private String email;
    private Employee atendente;
    private int situacao;
    private Date dataParecer;
    private Date dataQueixa;
    private Address enderecoSolicitante;
    private long timestamp;
    public int getCodigo()
    {
        return codigo;
    }
    public void setDataQueixa(Date dataQueixa)
    {
        this.dataQueixa = dataQueixa;
    }
    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }
    public void setSolicitante(String solicitante)
    {
        this.solicitante = solicitante;
    }
    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }
    public String getEmail()
    {
        return email;
    }
    public Complaint(String solicitante, String descricao, String observacao, String email,
                     Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                     Address enderecoSolicitante, long timestamp)
    {
        this.codigo = 0;
        this.solicitante = solicitante;
        this.descricao = descricao;
        this.observacao = observacao;
        this.email = email;
        this.atendente = atendente;
        this.situacao = situacao;
        this.dataParecer = dataParecer;
        this.dataQueixa = dataQueixa;
        this.enderecoSolicitante = enderecoSolicitante;
        this.timestamp = timestamp;
    }
    public int getSituacao()
    {
        return situacao;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public Address getEnderecoSolicitante()
    {
        return enderecoSolicitante;
    }
    public String getObservacao()
    {
        return observacao;
    }
    public Employee getAtendente()
    {
        return atendente;
    }
    public void incTimestamp()
    {
        this.timestamp = timestamp + 1;
    }
    public void setEnderecoSolicitante(Address enderecoSolicitante)
    {
        this.enderecoSolicitante = enderecoSolicitante;
    }
    public Date getDataParecer()
    {
        return dataParecer;
    }
    public String getSolicitante()
    {
        return solicitante;
    }
    public void setAtendente(Employee atendente)
    {
        this.atendente = atendente;
    }
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public long getTimestamp()
    {
        return timestamp;
    }
    public void setDataParecer(Date dataParecer)
    {
        this.dataParecer = dataParecer;
    }
    public void setSituacao(int situacao)
    {
        this.situacao = situacao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public Date getDataQueixa()
    {
        return dataQueixa;
    }
    public Complaint()
    {
    }

}
