package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
import healthwatcher.model.complaint.state.AnimalComplaintState;
import healthwatcher.model.complaint.state.AnimalComplaintStateClosed;
import healthwatcher.model.complaint.state.AnimalComplaintStateOpen;
public class AnimalComplaint extends Complaint
  { 
private AnimalComplaintState state;
public void setComplaintState(AnimalComplaintState _state)
    { 
state= _state;
} 
public AnimalComplaint()
    { 
super();
state= new AnimalComplaintStateOpen();
} 
public Address getOccurenceLocalAddress()
    { 
return state.getEnderecoLocalOcorrencia();
} 
public AnimalComplaint(String solicitante, String descricao, String observacao, String email,
                           Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                           Address enderecoSolicitante, short animalQuantity, Date inconvenienceDate,
                           String animal, Address occurenceLocalAddress)
    { 
super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);
if(situacao==Situation.QUEIXA_ABERTA)//1
{ 
state= new AnimalComplaintStateOpen(animalQuantity, inconvenienceDate, animal, occurenceLocalAddress);
} 
else
if(situacao==Situation.QUEIXA_FECHADA)//1
{ 
state= new AnimalComplaintStateClosed(animalQuantity, inconvenienceDate, animal, occurenceLocalAddress);
} 
} 
public void setSituacao(int situacao)
    { 
super.setSituacao(situacao);
state.setStatus(situacao, this);
} 
public void setOccurenceLocalAddress(Address occurenceLocalAddress)
    { 
state.setEnderecoLocalOcorrencia(occurenceLocalAddress);
} 
public void setAnimal(String animal)
    { 
state.setAnimal(animal);
} 
public Date getInconvenienceDate()
    { 
return state.getDataIncomodo();
} 
public short getAnimalQuantity()
    { 
return state.getQtdeAnimais();
} 
public void setInconvenienceDate(Date inconvenienceDate)
    { 
state.setDataIncomodo(inconvenienceDate);
} 
public String getAnimal()
    { 
return state.getAnimal();
} 
public void setAnimalQuantity(short animalQuantity)
    { 
state.setQtdeAnimais(animalQuantity);
} 

 } 
