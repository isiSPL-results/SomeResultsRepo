
//#if 568549645
// Compilation Unit of /Observer.java

package lib.patterns.observer;

//#if -682629371
import java.rmi.RemoteException;
//#endif


//#if 1147881058
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -17994148
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 1715333598
import lib.exceptions.RepositoryException;
//#endif


//#if 1572733730
import lib.exceptions.TransactionException;
//#endif

public interface Observer
{
    public void notify(Subject subject) throws RemoteException, TransactionException, ObjectNotFoundException, RepositoryException,ObjectNotValidException;
}


//#endif

