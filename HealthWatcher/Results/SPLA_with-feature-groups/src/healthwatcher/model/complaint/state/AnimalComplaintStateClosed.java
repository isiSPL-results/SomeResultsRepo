
//#if -1443546319 
// Compilation Unit of /AnimalComplaintStateClosed.java 
 
package healthwatcher.model.complaint.state;

//#if -1542226420 
import healthwatcher.model.address.Address;
//#endif 


//#if -601656638 
import lib.util.Date;
//#endif 

public class AnimalComplaintStateClosed extends AnimalComplaintState
  { 
public AnimalComplaintStateClosed()
    { 
super();
} 

public void setTipoAnimal(String newAnimal)
    {
}
public void setQtdeAnimais(short newQtdeAnimais)
    {
}
public void setEnderecoLocalOcorrencia(Address newEnderecoLocalOcorrencia)
    {
}
public void setDataIncomodo(Date newDataIncomodo)
    {
}
public AnimalComplaintStateClosed(short qtdeAnimais, Date dataIncomodo,
                                      String animal, Address endereco)
    { 
super(qtdeAnimais, dataIncomodo, animal, endereco);
} 

public void setAnimal(String newAnimal)
    {
}
 } 


//#endif 

