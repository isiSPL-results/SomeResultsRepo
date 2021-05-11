package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
import lib.util.Date;
public class AnimalComplaintStateClosed extends AnimalComplaintState
{
    public AnimalComplaintStateClosed()
    {
        super();
    }
    public void setTipoAnimal(String newAnimal)
    {
    } public void setQtdeAnimais(short newQtdeAnimais)
    {
    } public void setEnderecoLocalOcorrencia(Address newEnderecoLocalOcorrencia)
    {
    } public void setDataIncomodo(Date newDataIncomodo)
    {
    } public AnimalComplaintStateClosed(short qtdeAnimais, Date dataIncomodo,
                                        String animal, Address endereco)
    {
        super(qtdeAnimais, dataIncomodo, animal, endereco);
    }
    public void setAnimal(String newAnimal)
    {
    }
}
