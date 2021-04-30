package lib.distribution.rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lib.util.LocalIterator;
public class IteratorRMITargetAdapter extends UnicastRemoteObject
 implements IIteratorRMITargetAdapter
  { 
private LocalIterator iterator;
private int cacheSize;
public void close() throws RemoteException
    { 
iterator = null;
} 
public IteratorRMITargetAdapter(LocalIterator i, int cacheSize) throws RemoteException
    { 
iterator = i;
this.cacheSize = cacheSize;
} 
public Object[] getNext() throws RemoteException /*,CommunicationException*/
    { 
Object[] cache = new Object[cacheSize];
for (int i = 0; (i < cacheSize) && iterator.hasNext(); i++) //1
{ 
cache[i] = iterator.next();
} 
return cache;
} 

 } 
