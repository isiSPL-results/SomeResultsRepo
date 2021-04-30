// Compilation Unit of /MedicalSpeciality.java 
 
package healthwatcher.model.healthguide;

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

public class MedicalSpeciality implements java.io.Serializable
, 
//#if -1017485891 
Subject
//#endif 

  { 
private int codigo;
private String descricao;

//#if 510092319 
private List subscribers = new ArrayList();
//#endif 

public void setCodigo(int cod)
    { 
this.codigo = cod;
} 


//#if 1812994921 
public void notifyObservers()
    { 
for (Iterator it = subscribers.iterator(); it.hasNext();) //1
{ 
Observer observer = (Observer) it.next();
try //1
{ 
observer.notify(this);
} 

//#if -2012977430 
catch (RemoteException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if -2074560916 
catch (ObjectNotValidException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if -1484842126 
catch (ObjectNotFoundException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if -1319837130 
catch (TransactionException e) //1
{ 
e.printStackTrace();
} 

//#endif 


//#if -202440722 
catch (RepositoryException e) //1
{ 
e.printStackTrace();
} 

//#endif 


} 

} 

//#endif 


//#if -491663141 
public void removeObserver(Observer observer)
    { 
subscribers.remove(observer);
} 

//#endif 

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

//#if 1055320214 
notifyObservers();
//#endif 

} 


//#if -1209058336 
public void addObserver(Observer observer)
    { 
subscribers.add(observer);
} 

//#endif 

 } 


