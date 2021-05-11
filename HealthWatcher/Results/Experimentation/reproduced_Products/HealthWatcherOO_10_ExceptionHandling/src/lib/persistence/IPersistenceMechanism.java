package lib.persistence;
import lib.exceptions.TransactionException;
import lib.exceptions.RepositoryException;
public interface IPersistenceMechanism
{
    public void rollbackTransaction() throws TransactionException;
    public void beginTransaction() throws TransactionException;
    public Object getCommunicationChannel() throws RepositoryException;
    public void connect() throws RepositoryException;
    public void disconnect() throws RepositoryException;
    public void releaseCommunicationChannel() throws RepositoryException;
    public void commitTransaction() throws TransactionException;
}
