package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
import lib.util.Date;
public class AnimalComplaintStateOpen extends AnimalComplaintState
{
    public AnimalComplaintStateOpen(short qtdeAnimais, Date dataIncomodo,
                                    String animal, Address endereco)
    {
        super(qtdeAnimais, dataIncomodo, animal, endereco);
    }
    public void setEnderecoLocalOcorrencia(Address newEnderecoLocalOcorrencia)
    {
        enderecoLocalOcorrencia = newEnderecoLocalOcorrencia;
    }
    public AnimalComplaintStateOpen()
    {
        super();
    }
    public void setDataIncomodo(Date newDataIncomodo)
    {
        dataIncomodo = newDataIncomodo;
    }
    public void setAnimal(String newAnimal)
    {
        animal = newAnimal;
    }
    public void setTipoAnimal(String newAnimal)
    {
        animal = newAnimal;
    }
    public void setQtdeAnimais(short newQtdeAnimais)
    {
        qtdeAnimais = newQtdeAnimais;
    }

}
