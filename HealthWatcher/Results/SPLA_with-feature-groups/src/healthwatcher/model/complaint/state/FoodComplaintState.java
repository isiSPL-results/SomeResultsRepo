
//#if -997767539 
// Compilation Unit of /FoodComplaintState.java 
 
package healthwatcher.model.complaint.state;

//#if -190213658 
import healthwatcher.model.address.Address;
//#endif 


//#if 322596086 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if 715518725 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if 991207534 
import java.io.Serializable;
//#endif 

public abstract class FoodComplaintState implements Serializable
  { 
protected int      qtdeComensais;
protected int      qtdeDoentes;
protected int      qtdeInternacoes;
protected int      qtdeObitos;
protected String   localAtendimento;
protected String   refeicaoSuspeita;
protected Address enderecoDoente;
public abstract void setQtdeObitos(int newQtdeObitos);
public abstract void setLocalAtendimento(java.lang.String newLocalAtendimento);
public abstract void setQtdeComensais(int newQtdeComensais);
public String getRefeicaoSuspeita()
    { 
return this.refeicaoSuspeita;
} 

public FoodComplaintState(int qtdeComensais,
                              int qtdeDoentes, int qtdeInternacoes,
                              int qtdeObitos, String localAtendimento,
                              String refeicaoSuspeita, Address enderecoDoente)
    { 
this.qtdeComensais=qtdeComensais;
this.qtdeDoentes=qtdeDoentes;
this.qtdeInternacoes=qtdeInternacoes;
this.qtdeObitos=qtdeObitos;
this.localAtendimento=localAtendimento;
this.refeicaoSuspeita=refeicaoSuspeita;
this.enderecoDoente=enderecoDoente;
} 

public abstract void setQtdeDoentes(int newQtdeDoentes);
public abstract void setEnderecoDoente(Address newEnderecoDoente);
public void setStatus(int sit,FoodComplaint complaint)
    { 
if(sit!=complaint.getSituacao())//1
{ 
if(sit==Situation.QUEIXA_ABERTA)//1
{ 
complaint.setComplaintState(new FoodComplaintStateOpen(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                            refeicaoSuspeita,enderecoDoente));
} 
else

//#if -1995192143 
if(sit==Situation.QUEIXA_FECHADA)//1
{ 
complaint.setComplaintState(new FoodComplaintStateClosed(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                            refeicaoSuspeita,enderecoDoente));
} 
else

//#if 1476066674 
if(sit==Situation.QUEIXA_SUSPENSA)//1
{
}
//#endif 


//#endif 


} 

} 

public abstract void setRefeicaoSuspeita(java.lang.String newRefeicaoSuspeita);
public int getQtdeDoentes()
    { 
return qtdeDoentes;
} 

public String getLocalAtendimento()
    { 
return this.localAtendimento;
} 

public Address getEnderecoDoente()
    { 
return this.enderecoDoente;
} 

public int getQtdeComensais()
    { 
return qtdeComensais;
} 

public int getQtdeInternacoes()
    { 
return qtdeInternacoes;
} 

public abstract void setQtdeInternacoes(int newQtdeInternacoes);
public FoodComplaintState()
    {
}
public int getQtdeObitos()
    { 
return qtdeObitos;
} 

 } 


//#endif 

