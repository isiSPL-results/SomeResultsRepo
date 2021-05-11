// Compilation Unit of /Symptom.java

package healthwatcher.model.complaint;

//#if -444803346
import java.rmi.RemoteException;
//#endif


//#if -2038983468
import java.util.ArrayList;
//#endif


//#if 610154301
import java.util.Iterator;
//#endif


//#if -541528819
import java.util.List;
//#endif


//#if -1233278325
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1895813765
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -1267545465
import lib.exceptions.RepositoryException;
//#endif


//#if -702204007
import lib.exceptions.TransactionException;
//#endif


//#if 839836511
import lib.patterns.observer.Observer;
//#endif


//#if -728816107
import lib.patterns.observer.Subject;
//#endif

public class Symptom implements java.io.Serializable
    ,
//#if -921396606
    Subject
//#endif

{
    private int code;
    private String description;

//#if 2072499898
    private List subscribers = new ArrayList();
//#endif


//#if -19063643
    public void addObserver(Observer observer)
    {
        subscribers.add(observer);
    }

//#endif

    public Symptom(String descricao)
    {
        this.description = descricao;
    }

    public String getDescription()
    {
        return this.description;
    }


//#if 370542245
    public void setDescription(String description)
    {
        this.description = description;
        notifyObservers();
    }

//#endif


//#if -19825162
    public void removeObserver(Observer observer)
    {
        subscribers.remove(observer);
    }

//#endif

    public int getCode()
    {
        return this.code;
    }

    public void setCode(int codigo)
    {
        this.code = codigo;
    }


//#if 341654446
    public void notifyObservers()
    {
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1
            Observer observer = (Observer) it.next();
            try { //1
                observer.notify(this);
            }

//#if -542155684
            catch (RemoteException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 381163998
            catch (ObjectNotValidException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 970882788
            catch (ObjectNotFoundException e) { //1
                e.printStackTrace();
            }

//#endif


//#if 1774420996
            catch (TransactionException e) { //1
                e.printStackTrace();
            }

//#endif


//#if -379720608
            catch (RepositoryException e) { //1
                e.printStackTrace();
            }

//#endif


        }

    }

//#endif

}


