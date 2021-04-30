
//#if -997767539 
// Compilation Unit of /FoodComplaintState.java 
 

//#if 1255165465 
package healthwatcher.model.complaint.state;
//#endif 


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


//#if 832542980 
public abstract class FoodComplaintState implements 
//#if -1791334508 
Serializable
//#endif 

  { 

//#if 742561299 
protected int      qtdeComensais;
//#endif 


//#if -2092611129 
protected int      qtdeDoentes;
//#endif 


//#if 65829676 
protected int      qtdeInternacoes;
//#endif 


//#if -648681569 
protected int      qtdeObitos;
//#endif 


//#if 26950124 
protected String   localAtendimento;
//#endif 


//#if -1145566457 
protected String   refeicaoSuspeita;
//#endif 


//#if -2102713550 
protected Address enderecoDoente;
//#endif 


//#if 1783882462 
public abstract void setQtdeObitos(int newQtdeObitos);
//#endif 


//#if 1498378878 
public abstract void setLocalAtendimento(java.lang.String newLocalAtendimento);
//#endif 


//#if 982878708 
public abstract void setQtdeComensais(int newQtdeComensais);
//#endif 


//#if -1684999566 
public String getRefeicaoSuspeita()
    { 

//#if 1870939090 
return this.refeicaoSuspeita;
//#endif 

} 

//#endif 


//#if 1090113045 
public FoodComplaintState(int qtdeComensais,
                              int qtdeDoentes, int qtdeInternacoes,
                              int qtdeObitos, String localAtendimento,
                              String refeicaoSuspeita, Address enderecoDoente)
    { 

//#if 8916395 
this.qtdeComensais=qtdeComensais;
//#endif 


//#if -115624109 
this.qtdeDoentes=qtdeDoentes;
//#endif 


//#if -1144486499 
this.qtdeInternacoes=qtdeInternacoes;
//#endif 


//#if -483632755 
this.qtdeObitos=qtdeObitos;
//#endif 


//#if 716224109 
this.localAtendimento=localAtendimento;
//#endif 


//#if -80760883 
this.refeicaoSuspeita=refeicaoSuspeita;
//#endif 


//#if -2001892595 
this.enderecoDoente=enderecoDoente;
//#endif 

} 

//#endif 


//#if -312943844 
public abstract void setQtdeDoentes(int newQtdeDoentes);
//#endif 


//#if 484993027 
public abstract void setEnderecoDoente(Address newEnderecoDoente);
//#endif 


//#if -319166412 
public void setStatus(int sit,FoodComplaint complaint)
    { 

//#if 1447148057 
if(sit!=complaint.getSituacao())//1
{ 

//#if -384408664 
if(sit==Situation.QUEIXA_ABERTA)//1
{ 

//#if 113438812 
complaint.setComplaintState(new FoodComplaintStateOpen(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                            refeicaoSuspeita,enderecoDoente));
//#endif 

} 
else

//#if -1995192143 
if(sit==Situation.QUEIXA_FECHADA)//1
{ 

//#if -2074323028 
complaint.setComplaintState(new FoodComplaintStateClosed(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                            refeicaoSuspeita,enderecoDoente));
//#endif 

} 
else

//#if 1476066674 
if(sit==Situation.QUEIXA_SUSPENSA)//1
{
}
//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 99083060 
public abstract void setRefeicaoSuspeita(java.lang.String newRefeicaoSuspeita);
//#endif 


//#if 1951083014 
public int getQtdeDoentes()
    { 

//#if -573187691 
return qtdeDoentes;
//#endif 

} 

//#endif 


//#if 303276077 
public String getLocalAtendimento()
    { 

//#if -2103217270 
return this.localAtendimento;
//#endif 

} 

//#endif 


//#if -144912177 
public Address getEnderecoDoente()
    { 

//#if 1029132211 
return this.enderecoDoente;
//#endif 

} 

//#endif 


//#if -836999430 
public int getQtdeComensais()
    { 

//#if -1720587709 
return qtdeComensais;
//#endif 

} 

//#endif 


//#if -1718405951 
public int getQtdeInternacoes()
    { 

//#if 1850245333 
return qtdeInternacoes;
//#endif 

} 

//#endif 


//#if -721990490 
public abstract void setQtdeInternacoes(int newQtdeInternacoes);
//#endif 


//#if -664783773 
public FoodComplaintState()
    {
}
//#endif 


//#if 1997235948 
public int getQtdeObitos()
    { 

//#if -792723591 
return qtdeObitos;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

