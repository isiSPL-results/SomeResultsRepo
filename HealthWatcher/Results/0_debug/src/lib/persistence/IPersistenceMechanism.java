
//#if 1601779942 
// Compilation Unit of /IPersistenceMechanism.java 
 

//#if -1357393113 
package lib.persistence;
//#endif 


//#if -459550434 
import lib.exceptions.PersistenceMechanismException;
//#endif 


//#if -1255980014 
import lib.exceptions.TransactionException;
//#endif 


//#if -38483218 
import lib.exceptions.RepositoryException;
//#endif 


//#if 617945943 
public interface IPersistenceMechanism  { 

//#if -2010365022 
public void rollbackTransaction() throws TransactionException;
//#endif 


//#if -1180596789 
public void beginTransaction() throws TransactionException;
//#endif 


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


//#if -587005905 
public void commitTransaction() throws TransactionException;
//#endif 


//#if -2006504076 
public void connect() throws PersistenceMechanismException;
//#endif 

 } 

//#endif 


//#endif 

