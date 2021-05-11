
//#if -616051513
// Compilation Unit of /FoodComplaintStateOpen.java

package healthwatcher.model.complaint.state;

//#if 1425939794
import healthwatcher.model.address.Address;
//#endif

public class FoodComplaintStateOpen extends FoodComplaintState
{
    public void setEnderecoDoente(Address newEnderecoDoente)
    {
        enderecoDoente= newEnderecoDoente;
    }

    public void setLocalAtendimento(String newLocalAtendimento)
    {
        localAtendimento= newLocalAtendimento;
    }

    public void setQtdeInternacoes(int newQtdeInternacoes)
    {
        qtdeInternacoes= newQtdeInternacoes;
    }

    public void setQtdeObitos(int newQtdeObitos)
    {
        qtdeObitos= newQtdeObitos;
    }

    public void setRefeicaoSuspeita(String newRefeicaoSuspeita)
    {
        refeicaoSuspeita= newRefeicaoSuspeita;
    }

    public void setQtdeDoentes(int newQtdeDoentes)
    {
        qtdeDoentes= newQtdeDoentes;
    }

    public void setQtdeComensais(int newQtdeComensais)
    {
        qtdeComensais= newQtdeComensais;
    }

    public FoodComplaintStateOpen(int qtdeComensais, int qtdeDoentes,
                                  int qtdeInternacoes, int qtdeObitos, String localAtendimento,
                                  String refeicaoSuspeita, Address enderecoDoente)
    {
        super(qtdeComensais, qtdeDoentes, qtdeInternacoes, qtdeObitos,
              localAtendimento, refeicaoSuspeita, enderecoDoente);
    }

    public FoodComplaintStateOpen()
    {
        super();
    }

}


//#endif

