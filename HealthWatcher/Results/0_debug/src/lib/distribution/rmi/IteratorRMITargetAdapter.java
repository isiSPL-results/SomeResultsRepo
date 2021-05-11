
//#if -300721297
// Compilation Unit of /IteratorRMITargetAdapter.java


//#if 167470568
package lib.distribution.rmi;
//#endif


//#if -1178323079
import java.rmi.RemoteException;
//#endif


//#if 1139362987
import java.rmi.server.UnicastRemoteObject;
//#endif


//#if 1887790016
import lib.util.LocalIterator;
//#endif


//#if -1034461715
public class IteratorRMITargetAdapter extends
//#if 437741371
    UnicastRemoteObject
//#endif

    implements
//#if -804012882
    IIteratorRMITargetAdapter
//#endif

{

//#if -544515138
    private LocalIterator iterator;
//#endif


//#if -1755416323
    private int cacheSize;
//#endif


//#if -1620555399
    public void close() throws RemoteException
    {

//#if -1666914468
        iterator = null;
//#endif

    }

//#endif


//#if -1697937701
    public IteratorRMITargetAdapter(LocalIterator i, int cacheSize) throws RemoteException
    {

//#if -1885994164
        iterator = i;
//#endif


//#if -74606067
        this.cacheSize = cacheSize;
//#endif

    }

//#endif


//#if -350157126
    public Object[] getNext() throws RemoteException /*,CommunicationException*/
    {

//#if -2025469375
        Object[] cache = new Object[cacheSize];
//#endif


//#if 1015585502
        for (int i = 0; (i < cacheSize) && iterator.hasNext(); i++) { //1

//#if -767068728
            cache[i] = iterator.next();
//#endif

        }

//#endif


//#if 1650866641
        return cache;
//#endif

    }

//#endif

}

//#endif


//#endif

