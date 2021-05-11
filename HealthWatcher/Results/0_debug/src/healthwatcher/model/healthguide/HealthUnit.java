
//#if -1480514575
// Compilation Unit of /HealthUnit.java


//#if 1462663857
package healthwatcher.model.healthguide;
//#endif


//#if 2073880485
import java.util.Iterator;
//#endif


//#if -378531467
import java.util.List;
//#endif


//#if 1273406552
import java.io.Serializable;
//#endif


//#if 478124374
import java.rmi.RemoteException;
//#endif


//#if 386855276
import java.util.ArrayList;
//#endif


//#if 1235752691
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 69877485
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 1565764335
import lib.exceptions.RepositoryException;
//#endif


//#if 1231053873
import lib.exceptions.TransactionException;
//#endif


//#if -1778370617
import lib.patterns.observer.Observer;
//#endif


//#if 1819124909
import lib.patterns.observer.Subject;
//#endif


//#if 350736940
public class HealthUnit implements
//#if 1528853380
    java.io.Serializable
//#endif

    ,
//#if -1049183096
    Serializable
//#endif

    ,
//#if 53878787
    Subject
//#endif

{

//#if 2033931225
    private int code;
//#endif


//#if 1008235626
    private String description;
//#endif


//#if 788086960
    private List specialities;
//#endif


//#if -289021671
    private List subscribers = new ArrayList();
//#endif


//#if -1952018020
    public boolean hasSpeciality(int code)
    {

//#if -702631490
        for(Iterator i = specialities.iterator(); i.hasNext();) { //1

//#if 1371354296
            MedicalSpeciality m = (MedicalSpeciality) i.next();
//#endif


//#if 877965454
            if(m.getCodigo() == code) { //1

//#if 14440437
                return true;
//#endif

            }

//#endif

        }

//#endif


//#if 2055693818
        return false;
//#endif

    }

//#endif


//#if -882314951
    public void setDescription(String descricao)
    {

//#if 2088154349
        this.description = descricao;
//#endif


//#if -1980603780
        notifyObservers();
//#endif

    }

//#endif


//#if 1859464074
    public String getDescription()
    {

//#if 720744017
        return this.description;
//#endif

    }

//#endif


//#if 901475623
    public int getCode()
    {

//#if 1534033838
        return this.code;
//#endif

    }

//#endif


//#if -1799517823
    public void setCode(int cod)
    {

//#if 420318569
        this.code = cod;
//#endif

    }

//#endif


//#if -511553552
    public String toString()
    {

//#if 639594510
        return description;
//#endif

    }

//#endif


//#if -211788250
    public void addObserver(Observer observer)
    {

//#if -39261270
        subscribers.add(observer);
//#endif

    }

//#endif


//#if -1136653414
    public List getSpecialities()
    {

//#if 303798359
        return this.specialities;
//#endif

    }

//#endif


//#if -1138020447
    public HealthUnit(String description, List specialities)
    {

//#if -255473273
        this.description = description;
//#endif


//#if 2146963973
        this.specialities = specialities;
//#endif

    }

//#endif


//#if -996280657
    public void notifyObservers()
    {

//#if 1842014007
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1

//#if -26719503
            Observer observer = (Observer) it.next();
//#endif


//#if 1951194661
            try { //1

//#if 957818270
                observer.notify(this);
//#endif

            }

//#if -158211014
            catch (RemoteException e) { //1

//#if 891246663
                e.printStackTrace();
//#endif

            }

//#endif


//#if -713301060
            catch (ObjectNotValidException e) { //1

//#if 1261406842
                e.printStackTrace();
//#endif

            }

//#endif


//#if -123582270
            catch (ObjectNotFoundException e) { //1

//#if 1304050415
                e.printStackTrace();
//#endif

            }

//#endif


//#if 691091174
            catch (TransactionException e) { //1

//#if 102890532
                e.printStackTrace();
//#endif

            }

//#endif


//#if 970806590
            catch (RepositoryException e) { //1

//#if 392926104
                e.printStackTrace();
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif


//#if 892682453
    public void removeObserver(Observer observer)
    {

//#if -2058486042
        subscribers.remove(observer);
//#endif

    }

//#endif


//#if 2042631347
    public HealthUnit()
    {
    }
//#endif

}

//#endif


//#endif

