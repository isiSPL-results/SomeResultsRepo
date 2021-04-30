
//#if -293587870 
// Compilation Unit of /FoodComplaint.java 
 

//#if -1232609907 
package healthwatcher.model.complaint;
//#endif 


//#if 1633381013 
import healthwatcher.model.address.Address;
//#endif 


//#if 107148769 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -1015583733 
import lib.util.Date;
//#endif 


//#if -471490013 
import healthwatcher.model.complaint.state.FoodComplaintState;
//#endif 


//#if -152209385 
import healthwatcher.model.complaint.state.FoodComplaintStateClosed;
//#endif 


//#if 1468014841 
import healthwatcher.model.complaint.state.FoodComplaintStateOpen;
//#endif 


//#if -69505958 
public class FoodComplaint extends 
//#if 1038077881 
Complaint
//#endif 

  { 

//#if 1815749179 
private int qtdeComensais;
//#endif 


//#if 545374191 
private int qtdeDoentes;
//#endif 


//#if 607231316 
private int qtdeInternacoes;
//#endif 


//#if -1256321929 
private int qtdeObitos;
//#endif 


//#if 1488128020 
private String localAtendimento;
//#endif 


//#if 315611439 
private String refeicaoSuspeita;
//#endif 


//#if -808652790 
private Address enderecoDoente;
//#endif 


//#if -393947457 
private FoodComplaintState state;
//#endif 


//#if -1979175853 
public FoodComplaint(String solicitante, String descricao, String observacao, String email,
                         Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                         Address enderecoSolicitante, int qtdeComensais, int qtdeDoentes, int qtdeInternacoes,
                         int qtdeObitos, String localAtendimento, String refeicaoSuspeita, Address enderecoDoente)
    { 

//#if 1810113010 
super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);
//#endif 


//#if -1352961324 
this.qtdeComensais = qtdeComensais;
//#endif 


//#if 1186601212 
this.qtdeDoentes = qtdeDoentes;
//#endif 


//#if 1520643654 
this.qtdeInternacoes = qtdeInternacoes;
//#endif 


//#if -115797642 
this.qtdeObitos = qtdeObitos;
//#endif 


//#if 2105792726 
this.localAtendimento = localAtendimento;
//#endif 


//#if 1308807734 
this.refeicaoSuspeita = refeicaoSuspeita;
//#endif 


//#if -801355274 
this.enderecoDoente = enderecoDoente;
//#endif 


//#if 584003719 
if(situacao==Situation.QUEIXA_ABERTA)//1

//#if 1007099495 
state= new FoodComplaintStateOpen(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                              refeicaoSuspeita,enderecoDoente);
//#endif 

else

//#if 1869349881 
if(situacao==Situation.QUEIXA_FECHADA)//1

//#if -1317824925 
state= new FoodComplaintStateClosed(qtdeComensais,qtdeDoentes, qtdeInternacoes, qtdeObitos,localAtendimento,
                                                refeicaoSuspeita,enderecoDoente);
//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 848124080 
public String getLocalAtendimento()
    { 

//#if 1585843009 
return localAtendimento;
//#endif 


//#if -1379664399 
return state.getLocalAtendimento();
//#endif 

} 

//#endif 


//#if 918625198 
public void setEnderecoDoente(Address enderecoDoente)
    { 

//#if 731501181 
this.enderecoDoente = enderecoDoente;
//#endif 


//#if -2057113178 
state.setEnderecoDoente(enderecoDoente);
//#endif 

} 

//#endif 


//#if -1140151563 
public String getRefeicaoSuspeita()
    { 

//#if 516071338 
return refeicaoSuspeita;
//#endif 


//#if 1032434750 
return state.getRefeicaoSuspeita();
//#endif 

} 

//#endif 


//#if -892748029 
public void setQtdeObitos(int qtdeObitos)
    { 

//#if 1651896113 
this.qtdeObitos = qtdeObitos;
//#endif 


//#if 484691442 
state.setQtdeObitos(qtdeObitos);
//#endif 

} 

//#endif 


//#if 528582051 
public void setLocalAtendimento(String localAtendimento)
    { 

//#if -704192169 
this.localAtendimento = localAtendimento;
//#endif 


//#if -1358799156 
state.setLocalAtendimento(localAtendimento);
//#endif 

} 

//#endif 


//#if 445005825 
public void setSituacao(int situacao)
    { 

//#if 1770406593 
super.setSituacao(situacao);
//#endif 


//#if 1186137454 
state.setStatus(situacao, this);
//#endif 

} 

//#endif 


//#if -2099347703 
public int getQtdeObitos()
    { 

//#if 714978830 
return qtdeObitos;
//#endif 


//#if -1752894558 
return state.getQtdeObitos();
//#endif 

} 

//#endif 


//#if 157503652 
public void setComplaintState(FoodComplaintState _state)
    { 

//#if -36097242 
state= _state;
//#endif 

} 

//#endif 


//#if 293437469 
public void setQtdeInternacoes(int qtdeInternacoes)
    { 

//#if -2051057299 
this.qtdeInternacoes = qtdeInternacoes;
//#endif 


//#if -384685184 
state.setQtdeInternacoes(qtdeInternacoes);
//#endif 

} 

//#endif 


//#if -488958583 
public int getQtdeDoentes()
    { 

//#if -640119695 
return qtdeDoentes;
//#endif 


//#if -608509015 
return state.getQtdeDoentes();
//#endif 

} 

//#endif 


//#if 527148740 
public int getQtdeInternacoes()
    { 

//#if 1233584612 
return qtdeInternacoes;
//#endif 


//#if 928872576 
return state.getQtdeInternacoes();
//#endif 

} 

//#endif 


//#if -1692620355 
public void setQtdeDoentes(int qtdeDoentes)
    { 

//#if -1728064548 
this.qtdeDoentes = qtdeDoentes;
//#endif 


//#if 1735356657 
state.setQtdeDoentes(qtdeDoentes);
//#endif 

} 

//#endif 


//#if -1455719373 
public FoodComplaint()
    { 

//#if 1582886465 
state= new FoodComplaintStateOpen();
//#endif 

} 

//#endif 


//#if -1235715092 
public Address getEnderecoDoente()
    { 

//#if 597547144 
return enderecoDoente;
//#endif 


//#if -1017643624 
return state.getEnderecoDoente();
//#endif 

} 

//#endif 


//#if -1481427843 
public void setQtdeComensais(int qtdeComensais)
    { 

//#if 316467472 
this.qtdeComensais = qtdeComensais;
//#endif 


//#if -1514600067 
state.setQtdeComensais(qtdeComensais);
//#endif 

} 

//#endif 


//#if -664830531 
public int getQtdeComensais()
    { 

//#if -1623322784 
return qtdeComensais;
//#endif 


//#if -180442318 
return state.getQtdeComensais();
//#endif 

} 

//#endif 


//#if 1506834243 
public void setRefeicaoSuspeita(String refeicaoSuspeita)
    { 

//#if 2129667121 
this.refeicaoSuspeita = refeicaoSuspeita;
//#endif 


//#if 707601458 
state.setRefeicaoSuspeita(refeicaoSuspeita);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

