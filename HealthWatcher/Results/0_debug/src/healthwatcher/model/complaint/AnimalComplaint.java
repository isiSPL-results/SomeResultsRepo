
//#if -594852229
// Compilation Unit of /AnimalComplaint.java


//#if -193081918
package healthwatcher.model.complaint;
//#endif


//#if 2047628160
import healthwatcher.model.address.Address;
//#endif


//#if -1233301492
import healthwatcher.model.employee.Employee;
//#endif


//#if 424007478
import lib.util.Date;
//#endif


//#if -1160084038
import healthwatcher.model.complaint.state.AnimalComplaintState;
//#endif


//#if 557387374
import healthwatcher.model.complaint.state.AnimalComplaintStateClosed;
//#endif


//#if 463167760
import healthwatcher.model.complaint.state.AnimalComplaintStateOpen;
//#endif


//#if 133043239
public class AnimalComplaint extends
//#if -1836378319
    Complaint
//#endif

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

//#if 1658090392
        state= _state;
//#endif

    }

//#endif


//#if -1664797683
    public AnimalComplaint()
    {

//#if -899437655
        super();
//#endif


//#if 776758372
        state= new AnimalComplaintStateOpen();
//#endif

    }

//#endif


//#if -27845924
    public Address getOccurenceLocalAddress()
    {

//#if -1326695102
        return occurenceLocalAddress;
//#endif


//#if -508266605
        return state.getEnderecoLocalOcorrencia();
//#endif

    }

//#endif


//#if 683404131
    public AnimalComplaint(String solicitante, String descricao, String observacao, String email,
                           Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                           Address enderecoSolicitante, short animalQuantity, Date inconvenienceDate,
                           String animal, Address occurenceLocalAddress)
    {

//#if -820996999
        super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);
//#endif


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
        if(situacao==Situation.QUEIXA_ABERTA) { //1

//#if 2046567833
            state= new AnimalComplaintStateOpen(animalQuantity, inconvenienceDate, animal, occurenceLocalAddress);
//#endif

        } else

//#if 1422590687
            if(situacao==Situation.QUEIXA_FECHADA) { //1

//#if 1422974058
                state= new AnimalComplaintStateClosed(animalQuantity, inconvenienceDate, animal, occurenceLocalAddress);
//#endif

            }

//#endif


//#endif

    }

//#endif


//#if -265826423
    public void setSituacao(int situacao)
    {

//#if 1511343778
        super.setSituacao(situacao);
//#endif


//#if 1502046701
        state.setStatus(situacao, this);
//#endif

    }

//#endif


//#if 157122666
    public void setOccurenceLocalAddress(Address occurenceLocalAddress)
    {

//#if 115086793
        this.occurenceLocalAddress = occurenceLocalAddress;
//#endif


//#if -1823974403
        state.setEnderecoLocalOcorrencia(occurenceLocalAddress);
//#endif

    }

//#endif


//#if 242020923
    public void setAnimal(String animal)
    {

//#if -1694387781
        this.animal = animal;
//#endif


//#if 1068243496
        state.setAnimal(animal);
//#endif

    }

//#endif


//#if -1001823908
    public Date getInconvenienceDate()
    {

//#if -1118649750
        return inconvenienceDate;
//#endif


//#if -806024504
        return state.getDataIncomodo();
//#endif

    }

//#endif


//#if 1189174245
    public short getAnimalQuantity()
    {

//#if 1407173620
        return animalQuantity;
//#endif


//#if 1383846621
        return state.getQtdeAnimais();
//#endif

    }

//#endif


//#if 1760951850
    public void setInconvenienceDate(Date inconvenienceDate)
    {

//#if -1022745216
        this.inconvenienceDate = inconvenienceDate;
//#endif


//#if -790103697
        state.setDataIncomodo(inconvenienceDate);
//#endif

    }

//#endif


//#if 34130303
    public String getAnimal()
    {

//#if 1084651404
        return animal;
//#endif


//#if 590090104
        return state.getAnimal();
//#endif

    }

//#endif


//#if 1326802652
    public void setAnimalQuantity(short animalQuantity)
    {

//#if -1835248226
        this.animalQuantity = animalQuantity;
//#endif


//#if 1258325280
        state.setQtdeAnimais(animalQuantity);
//#endif

    }

//#endif

}

//#endif


//#endif

