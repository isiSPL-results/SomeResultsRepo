
//#if 1855250285 
// Compilation Unit of /Employee.java 
 

//#if -1774232387 
package healthwatcher.model.employee;
//#endif 


//#if 2035490642 
import java.io.Serializable;
//#endif 


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


//#if 1366828756 
public class Employee implements 
//#if 921989595 
Serializable
//#endif 

, 
//#if 1146823376 
Subject
//#endif 

  { 

//#if 1994597336 
private String name;
//#endif 


//#if 1658473002 
private String login;
//#endif 


//#if -942587448 
private String password;
//#endif 


//#if 941868204 
private List subscribers = new ArrayList();
//#endif 


//#if -1353396228 
public String getPassword()
    { 

//#if -2092298134 
return password;
//#endif 

} 

//#endif 


//#if -1253259527 
public void setName(String name)
    { 

//#if -2130081760 
this.name = name;
//#endif 


//#if 608162548 
notifyObservers();
//#endif 

} 

//#endif 


//#if 1068582666 
public String getLogin()
    { 

//#if 1469153612 
return login;
//#endif 

} 

//#endif 


//#if 1235915004 
public void notifyObservers()
    { 

//#if -658421434 
for (Iterator it = subscribers.iterator(); it.hasNext();) //1
{ 

//#if 1469017258 
Observer observer = (Observer) it.next();
//#endif 


//#if 876695436 
try //1
{ 

//#if 531386457 
observer.notify(this);
//#endif 

} 

//#if -499782099 
catch (RemoteException e) //1
{ 

//#if -1114457375 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 33311407 
catch (ObjectNotValidException e) //1
{ 

//#if -1458029304 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 623030197 
catch (ObjectNotFoundException e) //1
{ 

//#if -1420243530 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if -564892461 
catch (TransactionException e) //1
{ 

//#if -1109744566 
e.printStackTrace();
//#endif 

} 

//#endif 


//#if 1068838321 
catch (RepositoryException e) //1
{ 

//#if 1983181388 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1696288999 
public void setLogin(String login)
    { 

//#if -444371197 
this.login = login;
//#endif 


//#if 267848857 
notifyObservers();
//#endif 

} 

//#endif 


//#if -2143254807 
public boolean validatePassword(String password)
    { 

//#if 1931672132 
return this.password.equals(password);
//#endif 

} 

//#endif 


//#if -708907789 
public void addObserver(Observer observer)
    { 

//#if -604145014 
subscribers.add(observer);
//#endif 

} 

//#endif 


//#if -198122516 
public String getName()
    { 

//#if 24608167 
return name;
//#endif 

} 

//#endif 


//#if -79307082 
public Employee(String login, String password, String name)
    { 

//#if 180568677 
this.name = name;
//#endif 


//#if -396415411 
this.login = login;
//#endif 


//#if 1256362597 
this.password = password;
//#endif 

} 

//#endif 


//#if -616696071 
public void setPassword(String password)
    { 

//#if 1335937113 
this.password = password;
//#endif 


//#if -325052389 
notifyObservers();
//#endif 

} 

//#endif 


//#if 251732712 
public void removeObserver(Observer observer)
    { 

//#if 933068590 
subscribers.remove(observer);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

