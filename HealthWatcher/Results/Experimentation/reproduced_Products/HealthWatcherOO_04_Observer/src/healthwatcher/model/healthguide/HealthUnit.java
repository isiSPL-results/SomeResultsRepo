package healthwatcher.model.healthguide;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.patterns.observer.Observer;
import lib.patterns.observer.Subject;
public class HealthUnit implements Serializable
    ,Subject
{
    private int code;
    private String description;
    private List specialities;
    private List subscribers = new ArrayList();
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
        notifyObservers();
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
    public void addObserver(Observer observer)
    {
        subscribers.add(observer);
    }
    public List getSpecialities()
    {
        return this.specialities;
    }
    public HealthUnit(String description, List specialities)
    {
        this.description = description;
        this.specialities = specialities;
    }
    public void notifyObservers()
    {
        for (Iterator it = subscribers.iterator(); it.hasNext();) { //1
            Observer observer = (Observer) it.next();
            try { //1
                observer.notify(this);
            } catch (RemoteException e) { //1
                e.printStackTrace();
            } catch (ObjectNotValidException e) { //1
                e.printStackTrace();
            } catch (ObjectNotFoundException e) { //1
                e.printStackTrace();
            } catch (TransactionException e) { //1
                e.printStackTrace();
            } catch (RepositoryException e) { //1
                e.printStackTrace();
            }
        }
    }
    public void removeObserver(Observer observer)
    {
        subscribers.remove(observer);
    }
    public HealthUnit()
    {
    }
}
