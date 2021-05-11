
//#if 2144437019
// Compilation Unit of /SpecialComplaintState.java


//#if -152539449
package healthwatcher.model.complaint.state;
//#endif


//#if 1842586488
import healthwatcher.model.address.Address;
//#endif


//#if -160896105
import healthwatcher.model.complaint.Situation;
//#endif


//#if -387433553
import healthwatcher.model.complaint.SpecialComplaint;
//#endif


//#if -642786020
import java.io.Serializable;
//#endif


//#if -478879887
public abstract class SpecialComplaintState implements
//#if 256383044
    Serializable
//#endif

{

//#if 1426680999
    protected short    idade;
//#endif


//#if -1591921491
    protected String   instrucao;
//#endif


//#if -436178558
    protected String   ocupacao;
//#endif


//#if -175833872
    protected Address enderecoOcorrencia;
//#endif


//#if 1733589792
    public short getIdade()
    {

//#if -1825018467
        return this.idade;
//#endif

    }

//#endif


//#if 462786835
    public abstract void setEnderecoOcorrencia(Address newEnderecoOcorrencia);
//#endif


//#if -237691054
    public SpecialComplaintState(short idade,
                                 String instrucao, String ocupacao,
                                 Address enderecoOcorrencia)
    {

//#if -2039124888
        this.idade              = idade;
//#endif


//#if -896322586
        this.instrucao          = instrucao;
//#endif


//#if -677992132
        this.ocupacao           = ocupacao;
//#endif


//#if 1211049308
        this.enderecoOcorrencia = enderecoOcorrencia;
//#endif

    }

//#endif


//#if 1735268346
    public abstract void setOcupacao(java.lang.String newOcupacao);
//#endif


//#if 271875415
    public void setStatus(int sit,SpecialComplaint complaint)
    {

//#if -1990167024
        if(sit!=complaint.getSituacao()) { //1

//#if 1698703892
            if(sit==Situation.QUEIXA_ABERTA) { //1

//#if -684242561
                complaint.setComplaintState(new SpecialComplaintStateOpen(idade, instrucao, ocupacao, enderecoOcorrencia));
//#endif

            } else

//#if -2012581006
                if(sit==Situation.QUEIXA_FECHADA) { //1

//#if -1398465197
                    complaint.setComplaintState(new SpecialComplaintStateClosed(idade, instrucao, ocupacao, enderecoOcorrencia));
//#endif

                } else

//#if -733201451
                    if(sit==Situation.QUEIXA_SUSPENSA) { //1
                    }
//#endif


//#endif


//#endif

        }

//#endif

    }

//#endif


//#if -1138444098
    public abstract void setInstrucao(java.lang.String newInstrucao);
//#endif


//#if -1040599983
    public Address getEnderecoOcorrencia()
    {

//#if 408451445
        return this.enderecoOcorrencia;
//#endif

    }

//#endif


//#if 1608219589
    public abstract void setIdade(short newIdade);
//#endif


//#if 1719806642
    public String getInstrucao()
    {

//#if -1092083495
        return this.instrucao;
//#endif

    }

//#endif


//#if -587000878
    public SpecialComplaintState()
    {
    }
//#endif


//#if -374708137
    public String getOcupacao()
    {

//#if 627029225
        return this.ocupacao;
//#endif

    }

//#endif

}

//#endif


//#endif

