
//#if 1988033650
// Compilation Unit of /AnimalComplaintStateOpen.java

package healthwatcher.model.complaint.state;

//#if -264140446
import healthwatcher.model.address.Address;
//#endif


//#if -445078888
import lib.util.Date;
//#endif

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


//#endif

