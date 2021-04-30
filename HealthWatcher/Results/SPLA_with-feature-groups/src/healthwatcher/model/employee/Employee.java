// Compilation Unit of /Employee.java 
 
package healthwatcher.model.employee;
import java.io.Serializable;

//#if 2028078928 
import java.rmi.RemoteException;
//#endif 


//#if 688533298 
import java.util.ArrayList;
//#endif 


//#if -1241523937 
import java.util.Iterator;
//#endif 


//#if -727003153 
import java.util.List;
//#endif 


//#if 2131593069 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 965717863 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -290953111 
import lib.exceptions.RepositoryException;
//#endif 


//#if -492612105 
import lib.exceptions.TransactionException;
//#endif 


//#if 1358086721 
import lib.patterns.observer.Observer;
//#endif 


//#if 673374963 
import lib.patterns.observer.Subject;
//#endif 

public class Employee implements Serializable
, 
//#if 1146823376 
Subject
//#endif 

  { 
private String name;
private String login;
private String password;

//#if 941868204 
private List subscribers = new ArrayList();
//#endif 

public String getPassword()
    { 
return password;
} 

public void setName(String name)
    { 
this.name = name;

//#if 608162548 
notifyObservers();
//#endif 

} 

public String getLogin()
    { 
return login;
} 


//#if 1235915004 
public void notifyObservers()
    { 
for (Iterator it = subscribers.iterator(); it.hasNext();) //1
{ 
Observer observer = (Observer) it.next();
try //1
{ 
observer.notify(this);
} 

//#if -499782099 
catch (RemoteException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 33311407 
catch (ObjectNotValidException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 623030197 
catch (ObjectNotFoundException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if -564892461 
catch (TransactionException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if 1068838321 
catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 

//#endif 


} 

} 

//#endif 

public void setLogin(String login)
    { 
this.login = login;

//#if 267848857 
notifyObservers();
//#endif 

} 

public boolean validatePassword(String password)
    { 
return this.password.equals(password);
} 


//#if -708907789 
public void addObserver(Observer observer)
    { 
subscribers.add(observer);
} 

//#endif 

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

//#if -325052389 
notifyObservers();
//#endif 

} 


//#if 251732712 
public void removeObserver(Observer observer)
    { 
subscribers.remove(observer);
} 

//#endif 

 } 


