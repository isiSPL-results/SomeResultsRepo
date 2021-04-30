package healthwatcher.model.complaint;
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
public class Symptom implements java.io.Serializable
,Subject
  { 
private int code;
private String description;
private List subscribers = new ArrayList();
public void addObserver(Observer observer)
    { 
subscribers.add(observer);
} 
public Symptom(String descricao)
    { 
this.description = descricao;
} 
public String getDescription()
    { 
return this.description;
} 
public void setDescription(String description)
    { 
this.description = description;
notifyObservers();
} 
public void removeObserver(Observer observer)
    { 
subscribers.remove(observer);
} 
public int getCode()
    { 
return this.code;
} 
public void setCode(int codigo)
    { 
this.code = codigo;
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

 } 
