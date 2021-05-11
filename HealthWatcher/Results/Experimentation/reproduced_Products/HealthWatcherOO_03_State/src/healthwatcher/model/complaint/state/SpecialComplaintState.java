package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
import healthwatcher.model.complaint.Situation;
import healthwatcher.model.complaint.SpecialComplaint;
import java.io.Serializable;
public abstract class SpecialComplaintState implements Serializable
{
    protected short    idade;
    protected String   instrucao;
    protected String   ocupacao;
    protected Address enderecoOcorrencia;
    public short getIdade()
    {
        return this.idade;
    }
    public abstract void setEnderecoOcorrencia(Address newEnderecoOcorrencia);
    public SpecialComplaintState(short idade,
                                 String instrucao, String ocupacao,
                                 Address enderecoOcorrencia)
    {
        this.idade              = idade;
        this.instrucao          = instrucao;
        this.ocupacao           = ocupacao;
        this.enderecoOcorrencia = enderecoOcorrencia;
    }
    public abstract void setOcupacao(java.lang.String newOcupacao);
    public void setStatus(int sit,SpecialComplaint complaint)
    {
        if(sit!=complaint.getSituacao()) { //1
            if(sit==Situation.QUEIXA_ABERTA) { //1
                complaint.setComplaintState(new SpecialComplaintStateOpen(idade, instrucao, ocupacao, enderecoOcorrencia));
            } else if(sit==Situation.QUEIXA_FECHADA) { //1
                complaint.setComplaintState(new SpecialComplaintStateClosed(idade, instrucao, ocupacao, enderecoOcorrencia));
            } else if(sit==Situation.QUEIXA_SUSPENSA) { //1
            }
        }
    }
    public abstract void setInstrucao(java.lang.String newInstrucao);
    public Address getEnderecoOcorrencia()
    {
        return this.enderecoOcorrencia;
    }
    public abstract void setIdade(short newIdade);
    public String getInstrucao()
    {
        return this.instrucao;
    }
    public SpecialComplaintState()
    {
    } public String getOcupacao()
    {
        return this.ocupacao;
    }

}
