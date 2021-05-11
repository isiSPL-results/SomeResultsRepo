// Compilation Unit of /Complaint.java

package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;

//#if 1929395914
import healthwatcher.model.complaint.state.ComplaintState;
//#endif


//#if 416529278
import healthwatcher.model.complaint.state.ComplaintStateClosed;
//#endif


//#if 1763578400
import healthwatcher.model.complaint.state.ComplaintStateOpen;
//#endif


//#if 64858056
import java.io.Serializable;
//#endif


//#if 828859590
import java.rmi.RemoteException;
//#endif


//#if -344866820
import java.util.ArrayList;
//#endif


//#if 526255893
import java.util.Iterator;
//#endif


//#if -1710593819
import java.util.List;
//#endif


//#if -1953554845
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1175537245
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 994568799
import lib.exceptions.RepositoryException;
//#endif


//#if 703861441
import lib.exceptions.TransactionException;
//#endif


//#if -681726153
import lib.patterns.observer.Observer;
//#endif


//#if 1993047869
import lib.patterns.observer.Subject;
//#endif

public abstract class Complaint implements
//#if 1663975549
    java.io.Serializable
//#endif

    ,
//#if -459697535
    Serializable
//#endif

    ,
//#if 1648472682
    Subject
//#endif

{
    public static final int QUEIXA_ALIMENTAR = 1;
    public static final int QUEIXA_ANIMAL = 2;
    public static final int QUEIXA_DIVERSA = 3;

//#if -1158069356
    private int codigo;
//#endif


//#if -113679430
    private String solicitante;
//#endif


//#if -1278726428
    private String descricao;
//#endif


//#if 873131536
    private String observacao;
//#endif


//#if 1998810353
    private String email;
//#endif


//#if 1449913800
    private Employee atendente;
//#endif


//#if 423299014
    private int situacao;
//#endif


//#if 1712164168
    private Date dataParecer;
//#endif


//#if 117977873
    private Date dataQueixa;
//#endif


//#if 785591588
    private Address enderecoSolicitante;
//#endif


//#if -219372926
    private long timestamp;
//#endif


//#if -1256740751
    private ComplaintState state;
//#endif


//#if -1104035374
    private List subscribers = new ArrayList();
//#endif

    public int getCodigo()
    {

//#if 1402241331
        return codigo;
//#endif


//#if -544535997
        return state.getCode();
//#endif

    }

    public void setDataQueixa(Date dataQueixa)
    {

//#if -764298936
        this.dataQueixa = dataQueixa;
//#endif


//#if -723702821
        state.setComplaintDate(dataQueixa);
//#endif

    }

    public void setTimestamp(long timestamp)
    {

//#if 1672765776
        this.timestamp = timestamp;
//#endif


//#if 891801277
        state.setTimestamp(timestamp);
//#endif

    }


//#if 292590733
    public void addObserver(Observer observer)
    {
        subscribers.add(observer);
    }

//#endif

    public void setSolicitante(String solicitante)
    {

//#if 1843437966
        this.solicitante = solicitante;
//#endif


//#if -1649955996
        state.setComplainer(solicitante);
//#endif

    }

    public void setObservacao(String observacao)
    {

//#if -504262065
        this.observacao = observacao;
//#endif


//#if 1225561997
        state.setObservation(observacao);
//#endif


//#if 548864513
        state.setObservation(observacao, this);
//#endif

    }

    public String getEmail()
    {

//#if -2105364374
        return email;
//#endif


//#if -1846956884
        return state.getEmail();
//#endif

    }

    public Complaint(String solicitante, String descricao, String observacao, String email,
                     Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                     Address enderecoSolicitante, long timestamp)
    {

//#if 1504246629
        this.codigo = 0;
//#endif


//#if 2051167612
        this.solicitante = solicitante;
//#endif


//#if -449806896
        this.descricao = descricao;
//#endif


//#if 1129320360
        this.observacao = observacao;
//#endif


//#if -629457366
        this.email = email;
//#endif


//#if -1557849442
        this.atendente = atendente;
//#endif


//#if 1054631912
        this.situacao = situacao;
//#endif


//#if 491443806
        this.dataParecer = dataParecer;
//#endif


//#if 555918568
        this.dataQueixa = dataQueixa;
//#endif


//#if 1340937678
        this.enderecoSolicitante = enderecoSolicitante;
//#endif


//#if 1584857014
        this.timestamp = timestamp;
//#endif


//#if -581155467
        if(situacao==Situation.QUEIXA_ABERTA)//1

//#if -1399263349
            state= new ComplaintStateOpen(0,solicitante, descricao,
                                          observacao, email, atendente,
                                          dataParecer, dataQueixa,
                                          enderecoSolicitante, timestamp);
//#endif

        else

//#if 239684625
            if(situacao==Situation.QUEIXA_FECHADA)//1

//#if 980695859
                state= new ComplaintStateClosed(0,solicitante, descricao,
                                                observacao, email, atendente,
                                                dataParecer, dataQueixa,
                                                enderecoSolicitante, timestamp);
//#endif


//#endif


//#endif

    }

    public int getSituacao()
    {

//#if 2020922716
        return situacao;
//#endif


//#if -215643449
        return state.getStatus();
//#endif

    }

    public String getDescricao()
    {

//#if -1229482429
        return descricao;
//#endif


//#if -1856382170
        return state.getDescription();
//#endif

    }

    public Address getEnderecoSolicitante()
    {

//#if 1388353670
        return enderecoSolicitante;
//#endif


//#if -1529056544
        return state.getComplainerAddress();
//#endif

    }

    public String getObservacao()
    {

//#if -1968065394
        return observacao;
//#endif


//#if -675870861
        return state.getObservation();
//#endif

    }

    public Employee getAtendente()
    {

//#if 1788351495
        return atendente;
//#endif


//#if -700467880
        return state.getAttendant();
//#endif

    }

    public void incTimestamp()
    {

//#if 1320007176
        this.timestamp = timestamp + 1;
//#endif


//#if -142283209
        state.incTimestamp();
//#endif

    }

    public void setEnderecoSolicitante(Address enderecoSolicitante)
    {

//#if 1821290502
        this.enderecoSolicitante = enderecoSolicitante;
//#endif


//#if -2017097637
        state.setComplainerAddress(enderecoSolicitante);
//#endif

    }


//#if -1243603698
    public void removeObserver(Observer observer)
    {
        subscribers.remove(observer);
    }

//#endif


//#if 2109165462
    public void notifyObservers()
    {
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1
            Observer observer = (Observer) it.next();
            try { //1

//#if -140806939
                System.out.println("Notifying " + observer);
//#endif

                observer.notify(this);
            }

//#if 2090471032
            catch (RemoteException e) { //1
                e.printStackTrace();
            }

//#endif


//#if -162729990
            catch (ObjectNotValidException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 426988800
            catch (ObjectNotFoundException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 1031783272
            catch (TransactionException e) { //1
                e.printStackTrace();
            }

//#endif


//#if -819318660
            catch (RepositoryException e) { //1
                e.printStackTrace();
            }

//#endif


        }

        if(! subscribers.isEmpty()) { //1
            this.incTimestamp();
        }

    }

//#endif

    public Date getDataParecer()
    {

//#if -1394808358
        return dataParecer;
//#endif


//#if -2075781373
        return state.getMedicalOpinionDate();
//#endif

    }

    public String getSolicitante()
    {

//#if -1329546940
        return solicitante;
//#endif


//#if -604111321
        return state.getComplainer();
//#endif

    }


//#if 224782738
    public void setComplaintState(ComplaintState _state)
    {
        state= _state;

//#if 1680460053
        notifyObservers();
//#endif

    }

//#endif

    public void setAtendente(Employee atendente)
    {

//#if -2058473992
        this.atendente = atendente;
//#endif


//#if -589541632
        state.setAttendant(atendente);
//#endif


//#if -1587611026
        state.setAttendant(atendente, this);
//#endif

    }

    public void setCodigo(int codigo)
    {

//#if -2053202210
        this.codigo = codigo;
//#endif


//#if -233087791
        state.setCode(codigo);
//#endif

    }

    public long getTimestamp()
    {

//#if 1527873292
        return timestamp;
//#endif


//#if 1464619542
        return state.getTimestamp();
//#endif

    }

    public void setDataParecer(Date dataParecer)
    {

//#if 366203699
        this.dataParecer = dataParecer;
//#endif


//#if -1995194497
        state.setMedicalOpinionDate(dataParecer);
//#endif

    }

    public void setSituacao(int situacao)
    {

//#if -1525256574
        this.situacao = situacao;
//#endif


//#if 1799783704
        state.setStatus(situacao, this);
//#endif

    }

    public void setDescricao(String descricao)
    {

//#if 859204015
        this.descricao = descricao;
//#endif


//#if 350037361
        state.setDescription(descricao);
//#endif

    }

    public void setEmail(String email)
    {

//#if -1040619655
        this.email = email;
//#endif


//#if -289931852
        state.setEmail(email);
//#endif

    }

    public Date getDataQueixa()
    {

//#if 1817702768
        return dataQueixa;
//#endif


//#if 191295786
        return state.getComplaintDate();
//#endif

    }

    public Complaint()
    {

//#if 209105996
        state= new ComplaintStateOpen();
//#endif

    }

}


