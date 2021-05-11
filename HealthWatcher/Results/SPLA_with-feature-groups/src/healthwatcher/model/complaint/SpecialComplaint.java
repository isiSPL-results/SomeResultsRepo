// Compilation Unit of /SpecialComplaint.java

package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;

//#if -580606480
import healthwatcher.model.complaint.state.SpecialComplaintState;
//#endif


//#if -1539592668
import healthwatcher.model.complaint.state.SpecialComplaintStateClosed;
//#endif


//#if -1358006714
import healthwatcher.model.complaint.state.SpecialComplaintStateOpen;
//#endif

public class SpecialComplaint extends Complaint
{

//#if 546875709
    private short idade;
//#endif


//#if 430597591
    private String instrucao;
//#endif


//#if -1479314664
    private String ocupacao;
//#endif


//#if 361644442
    private Address enderecoOcorrencia;
//#endif


//#if -2142036362
    private SpecialComplaintState state;
//#endif


//#if 878269509
    public void setComplaintState(SpecialComplaintState _state)
    {
        state= _state;
    }

//#endif


//#if 673429279
    public void setSituacao(int situacao)
    {
        super.setSituacao(situacao);
        state.setStatus(situacao, this);
    }

//#endif

    public void setOcupacao(String ocupacao)
    {

//#if 1908165547
        this.ocupacao = ocupacao;
//#endif


//#if -247154184
        state.setOcupacao(ocupacao);
//#endif

    }

    public short getIdade()
    {

//#if -2142322037
        return idade;
//#endif


//#if 363534453
        return state.getIdade();
//#endif

    }

    public SpecialComplaint(String solicitante, String descricao, String observacao, String email,
                            Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                            Address enderecoSolicitante, short idade, String instrucao, String ocupacao,
                            Address enderecoOcorrencia)
    {
        super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);

//#if -59939211
        this.idade = idade;
//#endif


//#if -1251290893
        this.instrucao = instrucao;
//#endif


//#if 1037837705
        this.ocupacao = ocupacao;
//#endif


//#if -1159694039
        this.enderecoOcorrencia = enderecoOcorrencia;
//#endif


//#if -56229132
        if(situacao==Situation.QUEIXA_ABERTA) { //1
            state= new SpecialComplaintStateOpen(idade,instrucao, ocupacao,enderecoOcorrencia);
        } else

//#if 1509110001
            if(situacao==Situation.QUEIXA_FECHADA) { //1
                state= new SpecialComplaintStateClosed(idade,instrucao, ocupacao,enderecoOcorrencia);
            }

//#endif


//#endif

    }

    public void setInstrucao(String instrucao)
    {

//#if 1540324430
        this.instrucao = instrucao;
//#endif


//#if 466867327
        state.setInstrucao(instrucao);
//#endif

    }

    public String getOcupacao()
    {

//#if -856999320
        return ocupacao;
//#endif


//#if 115905398
        return state.getOcupacao();
//#endif

    }

    public void setEnderecoOcorrencia(Address enderecoOcorrencia)
    {

//#if -844935257
        this.enderecoOcorrencia = enderecoOcorrencia;
//#endif


//#if -1630431684
        state.setEnderecoOcorrencia(enderecoOcorrencia);
//#endif

    }

    public void setIdade(short idade)
    {

//#if -1411095381
        this.idade = idade;
//#endif


//#if 1934002882
        state.setIdade(idade);
//#endif

    }

    public String getInstrucao()
    {

//#if 1840938524
        return instrucao;
//#endif


//#if -1242137438
        return state.getInstrucao();
//#endif

    }

    public Address getEnderecoOcorrencia()
    {

//#if -1829172929
        return enderecoOcorrencia;
//#endif


//#if -1098785763
        return state.getEnderecoOcorrencia();
//#endif

    }

    public SpecialComplaint()
    {

//#if 1595175462
        super();
//#endif


//#if 135994302
        state= new SpecialComplaintStateOpen();
//#endif

    }

}


