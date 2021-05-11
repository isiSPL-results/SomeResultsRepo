
//#if 1589837326
// Compilation Unit of /AnimalComplaintState.java


//#if 1677030310
package healthwatcher.model.complaint.state;
//#endif


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


//#if -1940927953
public abstract class AnimalComplaintState implements
//#if -1221725879
    Serializable
//#endif

{

//#if 595551005
    protected short qtdeAnimais;
//#endif


//#if 27846049
    protected Date dataIncomodo;
//#endif


//#if -1401351382
    protected String animal;
//#endif


//#if -1472413582
    protected Address enderecoLocalOcorrencia;
//#endif


//#if -855021660
    public abstract void setEnderecoLocalOcorrencia(Address newEnderecoLocalOcorrencia);
//#endif


//#if -1967865290
    public AnimalComplaintState()
    {
    }
//#endif


//#if -929218237
    public String getTipoAnimal()
    {

//#if 1217011959
        return this.animal;
//#endif

    }

//#endif


//#if -80660783
    public abstract void setAnimal(String newAnimal);
//#endif


//#if 1308282213
    public Address getEnderecoLocalOcorrencia()
    {

//#if 1292092572
        return this.enderecoLocalOcorrencia;
//#endif

    }

//#endif


//#if -80863446
    public short getQtdeAnimais()
    {

//#if 349982461
        return this.qtdeAnimais;
//#endif

    }

//#endif


//#if -1240079106
    public Date getDataIncomodo()
    {

//#if -1503526405
        return this.dataIncomodo;
//#endif

    }

//#endif


//#if -455051269
    public java.lang.String getAnimal()
    {

//#if -1238754841
        return animal;
//#endif

    }

//#endif


//#if -1241741482
    public abstract void setDataIncomodo(Date newDataIncomodo);
//#endif


//#if -603307957
    public void setStatus(int sit,AnimalComplaint complaint)
    {

//#if -172108548
        if(sit!=complaint.getSituacao()) { //1

//#if 255685382
            if(sit==Situation.QUEIXA_ABERTA) { //1

//#if 2041235472
                complaint.setComplaintState(new AnimalComplaintStateOpen(qtdeAnimais, dataIncomodo, animal, enderecoLocalOcorrencia));
//#endif

            } else

//#if -1615859709
                if(sit==Situation.QUEIXA_FECHADA) { //1

//#if -1133235146
                    complaint.setComplaintState(new AnimalComplaintStateClosed(qtdeAnimais, dataIncomodo, animal, enderecoLocalOcorrencia));
//#endif

                } else

//#if -2067524529
                    if(sit==Situation.QUEIXA_SUSPENSA) { //1
                    }
//#endif


//#endif


//#endif

        }

//#endif

    }

//#endif


//#if 328758786
    public abstract void setQtdeAnimais(short newQtdeAnimais);
//#endif


//#if -650577516
    public AnimalComplaintState(short qtdeAnimais, Date dataIncomodo, String animal, Address endereco)
    {

//#if -971416956
        this.qtdeAnimais= qtdeAnimais;
//#endif


//#if 697918806
        this.dataIncomodo= dataIncomodo;
//#endif


//#if -2006411242
        this.animal= animal;
//#endif


//#if -1898444042
        this.enderecoLocalOcorrencia= endereco;
//#endif

    }

//#endif


//#if -163781251
    public abstract void setTipoAnimal(String newAnimal);
//#endif

}

//#endif


//#endif

