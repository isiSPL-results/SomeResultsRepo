// Compilation Unit of /HealthUnit.java

package healthwatcher.model.healthguide;
import java.util.Iterator;
import java.util.List;

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
    private int code;
    private String description;
    private List specialities;

//#if -289021671
    private List subscribers = new ArrayList();
//#endif

    public boolean hasSpeciality(int code)
    {
        for(Iterator i = specialities.iterator(); i.hasNext();) { //1
            MedicalSpeciality m = (MedicalSpeciality) i.next();
            if(m.getCodigo() == code) { //1
                return true;
            }

        }

        return false;
    }

    public void setDescription(String descricao)
    {
        this.description = descricao;

//#if -1980603780
        notifyObservers();
//#endif

    }

    public String getDescription()
    {
        return this.description;
    }

    public int getCode()
    {
        return this.code;
    }

    public void setCode(int cod)
    {
        this.code = cod;
    }

    public String toString()
    {
        return description;
    }


//#if -211788250
    public void addObserver(Observer observer)
    {
        subscribers.add(observer);
    }

//#endif

    public List getSpecialities()
    {
        return this.specialities;
    }

    public HealthUnit(String description, List specialities)
    {
        this.description = description;
        this.specialities = specialities;
    }


//#if -996280657
    public void notifyObservers()
    {
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1
            Observer observer = (Observer) it.next();
            try { //1
                observer.notify(this);
            }

//#if -158211014
            catch (RemoteException e) { //1
                e.printStackTrace();
            }

//#endif


//#if -713301060
            catch (ObjectNotValidException e) { //1
                e.printStackTrace();
            }

//#endif


//#if -123582270
            catch (ObjectNotFoundException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 691091174
            catch (TransactionException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 970806590
            catch (RepositoryException e) { //1
                e.printStackTrace();
            }

//#endif


        }

    }

//#endif


//#if 892682453
    public void removeObserver(Observer observer)
    {
        subscribers.remove(observer);
    }

//#endif

    public HealthUnit()
    {
    }
}


