// Compilation Unit of /AnimalComplaint.java 
 
package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;

//#if -1160084038 
import healthwatcher.model.complaint.state.AnimalComplaintState;
//#endif 


//#if 557387374 
import healthwatcher.model.complaint.state.AnimalComplaintStateClosed;
//#endif 


//#if 463167760 
import healthwatcher.model.complaint.state.AnimalComplaintStateOpen;
//#endif 

public class AnimalComplaint extends Complaint
  { 

//#if 2036421025 
private short animalQuantity;
//#endif 


//#if 735308530 
private Date inconvenienceDate;
//#endif 


//#if 1916151141 
private String animal;
//#endif 


//#if 1933157286 
private Address occurenceLocalAddress;
//#endif 


//#if -299127659 
private AnimalComplaintState state;
//#endif 


//#if -1524425986 
public void setComplaintState(AnimalComplaintState _state)
    { 
state= _state;
} 

//#endif 

public AnimalComplaint()
    { 

//#if -899437655 
super();
//#endif 


//#if 776758372 
state= new AnimalComplaintStateOpen();
//#endif 

} 

public Address getOccurenceLocalAddress()
    { 

//#if -1326695102 
return occurenceLocalAddress;
//#endif 


//#if -508266605 
return state.getEnderecoLocalOcorrencia();
//#endif 

} 

public AnimalComplaint(String solicitante, String descricao, String observacao, String email,
                           Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                           Address enderecoSolicitante, short animalQuantity, Date inconvenienceDate,
                           String animal, Address occurenceLocalAddress)
    { 
super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);

//#if 264818415 
this.animalQuantity = animalQuantity;
//#endif 


//#if 1074081577 
this.inconvenienceDate = inconvenienceDate;
//#endif 


//#if -1779105649 
this.animal = animal;
//#endif 


//#if -2074450967 
this.occurenceLocalAddress = occurenceLocalAddress;
//#endif 


//#if -1823765426 
if(situacao==Situation.QUEIXA_ABERTA)//1
{ 
state= new AnimalComplaintStateOpen(animalQuantity, inconvenienceDate, animal, occurenceLocalAddress);
} 
else

//#if 1422590687 
if(situacao==Situation.QUEIXA_FECHADA)//1
{ 
state= new AnimalComplaintStateClosed(animalQuantity, inconvenienceDate, animal, occurenceLocalAddress);
} 

//#endif 


//#endif 

} 


//#if -265826423 
public void setSituacao(int situacao)
    { 
super.setSituacao(situacao);
state.setStatus(situacao, this);
} 

//#endif 

public void setOccurenceLocalAddress(Address occurenceLocalAddress)
    { 

//#if 115086793 
this.occurenceLocalAddress = occurenceLocalAddress;
//#endif 


//#if -1823974403 
state.setEnderecoLocalOcorrencia(occurenceLocalAddress);
//#endif 

} 

public void setAnimal(String animal)
    { 

//#if -1694387781 
this.animal = animal;
//#endif 


//#if 1068243496 
state.setAnimal(animal);
//#endif 

} 

public Date getInconvenienceDate()
    { 

//#if -1118649750 
return inconvenienceDate;
//#endif 


//#if -806024504 
return state.getDataIncomodo();
//#endif 

} 

public short getAnimalQuantity()
    { 

//#if 1407173620 
return animalQuantity;
//#endif 


//#if 1383846621 
return state.getQtdeAnimais();
//#endif 

} 

public void setInconvenienceDate(Date inconvenienceDate)
    { 

//#if -1022745216 
this.inconvenienceDate = inconvenienceDate;
//#endif 


//#if -790103697 
state.setDataIncomodo(inconvenienceDate);
//#endif 

} 

public String getAnimal()
    { 

//#if 1084651404 
return animal;
//#endif 


//#if 590090104 
return state.getAnimal();
//#endif 

} 

public void setAnimalQuantity(short animalQuantity)
    { 

//#if -1835248226 
this.animalQuantity = animalQuantity;
//#endif 


//#if 1258325280 
state.setQtdeAnimais(animalQuantity);
//#endif 

} 

 } 


