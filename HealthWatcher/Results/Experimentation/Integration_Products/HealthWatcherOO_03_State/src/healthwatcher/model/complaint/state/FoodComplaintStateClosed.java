package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
public class FoodComplaintStateClosed extends FoodComplaintState
  { 
public FoodComplaintStateClosed()
    { 
super();
} 
public void setQtdeDoentes(int newQtdeDoentes)
    {
}public void setEnderecoDoente(Address newEnderecoDoente)
    {
}public void setQtdeObitos(int newQtdeObitos)
    {
}public void setQtdeInternacoes(int newQtdeInternacoes)
    {
}public FoodComplaintStateClosed(int qtdeComensais, int qtdeDoentes,
                                    int qtdeInternacoes, int qtdeObitos, String localAtendimento,
                                    String refeicaoSuspeita, Address enderecoDoente)
    { 
super(qtdeComensais, qtdeDoentes, qtdeInternacoes, qtdeObitos,
              localAtendimento, refeicaoSuspeita, enderecoDoente);
} 
public void setLocalAtendimento(String newLocalAtendimento)
    {
}public void setQtdeComensais(int newQtdeComensais)
    {
}public void setRefeicaoSuspeita(String newRefeicaoSuspeita)
    {
}
 } 
