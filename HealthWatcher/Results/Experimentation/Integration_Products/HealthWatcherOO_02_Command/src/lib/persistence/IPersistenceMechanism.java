package lib.persistence;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.TransactionException;
public interface IPersistenceMechanism  { 
public void rollbackTransaction() throws TransactionException;public void beginTransaction() throws TransactionException;public Object getCommunicationChannel() throws PersistenceMechanismException;public void disconnect() throws PersistenceMechanismException;public void releaseCommunicationChannel() throws PersistenceMechanismException;public void commitTransaction() throws TransactionException;public void connect() throws PersistenceMechanismException;
 } 
