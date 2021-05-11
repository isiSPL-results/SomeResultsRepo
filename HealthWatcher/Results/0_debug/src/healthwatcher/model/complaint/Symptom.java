
//#if -678689305
// Compilation Unit of /Symptom.java


//#if -398132578
package healthwatcher.model.complaint;
//#endif


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


//#if 853604581
public class Symptom implements
//#if 1293893477
    java.io.Serializable
//#endif

    ,
//#if -921396606
    Subject
//#endif

{

//#if -1410146472
    private int code;
//#endif


//#if -1064112855
    private String description;
//#endif


//#if 2072499898
    private List subscribers = new ArrayList();
//#endif


//#if -19063643
    public void addObserver(Observer observer)
    {

//#if 180977496
        subscribers.add(observer);
//#endif

    }

//#endif


//#if -794355613
    public Symptom(String descricao)
    {

//#if 1130121485
        this.description = descricao;
//#endif

    }

//#endif


//#if 385779307
    public String getDescription()
    {

//#if -253854087
        return this.description;
//#endif

    }

//#endif


//#if 370542245
    public void setDescription(String description)
    {

//#if 720204865
        this.description = description;
//#endif


//#if 338938741
        notifyObservers();
//#endif

    }

//#endif


//#if -19825162
    public void removeObserver(Observer observer)
    {

//#if -459547298
        subscribers.remove(observer);
//#endif

    }

//#endif


//#if 856538440
    public int getCode()
    {

//#if -330758649
        return this.code;
//#endif

    }

//#endif


//#if -1125351999
    public void setCode(int codigo)
    {

//#if 50988001
        this.code = codigo;
//#endif

    }

//#endif


//#if 341654446
    public void notifyObservers()
    {

//#if -1204735864
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1

//#if 213482533
            Observer observer = (Observer) it.next();
//#endif


//#if 1508508529
            try { //1

//#if -625886216
                observer.notify(this);
//#endif

            }

//#if -542155684
            catch (RemoteException e) { //1

//#if -1569958639
                e.printStackTrace();
//#endif

            }

//#endif


//#if 381163998
            catch (ObjectNotValidException e) { //1

//#if -1612324086
                e.printStackTrace();
//#endif

            }

//#endif


//#if 970882788
            catch (ObjectNotFoundException e) { //1

//#if 1358534426
                e.printStackTrace();
//#endif

            }

//#endif


//#if 1774420996
            catch (TransactionException e) { //1

//#if 548911653
                e.printStackTrace();
//#endif

            }

//#endif


//#if -379720608
            catch (RepositoryException e) { //1

//#if 741719384
                e.printStackTrace();
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

