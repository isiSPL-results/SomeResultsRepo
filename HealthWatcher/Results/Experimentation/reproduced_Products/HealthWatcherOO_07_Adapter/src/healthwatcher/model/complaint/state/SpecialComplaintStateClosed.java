package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
public class SpecialComplaintStateClosed extends SpecialComplaintState
{
    public void setInstrucao(java.lang.String newInstrucao)
    {
    } public void setOcupacao(java.lang.String newOcupacao)
    {
    } public void setIdade(short newIdade)
    {
    } public SpecialComplaintStateClosed()
    {
        super();
    }
    public void setEnderecoOcorrencia(Address newEnderecoOcorrencia)
    {
    } public SpecialComplaintStateClosed(short idade, String instrucao,
                                         String ocupacao, Address enderecoOcorrencia)
    {
        super(idade, instrucao, ocupacao, enderecoOcorrencia);
    }

}
