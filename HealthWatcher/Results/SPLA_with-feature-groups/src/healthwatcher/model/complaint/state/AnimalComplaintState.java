
//#if 1589837326 
// Compilation Unit of /AnimalComplaintState.java 
 
package healthwatcher.model.complaint.state;

//#if -592247111 
import healthwatcher.model.address.Address;
//#endif 


//#if 333621287 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if 1416808024 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if -1270317061 
import java.io.Serializable;
//#endif 


//#if 1372240687 
import lib.util.Date;
//#endif 

public abstract class AnimalComplaintState implements Serializable
  { 
protected short qtdeAnimais;
protected Date dataIncomodo;
protected String animal;
protected Address enderecoLocalOcorrencia;
public abstract void setEnderecoLocalOcorrencia(Address newEnderecoLocalOcorrencia);
public AnimalComplaintState()
    {
}
public String getTipoAnimal()
    { 
return this.animal;
} 

public abstract void setAnimal(String newAnimal);
public Address getEnderecoLocalOcorrencia()
    { 
return this.enderecoLocalOcorrencia;
} 

public short getQtdeAnimais()
    { 
return this.qtdeAnimais;
} 

public Date getDataIncomodo()
    { 
return this.dataIncomodo;
} 

public java.lang.String getAnimal()
    { 
return animal;
} 

public abstract void setDataIncomodo(Date newDataIncomodo);
public void setStatus(int sit,AnimalComplaint complaint)
    { 
if(sit!=complaint.getSituacao())//1
{ 
if(sit==Situation.QUEIXA_ABERTA)//1
{ 
complaint.setComplaintState(new AnimalComplaintStateOpen(qtdeAnimais, dataIncomodo, animal, enderecoLocalOcorrencia));
} 
else

//#if -1615859709 
if(sit==Situation.QUEIXA_FECHADA)//1
{ 
complaint.setComplaintState(new AnimalComplaintStateClosed(qtdeAnimais, dataIncomodo, animal, enderecoLocalOcorrencia));
} 
else

//#if -2067524529 
if(sit==Situation.QUEIXA_SUSPENSA)//1
{
}
//#endif 


//#endif 


} 

} 

public abstract void setQtdeAnimais(short newQtdeAnimais);
public AnimalComplaintState(short qtdeAnimais, Date dataIncomodo, String animal, Address endereco)
    { 
this.qtdeAnimais= qtdeAnimais;
this.dataIncomodo= dataIncomodo;
this.animal= animal;
this.enderecoLocalOcorrencia= endereco;
} 

public abstract void setTipoAnimal(String newAnimal);
 } 


//#endif 

