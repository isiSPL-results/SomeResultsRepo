package healthwatcher.model.healthguide;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.exceptions.TransactionException;
import lib.patterns.observer.Observer;
import lib.patterns.observer.Subject;
public class MedicalSpeciality implements java.io.Serializable
,Subject
  { 
private int codigo;
private String descricao;
private List subscribers = new ArrayList();
public void setCodigo(int cod)
    { 
this.codigo = cod;
} 
public void notifyObservers()
    { 
for (Iterator it = subscribers.iterator(); it.hasNext();) //1
{ 
Observer observer = (Observer) it.next();
try//1
{ 
observer.notify(this);
} 
catch (RemoteException e) //1
{ 
e.printStackTrace();
} 
catch (ObjectNotValidException e) //1
{ 
e.printStackTrace();
} 
catch (ObjectNotFoundException e) //1
{ 
e.printStackTrace();
} 
catch (TransactionException e) //1
{ 
e.printStackTrace();
} 
catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 
} 
} 
public void removeObserver(Observer observer)
    { 
subscribers.remove(observer);
} 
public String getDescricao()
    { 
return this.descricao;
} 
public MedicalSpeciality(String descricao)
    { 
this.descricao = descricao;
} 
public String toString()
    { 
return descricao;
} 
public int getCodigo()
    { 
return this.codigo;
} 
public void setDescricao(String descricao)
    { 
this.descricao = descricao;
notifyObservers();
} 
public void addObserver(Observer observer)
    { 
subscribers.add(observer);
} 

 } 
