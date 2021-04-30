// Compilation Unit of /IteratorRMISourceAdapter.java 
 
package lib.distribution.rmi;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import lib.exceptions.CommunicationException;
import lib.util.IteratorDsk;
import lib.util.LocalIterator;
public class IteratorRMISourceAdapter implements IteratorDsk
, Serializable
  { 
private IIteratorRMITargetAdapter targetAdapter;
private Object[] cache;
private int index;
public void remove() throws CommunicationException
    {
}
public void close() throws CommunicationException
    { 
try //1
{ 
cache = null;
targetAdapter.close();
} 
catch (RemoteException e) //1
{ 
throw new CommunicationException(e.getMessage());
} 


} 

public void connect() throws CommunicationException
    { 
try //1
{ 
targetAdapter = (IIteratorRMITargetAdapter) Naming.lookup("//"
                            + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
} 
catch (Exception e) //1
{ 
throw new CommunicationException(e.getMessage());
} 


} 

public Object next() throws CommunicationException
    { 
if(index < cache.length)//1
{ 
if(cache[index] != null)//1
{ 
return cache[index++];
} 
else
{ 
return null;
} 

} 
else
if(cache.length == 0)//1
{ 
return null;
} 
else
{ 
try //1
{ 
cache = targetAdapter.getNext();
index = 0;
return next();
} 
catch (RemoteException e) //1
{ 
e.printStackTrace();
throw new CommunicationException(e.getMessage());
} 


} 


} 

public IteratorRMISourceAdapter(IIteratorRMITargetAdapter targetAdapter,
                                    LocalIterator iterator, int cacheSize)
    { 
this.targetAdapter = targetAdapter;
cache = new Object[cacheSize];
for (int i = 0; (i < cacheSize) && iterator.hasNext(); i++) //1
{ 
cache[i] = iterator.next();
} 

index = 0;
} 

public boolean hasNext() throws CommunicationException
    { 
if(index < cache.length)//1
{ 
if(cache[index] != null)//1
{ 
return true;
} 
else
{ 
return false;
} 

} 
else
if(cache.length == 0)//1
{ 
return false;
} 
else
{ 
try //1
{ 
cache = targetAdapter.getNext();
index = 0;
return hasNext();
} 
catch (RemoteException e) //1
{ 
e.printStackTrace();
throw new CommunicationException(e.getMessage());
} 


} 


} 

public void print()
    { 
for (int i = 0; cache[i] != null; i++) //1
{ 
System.out.println("cache[" + i + "] = " + cache[i]);
} 

} 

 } 


