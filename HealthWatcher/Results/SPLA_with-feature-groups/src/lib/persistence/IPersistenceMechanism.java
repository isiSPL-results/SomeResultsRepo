// Compilation Unit of /IPersistenceMechanism.java

package lib.persistence;

//#if -459550434
import lib.exceptions.PersistenceMechanismException;
//#endif

import lib.exceptions.TransactionException;

//#if -38483218
import lib.exceptions.RepositoryException;
//#endif

public interface IPersistenceMechanism
{
    public void rollbackTransaction() throws TransactionException;
    public void beginTransaction() throws TransactionException;

//#if -1776319034
    public Object getCommunicationChannel() throws PersistenceMechanismException;
//#endif


//#if 1541281140
    public void disconnect() throws PersistenceMechanismException;
//#endif


//#if 510695734
    public Object getCommunicationChannel() throws RepositoryException;
//#endif


//#if -1295555996
    public void connect() throws RepositoryException;
//#endif


//#if -1726146518
    public void releaseCommunicationChannel() throws PersistenceMechanismException;
//#endif


//#if 977291876
    public void disconnect() throws RepositoryException;
//#endif


//#if -1813309286
    public void releaseCommunicationChannel() throws RepositoryException;
//#endif

    public void commitTransaction() throws TransactionException;

//#if -2006504076
    public void connect() throws PersistenceMechanismException;
//#endif

}


