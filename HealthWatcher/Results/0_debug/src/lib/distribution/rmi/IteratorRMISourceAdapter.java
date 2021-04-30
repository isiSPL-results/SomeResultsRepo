
//#if -1898837654 
// Compilation Unit of /IteratorRMISourceAdapter.java 
 

//#if 1422994964 
package lib.distribution.rmi;
//#endif 


//#if -224899505 
import java.io.Serializable;
//#endif 


//#if -1684687560 
import java.rmi.Naming;
//#endif 


//#if 1573744589 
import java.rmi.RemoteException;
//#endif 


//#if -85421998 
import lib.exceptions.CommunicationException;
//#endif 


//#if 1435631295 
import lib.util.IteratorDsk;
//#endif 


//#if -2140626668 
import lib.util.LocalIterator;
//#endif 


//#if -806107529 
public class IteratorRMISourceAdapter implements 
//#if -1051295047 
IteratorDsk
//#endif 

, 
//#if 2103797268 
Serializable
//#endif 

  { 

//#if 610225046 
private IIteratorRMITargetAdapter targetAdapter;
//#endif 


//#if -163329496 
private Object[] cache;
//#endif 


//#if 579153578 
private int index;
//#endif 


//#if -1751427203 
public void remove() throws CommunicationException
    {
}
//#endif 


//#if -646837683 
public void close() throws CommunicationException
    { 

//#if -370650376 
try //1
{ 

//#if -1580824390 
cache = null;
//#endif 


//#if 802245105 
targetAdapter.close();
//#endif 

} 

//#if -1627755023 
catch (RemoteException e) //1
{ 

//#if -1758846506 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1619682879 
public void connect() throws CommunicationException
    { 

//#if 1142406799 
try //1
{ 

//#if 110225691 
targetAdapter = (IIteratorRMITargetAdapter) Naming.lookup("//"
                            + healthwatcher.Constants.SERVER_NAME + "/" + healthwatcher.Constants.SYSTEM_NAME);
//#endif 

} 

//#if 1575774054 
catch (Exception e) //1
{ 

//#if -357809306 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1705975223 
public Object next() throws CommunicationException
    { 

//#if 54161146 
if(index < cache.length)//1
{ 

//#if -67295060 
if(cache[index] != null)//1
{ 

//#if -1820352641 
return cache[index++];
//#endif 

} 
else
{ 

//#if -926089333 
return null;
//#endif 

} 

//#endif 

} 
else

//#if -811028063 
if(cache.length == 0)//1
{ 

//#if 967813470 
return null;
//#endif 

} 
else
{ 

//#if 715656013 
try //1
{ 

//#if -994809619 
cache = targetAdapter.getNext();
//#endif 


//#if -2132596249 
index = 0;
//#endif 


//#if 1289343494 
return next();
//#endif 

} 

//#if 150704455 
catch (RemoteException e) //1
{ 

//#if -1247667229 
e.printStackTrace();
//#endif 


//#if 355815096 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1741205263 
public IteratorRMISourceAdapter(IIteratorRMITargetAdapter targetAdapter,
                                    LocalIterator iterator, int cacheSize)
    { 

//#if -1702604608 
this.targetAdapter = targetAdapter;
//#endif 


//#if 1724214334 
cache = new Object[cacheSize];
//#endif 


//#if 1375832066 
for (int i = 0; (i < cacheSize) && iterator.hasNext(); i++) //1
{ 

//#if -1466881961 
cache[i] = iterator.next();
//#endif 

} 

//#endif 


//#if 1387118530 
index = 0;
//#endif 

} 

//#endif 


//#if 847043626 
public boolean hasNext() throws CommunicationException
    { 

//#if 1896307651 
if(index < cache.length)//1
{ 

//#if -2103335037 
if(cache[index] != null)//1
{ 

//#if 214269388 
return true;
//#endif 

} 
else
{ 

//#if -1637480454 
return false;
//#endif 

} 

//#endif 

} 
else

//#if 2079448983 
if(cache.length == 0)//1
{ 

//#if -680344612 
return false;
//#endif 

} 
else
{ 

//#if 421674726 
try //1
{ 

//#if -500943422 
cache = targetAdapter.getNext();
//#endif 


//#if 480527484 
index = 0;
//#endif 


//#if 1107931715 
return hasNext();
//#endif 

} 

//#if 10344588 
catch (RemoteException e) //1
{ 

//#if 5970707 
e.printStackTrace();
//#endif 


//#if 889606536 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 794933884 
public void print()
    { 

//#if 743580002 
for (int i = 0; cache[i] != null; i++) //1
{ 

//#if 1374970887 
System.out.println("cache[" + i + "] = " + cache[i]);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

