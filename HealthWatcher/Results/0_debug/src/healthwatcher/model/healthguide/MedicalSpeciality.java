
//#if 1817980559
// Compilation Unit of /MedicalSpeciality.java


//#if 211828831
package healthwatcher.model.healthguide;
//#endif


//#if 1550904580
import java.rmi.RemoteException;
//#endif


//#if -1224242946
import java.util.ArrayList;
//#endif


//#if -1857415725
import java.util.Iterator;
//#endif


//#if -682129757
import java.util.List;
//#endif


//#if -2039586271
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1089505819
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 2104147229
import lib.exceptions.RepositoryException;
//#endif


//#if 741054403
import lib.exceptions.TransactionException;
//#endif


//#if -152858379
import lib.patterns.observer.Observer;
//#endif


//#if 1178824127
import lib.patterns.observer.Subject;
//#endif


//#if -1344157652
public class MedicalSpeciality implements
//#if -671560694
    java.io.Serializable
//#endif

    ,
//#if -1017485891
    Subject
//#endif

{

//#if -852219097
    private int codigo;
//#endif


//#if -768746441
    private String descricao;
//#endif


//#if 510092319
    private List subscribers = new ArrayList();
//#endif


//#if 1405689831
    public void setCodigo(int cod)
    {

//#if -1377901228
        this.codigo = cod;
//#endif

    }

//#endif


//#if 1812994921
    public void notifyObservers()
    {

//#if -1523016194
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1

//#if -996975956
            Observer observer = (Observer) it.next();
//#endif


//#if -1725720118
            try { //1

//#if 1509194052
                observer.notify(this);
//#endif

            }

//#if -2012977430
            catch (RemoteException e) { //1

//#if -401091792
                e.printStackTrace();
//#endif

            }

//#endif


//#if -2074560916
            catch (ObjectNotValidException e) { //1

//#if -626519106
                e.printStackTrace();
//#endif

            }

//#endif


//#if -1484842126
            catch (ObjectNotFoundException e) { //1

//#if -354709980
                e.printStackTrace();
//#endif

            }

//#endif


//#if -1319837130
            catch (TransactionException e) { //1

//#if -1027378130
                e.printStackTrace();
//#endif

            }

//#endif


//#if -202440722
            catch (RepositoryException e) { //1

//#if 1888616069
                e.printStackTrace();
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif


//#if -491663141
    public void removeObserver(Observer observer)
    {

//#if 1179576556
        subscribers.remove(observer);
//#endif

    }

//#endif


//#if -188167715
    public String getDescricao()
    {

//#if -1206303480
        return this.descricao;
//#endif

    }

//#endif


//#if 1741933003
    public MedicalSpeciality(String descricao)
    {

//#if -1745432961
        this.descricao = descricao;
//#endif

    }

//#endif


//#if -1985569034
    public String toString()
    {

//#if -97257473
        return descricao;
//#endif

    }

//#endif


//#if 834872601
    public int getCodigo()
    {

//#if 1706521635
        return this.codigo;
//#endif

    }

//#endif


//#if -750934202
    public void setDescricao(String descricao)
    {

//#if -1140594778
        this.descricao = descricao;
//#endif


//#if 1055320214
        notifyObservers();
//#endif

    }

//#endif


//#if -1209058336
    public void addObserver(Observer observer)
    {

//#if 1341396498
        subscribers.add(observer);
//#endif

    }

//#endif

}

//#endif


//#endif

