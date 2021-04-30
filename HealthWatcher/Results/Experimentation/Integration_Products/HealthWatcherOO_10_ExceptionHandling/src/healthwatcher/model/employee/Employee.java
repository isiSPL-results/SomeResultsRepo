package healthwatcher.model.employee;
import java.io.Serializable;
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
public class Employee implements Serializable
,Subject
  { 
private String name;
private String login;
private String password;
private List subscribers = new ArrayList();
public String getPassword()
    { 
return password;
} 
public void setName(String name)
    { 
this.name = name;
notifyObservers();
} 
public String getLogin()
    { 
return login;
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
public void setLogin(String login)
    { 
this.login = login;
notifyObservers();
} 
public boolean validatePassword(String password)
    { 
return this.password.equals(password);
} 
public void addObserver(Observer observer)
    { 
subscribers.add(observer);
} 
public String getName()
    { 
return name;
} 
public Employee(String login, String password, String name)
    { 
this.name = name;
this.login = login;
this.password = password;
} 
public void setPassword(String password)
    { 
this.password = password;
notifyObservers();
} 
public void removeObserver(Observer observer)
    { 
subscribers.remove(observer);
} 

 } 
