
//#if -1319074041 
// Compilation Unit of /FoodComplaintStateClosed.java 
 
package healthwatcher.model.complaint.state;

//#if -1540966736 
import healthwatcher.model.address.Address;
//#endif 

public class FoodComplaintStateClosed extends FoodComplaintState
  { 
public FoodComplaintStateClosed()
    { 
super();
} 

public void setQtdeDoentes(int newQtdeDoentes)
    {
}
public void setEnderecoDoente(Address newEnderecoDoente)
    {
}
public void setQtdeObitos(int newQtdeObitos)
    {
}
public void setQtdeInternacoes(int newQtdeInternacoes)
    {
}
public FoodComplaintStateClosed(int qtdeComensais, int qtdeDoentes,
                                    int qtdeInternacoes, int qtdeObitos, String localAtendimento,
                                    String refeicaoSuspeita, Address enderecoDoente)
    { 
super(qtdeComensais, qtdeDoentes, qtdeInternacoes, qtdeObitos,
              localAtendimento, refeicaoSuspeita, enderecoDoente);
} 

public void setLocalAtendimento(String newLocalAtendimento)
    {
}
public void setQtdeComensais(int newQtdeComensais)
    {
}
public void setRefeicaoSuspeita(String newRefeicaoSuspeita)
    {
}
 } 


//#endif 

